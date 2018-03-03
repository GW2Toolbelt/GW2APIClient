/*
 * Copyright 2018 Leon Linhart
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package gw2api

import kotlinx.coroutines.experimental.*
import java.io.*
import kotlin.coroutines.experimental.*
import okhttp3.*
import okhttp3.Callback as OkHttpCallback
import okhttp3.Request as OkHttpRequest
import okhttp3.Response as OkHttpResponse

private val httpClient = OkHttpClient()

internal actual fun <T> Continuation<Response<T>>.queryNetwork(url: String, cacheTime: Int, overrideCacheTime: Boolean, conv: (String) -> T, cache: (Response<T>) -> Unit) {
    httpClient.newCall(OkHttpRequest.Builder()
        .url(url)
        .cacheControl(CacheControl.FORCE_NETWORK)
        .build()
    ).enqueue(object : OkHttpCallback {
        override fun onResponse(call: Call, httpResponse: okhttp3.Response) {
            if (httpResponse.isSuccessful) {
                val date = httpResponse.headers().getDate("date")!!.toInstant().toEpochMilli()
                val expires = httpResponse.headers().getDate("expires").let {
                    if (it === null || overrideCacheTime)
                        if (cacheTime > 0) date + cacheTime else 0L
                    else
                        it.toInstant().toEpochMilli()
                }

                val response = Response(
                    data = httpResponse.body()?.let { conv.invoke(it.string()) },
                    expirationDate = expires
                )

                cache.invoke(response)
                resume(response)
            } else {
                resumeWithException(IllegalStateException(httpResponse.message()))
            }
        }

        override fun onFailure(call: Call, e: IOException) {
            resumeWithException(e)
        }
    })
}

actual class Request<out T> internal actual constructor(
    actual val url: String,
    actual val endpoint: String,
    private val response: Deferred<Response<T>>
) {

    actual suspend fun get(): Response<T> = suspendCoroutine { continuation ->
        response.invokeOnCompletion {
            if (response.isCompletedExceptionally)
                continuation.resumeWithException(response.getCompletionExceptionOrNull()!!)
            else
                continuation.resume(response.getCompleted())
        }
    }

    fun await(): Response<T> = runBlocking { response.await() }

    actual fun then(action: (Response<T>) -> Unit) {
        response.invokeOnCompletion {
            action.invoke(response.getCompleted())
        }
    }

}
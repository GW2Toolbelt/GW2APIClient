/*
 * Copyright (c) 2018-2021 Leon Linhart
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
rootProject.name = "GW2APIClient"

pluginManagement {
    /*
     * Workaround since Dokka is not published under the expected coordinates to Central [1] and not yet published to
     * the plugin portal again [2].
     *
     * [1] https://github.com/Kotlin/dokka/issues/1779
     * [2] https://github.com/Kotlin/dokka/issues/1775
     */
    resolutionStrategy {
        eachPlugin {
            if (requested.id.id == "org.jetbrains.dokka") {
                useModule("org.jetbrains.dokka:dokka-gradle-plugin:${requested.version}")
            }
        }
    }
    repositories {
        mavenCentral()
        gradlePluginPortal()
    }
}

file("modules").listFiles(File::isDirectory)!!.forEach { dir ->
    fun hasBuildscript(it: File) = File(it, "build.gradle.kts").exists()

    if (hasBuildscript(dir)) {
        val projectName = dir.name

        include(projectName)
        project(":$projectName").projectDir = dir
    }
}
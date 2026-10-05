pluginManagement {
    repositories {
        google {
            mavenContent {
                includeGroupAndSubgroups("androidx")
                includeGroupAndSubgroups("com.android")
                includeGroupAndSubgroups("com.google")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}

plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "1.0.0"
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google {
            mavenContent {
                includeGroupAndSubgroups("androidx")
                includeGroupAndSubgroups("com.android")
                includeGroupAndSubgroups("com.google")
            }
        }
        mavenCentral()
        maven {
            url = uri("https://jitpack.io")
            content { includeGroup("com.github.guolindev") }
        }
    }
}

rootProject.name = "FYT Launcher Mod"
include(":app")
include(":baselineprofile")
// The folder is "baselineProfile": the same on Windows, but a case-sensitive file system (Linux, CI)
// would not find it under the project's name.
project(":baselineprofile").projectDir = file("baselineProfile")
include(":hiddenapi-stubs")

// The VD host daemon. Built as an APK only because app_process takes an APK (or jar) with a
// classes.dex as CLASSPATH; it has no components and is never installed.
//
//   ./gradlew :vdhost-server:magiskZip   ->  vdhost/server/build/outputs/magisk/FYT-VDHost-<version>.zip
plugins {
    alias(libs.plugins.android.application)
}

val moduleVersion = "1.0.0"
val moduleVersionCode = 1

android {
    namespace = "com.syu.vdhost.server"
    compileSdk = 37

    defaultConfig {
        applicationId = "com.syu.vdhost.server"
        minSdk = 30
        targetSdk = 36
        versionCode = moduleVersionCode
        versionName = moduleVersion
    }

    buildTypes {
        release {
            // app_process looks the entry point up by name.
            isMinifyEnabled = false
            // Never installed, so any key will do.
            signingConfig = signingConfigs.getByName("debug")
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_21
        targetCompatibility = JavaVersion.VERSION_21
    }

    lint {
        checkReleaseBuilds = false
    }
}

dependencies {
    implementation(project(":vdhost-shared"))
}

val magiskTemplate = layout.projectDirectory.dir("../magisk")

val magiskZip by tasks.registering(Zip::class) {
    group = "build"
    description = "Packages the daemon into a flashable Magisk module."
    dependsOn("assembleRelease")

    archiveFileName.set("FYT-VDHost-$moduleVersion.zip")
    destinationDirectory.set(layout.buildDirectory.dir("outputs/magisk"))

    from(magiskTemplate) {
        exclude("module.prop")
    }
    // Local copies: a lambda that reads the script's own vals captures the script object, which
    // the configuration cache cannot serialize.
    val version = moduleVersion
    val versionCode = moduleVersionCode.toString()
    from(magiskTemplate.file("module.prop")) {
        filter { line ->
            line.replace("@VERSION@", version)
                .replace("@VERSION_CODE@", versionCode)
        }
    }
    from(layout.buildDirectory.dir("outputs/apk/release")) {
        include("*.apk")
        rename { "vdhost.apk" }
    }
}

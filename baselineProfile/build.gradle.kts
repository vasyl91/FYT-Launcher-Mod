// baselineprofile/build.gradle.kts
// AGP 9.x: built-in Kotlin - do NOT add the org.jetbrains.kotlin.android plugin.
plugins {
    alias(libs.plugins.android.test)
    alias(libs.plugins.baselineprofile)
}

android {
    namespace = "com.android.launcher66.baselineprofile"
    compileSdk = 37

    defaultConfig {
        // BaselineProfileRule requires API 28+. The head unit runs API 29 - OK.
        minSdk = 28
        targetSdk = 36
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        // Car head unit: no battery / unusual build fingerprint / no lock screen.
        // Without this Macrobenchmark may throw AssertionError "ERRORS (not suppressed)".
        testInstrumentationRunnerArguments["androidx.benchmark.suppressErrors"] =
            "EMULATOR,LOW-BATTERY,UNLOCKED"

        // Slower eMMC storage in FYT units - give ART more time to write the profile.
        testInstrumentationRunnerArguments["androidx.benchmark.saveProfileWaitMillis"] = "3000"
    }

    // The app the profile is collected for.
    targetProjectPath = ":app"

    // ESSENTIAL for UID 1000: the test APK instruments ITSELF and drives the launcher through
    // shell / UiAutomator, so the test APK does NOT need to be signed with the platform key.
    experimentalProperties["android.experimental.self-instrumenting"] = true

    // Same flavors as in :app - the plugin pairs the variants (fyt -> fytNonMinifiedRelease).
    flavorDimensions += "device"
    productFlavors {
        create("phone") { dimension = "device" }
        create("fyt") { dimension = "device" }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_21
        targetCompatibility = JavaVersion.VERSION_21
    }
}

androidComponents {
    // Profiles are generated only for the fyt flavor (system app on FYT head units).
    beforeVariants { v ->
        if (v.productFlavors.any { it.second == "phone" }) v.enable = false
    }
}

baselineProfile {
    // Physical device connected over ADB (no Gradle Managed Devices).
    useConnectedDevices = true
}

dependencies {
    implementation(libs.androidx.junit)
    implementation(libs.androidx.test.runner)
    // Macrobenchmark 1.5.x brings UiAutomator 2.4 as an api dependency.
    implementation(libs.androidx.benchmark.macro.junit4)
}

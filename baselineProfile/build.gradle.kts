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

    // Only fyt (system app on FYT head units). The flavor must be declared so the variants are
    // fytNonMinifiedRelease / fytBenchmarkRelease and target the matching fyt builds of :app.
    flavorDimensions += "device"
    productFlavors {
        create("fyt") { dimension = "device" }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_21
        targetCompatibility = JavaVersion.VERSION_21
    }
}

androidComponents {
    // The plugin enables only its own variants here (debug is disabled), so with the single fyt
    // flavor this module has exactly:
    // fytNonMinifiedRelease - generates the profile (default in Android Studio),
    // fytBenchmarkRelease   - StartupBenchmark.
    // TestBuildType does not expose isDefault in the public DSL; this relies on AGP using one
    // implementation class for build types of all module types (it also implements
    // ApplicationBuildType). nonMinifiedRelease is created by the plugin in its own finalizeDsl,
    // which runs before this one. If a future AGP changes that, the safe cast only logs a warning.
    finalizeDsl { extension ->
        val nonMinified = extension.buildTypes.findByName("nonMinifiedRelease")
        val appBuildType = nonMinified as? com.android.build.api.dsl.ApplicationBuildType
        if (appBuildType != null) {
            appBuildType.isDefault = true
        } else {
            logger.warn(
                "baselineprofile: cannot mark nonMinifiedRelease as default, " +
                    "select fytNonMinifiedRelease in Build Variants manually."
            )
        }
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

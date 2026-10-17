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
        // BaselineProfileRule requires API 28+. The head unit runs API 29 - OK; phones from
        // Android 13 (API 33) on need no root for it.
        minSdk = 28
        targetSdk = 36
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        // Car head unit: no battery / unusual build fingerprint / no lock screen (harmless on a
        // phone). Without this Macrobenchmark may throw AssertionError "ERRORS (not suppressed)".
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

    // The same flavors as :app, so each variant targets the matching build: fyt for FYT units
    // (a system app, installs nowhere else), phone for every other device. The profile they
    // make is the same file, used by both builds.
    flavorDimensions += "device"
    productFlavors {
        create("phone") { dimension = "device" }
        // Default in Android Studio, like :app's fyt: set in finalizeDsl below.
        create("fyt") { dimension = "device" }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_21
        targetCompatibility = JavaVersion.VERSION_21
    }
}

androidComponents {
    // The plugin enables only its own variants here (debug is disabled), so per flavor (phone,
    // fyt) this module has exactly:
    // <flavor>NonMinifiedRelease - generates the profile (default in Android Studio),
    // <flavor>BenchmarkRelease   - StartupBenchmark.
    // TestBuildType does not expose isDefault in the public DSL; this relies on AGP using one
    // implementation class for build types of all module types (it also implements
    // ApplicationBuildType). nonMinifiedRelease is created by the plugin in its own finalizeDsl,
    // which runs before this one. If a future AGP changes that, the safe cast only logs a warning.
    finalizeDsl { extension ->
        // TestProductFlavor has no isDefault either; the same one implementation class applies.
        val fyt = extension.productFlavors.findByName("fyt")
        (fyt as? com.android.build.api.dsl.ApplicationProductFlavor)?.isDefault = true
        val nonMinified = extension.buildTypes.findByName("nonMinifiedRelease")
        val appBuildType = nonMinified as? com.android.build.api.dsl.ApplicationBuildType
        if (appBuildType != null) {
            appBuildType.isDefault = true
        } else {
            logger.warn(
                "baselineprofile: cannot mark nonMinifiedRelease as default, " +
                    "select phone- or fytNonMinifiedRelease in Build Variants manually."
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

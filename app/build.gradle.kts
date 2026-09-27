import java.util.Properties

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.kotlin.parcelize)
    alias(libs.plugins.ksp)
    alias(libs.plugins.dependency.analysis)
    alias(libs.plugins.baselineprofile)            // Baseline Profile consumer side
}
val keystoreProperties = Properties().apply {
    val file = rootProject.file("keystore.properties")
    if (file.exists()) file.inputStream().use { load(it) }
}

fun keystoreProp(key: String, default: String): String =
    keystoreProperties.getProperty(key) ?: default

android {
    namespace = "com.android.launcher66"
    compileSdk = 37

    defaultConfig {
        applicationId = "com.android.launcher66"
        minSdk = 26
        targetSdk = 36

        val appVersionName = "1.2.1"
        versionName = appVersionName
        // 1.2.1 -> 10201; every release gets a higher versionCode automatically.
        // A higher versionCode in /oem/priv-app makes the system drop an older /data/app update.
        versionCode = appVersionName.split(".").map(String::toInt)
            .let { (major, minor, patch) -> major * 10_000 + minor * 100 + patch }

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        vectorDrawables {
            useSupportLibrary = true
        }
    }

    flavorDimensions += "device"
    productFlavors {
        create("phone") {
            dimension = "device"
        }
        create("fyt") {
            dimension = "device"
            // Android Studio selects this flavor by default (with release -> fytRelease).
            isDefault = true
        }
    }

    buildFeatures {
        buildConfig = true
        compose = true
    }

    signingConfigs {
        getByName("debug") {
            keyAlias = "android"
            keyPassword = "android"
            storeFile = file("keystore.jks")
            storePassword = "android"
        }
        create("release") {
            keyAlias = keystoreProp("keyAlias", "android")
            keyPassword = keystoreProp("keyPassword", "android")
            storeFile = rootProject.file(keystoreProp("storeFile", "app/keystore.jks"))
            storePassword = keystoreProp("storePassword", "android")
        }
    }

    buildTypes {
        release {
            // Default build type in Android Studio's Build Variants (with fyt -> fytRelease).
            isDefault = true
            signingConfig = signingConfigs.getByName("release")
            isCrunchPngs = true
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro",
                "proguard-widgets.pro"
            )
            buildConfigField("boolean", "IS_DEBUG_FEATURES_ENABLED", "false")
        }

        debug {
            isCrunchPngs = false
            enableUnitTestCoverage = true
            enableAndroidTestCoverage = true
            buildConfigField("boolean", "IS_DEBUG_FEATURES_ENABLED", "true")
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_21
        targetCompatibility = JavaVersion.VERSION_21
    }

    packaging {
        dex {
            useLegacyPackaging = false
        }
        resources {
            excludes += setOf(
                "/META-INF/{AL2.0,LGPL2.1}",
                "/META-INF/DEPENDENCIES",
                "/META-INF/LICENSE*",
                "/META-INF/NOTICE*",
                "/META-INF/*.kotlin_module",
                "/META-INF/*.version",
                "/META-INF/*.SF",
                "/META-INF/*.DSA",
                "/META-INF/*.RSA",
            )
        }
    }

    bundle {
        storeArchive {
            enable = false
        }
    }

    lint {
        // lintConfig = file("lint.xml")
        checkReleaseBuilds = false
    }
}

androidComponents {
    // initWith() also copies isDefault, so the Baseline Profile build types (nonMinifiedRelease,
    // benchmarkRelease) would inherit it from "release" -> AGP reports an ambiguous default build
    // type and Studio would not pick fytRelease. Keep the flag on "release" only. Runs after the
    // plugin's finalizeDsl (registered at plugin apply), so those types already exist.
    finalizeDsl { extension ->
        extension.buildTypes
            .filter { it.name != "release" }
            .forEach { it.isDefault = false }
    }

    // The Baseline Profile plugin adds nonMinified* and benchmark* build types for every
    // non-debuggable build type. Only the fyt ones are used:
    // fytNonMinifiedRelease - the generator installs and profiles it on the head unit,
    // fytBenchmarkRelease   - StartupBenchmark measures startup with the profile.
    // The generated profile itself is used by fytRelease (saved in src, see baselineProfile {}).
    beforeVariants { v ->
        val bt = v.buildType.orEmpty()
        val addedByPlugin = bt.startsWith("nonMinified") || bt.startsWith("benchmark")
        val used = v.name == "fytNonMinifiedRelease" || v.name == "fytBenchmarkRelease"
        if (addedByPlugin && !used) v.enable = false
    }

    onVariants { variant ->
        val flavor = variant.flavorName ?: ""
        val buildType = variant.buildType ?: ""

        variant.outputs.forEach { output ->
            if (output is com.android.build.api.variant.impl.VariantOutputImpl) {
                output.outputFileName = "${flavor}_${buildType}_${output.versionName.get()}.apk"
            }
        }
    }
}

// Baseline Profile consumer configuration
baselineProfile {
    // Do not generate on every assembleRelease (that would require a connected head unit).
    automaticGenerationDuringBuild = false
    // Save the result in src/ (committed to the repository).
    saveInSrc = true
    // Startup profile -> R8 places startup classes in the primary DEX file.
    dexLayoutOptimization = true
    // The Baseline Profile variants disabled above are intentional.
    warnings {
        disabledVariants = false
    }
}

tasks.withType<Test>().configureEach {
    useJUnitPlatform()
}

configurations.configureEach {
    exclude(group = "commons-logging", module = "commons-logging")
}

dependencies {
    val composeBom = platform(libs.androidx.compose.bom)
    implementation(composeBom)
    androidTestImplementation(composeBom)

    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))

    // ─── AndroidX ───
    implementation(libs.androidx.activity)
    implementation(libs.androidx.annotation)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.coordinatorlayout)
    implementation(libs.androidx.core)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.customview)
    implementation(libs.androidx.drawerlayout)
    implementation(libs.androidx.dynamicanimation)
    implementation(libs.androidx.fragment)
    implementation(libs.androidx.legacy.support.core.utils)
    implementation(libs.androidx.lifecycle.common)
    implementation(libs.androidx.lifecycle.viewmodel)
    implementation(libs.androidx.loader)
    implementation(libs.androidx.preference)
    implementation(libs.androidx.recyclerview)
    implementation(libs.androidx.vectordrawable)
    implementation(libs.androidx.vectordrawable.animated)
    implementation(libs.androidx.viewpager)

    // ─── Compose ───
    implementation(libs.androidx.compose.runtime)
    debugImplementation(libs.androidx.compose.ui.tooling)
    implementation(libs.androidx.compose.ui.tooling.preview)
    debugImplementation(libs.androidx.compose.ui.test.manifest)

    // ─── Coroutines ───
    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.kotlinx.coroutines.android)

    // ─── Misc ───
    implementation(libs.ackpine.api)
    runtimeOnly(libs.ackpine.core)
    implementation(libs.flexbox)
    implementation(libs.glide)
    implementation(libs.glide.annotations)
    implementation(libs.litepal)
    implementation(libs.material)
    implementation(libs.okhttp)
    implementation(libs.play.services.location)
    runtimeOnly(libs.androidx.startup.runtime)
    // Installs baseline.prof from the APK into ART (Android 7-13). implementation, not
    // runtimeOnly: BaselineProfileCompiler uses ProfileVerifier.
    implementation(libs.androidx.profileinstaller)

    // ─── Room ───
    implementation(libs.androidx.room.runtime)
    ksp(libs.androidx.room.compiler)

    ksp(libs.glide.ksp)

    // ─── Baseline Profile ───
    "baselineProfile"(project(":baselineprofile"))

    // ─── Debug ───
    debugImplementation(libs.leakcanary.android)

    // ─── Tests ───
    testRuntimeOnly(libs.junit.jupiter.engine)
}

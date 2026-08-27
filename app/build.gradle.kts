import java.util.Properties

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.kotlin.parcelize)
    alias(libs.plugins.ksp)
    alias(libs.plugins.dependency.analysis)
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
        versionCode = 1
        versionName = "1.2.1"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        vectorDrawables {
            useSupportLibrary = true
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

        create("profile") {
            initWith(getByName("release"))
            isProfileable = true
            signingConfig = signingConfigs.getByName("debug")
            matchingFallbacks += listOf("release")
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

    // ─── Room ───
    implementation(libs.androidx.room.runtime)
    ksp(libs.androidx.room.compiler)

    ksp(libs.glide.ksp)

    // ─── Debug ───
    debugImplementation(libs.leakcanary.android)

    // ─── Tests ───
    testRuntimeOnly(libs.junit.jupiter.engine)
}

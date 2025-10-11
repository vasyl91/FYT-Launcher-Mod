import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.tasks.KotlinJvmCompile

plugins {
    id("com.android.application")
    kotlin("android")
    id("kotlin-parcelize")
    id("org.jetbrains.kotlin.plugin.compose") version "2.1.21"
    id("com.google.devtools.ksp")
    id("com.autonomousapps.dependency-analysis")
}

android {
    namespace = "com.android.launcher66"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.android.launcher66"
        minSdk = 26
        targetSdk = 36
        versionCode = 1
        versionName = "1.1.7"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        testInstrumentationRunnerArguments["runnerBuilder"] = "de.mannodermaus.junit5.AndroidJUnit5Builder"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isCrunchPngs = false
            isMinifyEnabled = false
            isShrinkResources = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro", 
                "proguard-widgets.pro"
            )
            enableAndroidTestCoverage = true
            enableUnitTestCoverage = true
        }
        debug {
            isCrunchPngs = false
        }
    }

    signingConfigs {
        getByName("debug") {
            keyAlias = "android"
            keyPassword = "android"
            storeFile = file("../app/keystore.jks")
            storePassword = "android"
        }
        create("release") {
            keyAlias = "android"
            keyPassword = "android"
            storeFile = file("../app/keystore.jks")
            storePassword = "android"
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_21
        targetCompatibility = JavaVersion.VERSION_21
    }

    tasks.withType<KotlinJvmCompile>().configureEach {
      compilerOptions {
        jvmTarget.set(JvmTarget.JVM_21)
      }
    }

    tasks.withType<Test> {
        useJUnit()
        useJUnitPlatform()
    }

    buildFeatures {
        compose = true
    }

    packaging {
        dex {
            useLegacyPackaging = false
        }
        resources.excludes.add("META-INF/**")
    }

    bundle {
        storeArchive {
            enable = false
        }
    }

    lint {
        //lintConfig = file("lint.xml")
        checkReleaseBuilds = false
    }

    /*tasks.withType<JavaCompile>().configureEach {
        options.compilerArgs.addAll(listOf("-Xlint:unchecked", "-Xlint:deprecation", "-Xmaxwarns", "10000"))
    }*/
}

configurations.all {
    exclude(group = "commons-logging", module = "commons-logging")
}

dependencies {
    androidTestImplementation(platform(libs.androidx.compose.bom)) 
    
    androidTestRuntimeOnly(libs.junit.jupiter.engine)
    androidTestRuntimeOnly(libs.junit.vintage.engine)

    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.leakcanary.android)

    debugRuntimeOnly(libs.androidx.ui.test.manifest)

    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.viewmodel)
    implementation(libs.androidx.preference)
    implementation(libs.androidx.recyclerview)
    implementation(libs.androidx.viewpager)
    implementation(libs.flexbox)
    implementation(libs.glide)
    implementation(libs.annotations)
    implementation(libs.litepal)
    implementation(libs.material)
    implementation(libs.okhttp)
    implementation(libs.play.services.location)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.annotation)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.core)
    implementation(libs.androidx.fragment)
    implementation(libs.androidx.legacy.support.core.utils)
    implementation(libs.androidx.lifecycle.common)
    implementation(libs.androidx.loader)
    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.ackpine.api)

    debugImplementation(libs.leakcanary.android.core)
    debugImplementation(libs.leakcanary.object1.watcher.android.androidx)
    debugImplementation(libs.leakcanary.object1.watcher.android.support.fragments)
    implementation(libs.androidx.coordinatorlayout)
    implementation(libs.androidx.customview)
    implementation(libs.androidx.drawerlayout)
    implementation(libs.androidx.dynamicanimation)
    implementation(libs.androidx.vectordrawable)
    implementation(libs.androidx.vectordrawable.animated)

    implementation(libs.androidx.runtime)

    implementation(files("libs/cn.jar"))
    compileOnly(files("libs/api-82.jar"))
    implementation(project(":hook"))
    implementation(platform(libs.androidx.compose.bom))

    ksp(libs.ksp)
    ksp(libs.androidx.room.compiler)

    runtimeOnly(libs.ackpine.core)
    runtimeOnly(libs.androidx.startup.runtime)
    
    testRuntimeOnly(libs.junit.jupiter.engine)
}

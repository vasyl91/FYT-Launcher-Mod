import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.tasks.KotlinJvmCompile

plugins {
    id("com.android.library")
}

android {
    group = "com.custompip"

    namespace = "com.custompip"
    compileSdk = 36

    defaultConfig {
        minSdk = 26
        targetSdk = 36

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
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
}

dependencies {
    androidTestRuntimeOnly(libs.junit.jupiter.engine)
    androidTestRuntimeOnly(libs.junit.vintage.engine)
    testRuntimeOnly(libs.junit.jupiter.engine)
    compileOnly(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
}
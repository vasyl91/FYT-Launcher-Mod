plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.android.library) apply false
    alias(libs.plugins.kotlin.compose) apply false
    alias(libs.plugins.kotlin.parcelize) apply false
    alias(libs.plugins.ksp) apply false
    alias(libs.plugins.dependency.analysis)
    alias(libs.plugins.android.test) apply false
    alias(libs.plugins.baselineprofile) apply false
}

dependencyAnalysis {
    issues {
        all {
            onAny { severity("warn") }
        }
    }
}

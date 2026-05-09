// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    libs.plugins.run {
        alias(androidApplication) apply false
        alias(com.android.library) apply false
        alias(ksp) apply false
        alias(kotlin.parcelize) apply false
        alias(google.services) apply false
        alias(firebase.crashlytics) apply false
        alias(compose.compiler) apply false
        alias(jetbrains.kotlin.jvm) apply false
        alias(kotlinx.serialization) apply false
    }
}
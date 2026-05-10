plugins {
    libs.plugins.run {
        alias(library)
        alias(library.compose)
        alias(kotlinx.serialization)
    }
}

android {
    namespace = "ir.rahim.library.navigation"
}
dependencies {
    implementation(projects.library.designsystem)
    libs.run {
        implementation(kotlinx.serialization)
    }
}

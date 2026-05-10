plugins {
    libs.plugins.run {
        alias(library)
        alias(library.compose)
        alias(kotlinx.serialization)
    }
}

android {
    namespace = "ir.rahim.library.designsystem"
}
dependencies {
//    implementation(projects.core.base)
    libs.run {
        api(kotlinx.collections.immutable)
    }
}

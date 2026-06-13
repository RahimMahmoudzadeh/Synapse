plugins {
    libs.plugins.run {
        alias(library)
        alias(library.compose)
        alias(kotlinx.serialization)
    }
}

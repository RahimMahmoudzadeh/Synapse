plugins {
    libs.plugins.run {
        alias(presentation)
        alias(library.compose)
        alias(kotlinx.serialization)
    }
}

android {
    namespace = "ir.rahim.login.presentation"
}
dependencies {
    projects.run{
        implementation(login.domain)
    }
}

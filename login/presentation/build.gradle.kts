plugins {
    libs.plugins.run {
        alias(presentation)
        alias(library.compose)
        alias(kotlinx.serialization)
    }
}

//android {
//    namespace = "ir.rahim.login.presentation"
//}
kotlin {
    sourceSets{
        commonMain.dependencies{
            projects.run{
                implementation(login.domain)
            }
        }
    }
}

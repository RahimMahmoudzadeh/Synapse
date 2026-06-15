plugins {
    libs.plugins.run {
        alias(library)
        alias(library.compose)
        alias(navigation)
    }
}


//dependencies {
//    implementation(projects.library.designsystem)
//    libs.run {
//        implementation(kotlinx.serialization)
//    }
//}

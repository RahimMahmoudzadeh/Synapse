import com.android.build.gradle.internal.api.ApkVariantOutputImpl
import convention.SynapseBuildType
import java.io.FileInputStream
import java.util.Properties

plugins {
    libs.plugins.run {
        alias(application)
        alias(application.compose)
        alias(firebase)
        alias(di)
        alias(kotlinx.serialization)
    }
}
android {
    val keystorePropertiesFile = rootProject.file("local.properties")
    val keystoreProperties = Properties()
    if (keystorePropertiesFile.exists()) {
        keystoreProperties.load(FileInputStream(keystorePropertiesFile))
    }

    signingConfigs {
//        create("release") {
//            storeFile = rootProject.file("synapseKst.jks")
//            storePassword = keystoreProperties.getProperty("storePassword")
//            keyAlias = keystoreProperties.getProperty("keyAlias")
//            keyPassword = keystoreProperties.getProperty("keyPassword")
//        }
    }
    androidComponents {
        onVariants{
            it.outputs.forEach { output ->
                if (output is ApkVariantOutputImpl) {
                    output.outputFileName = "synapse.apk"
                }
            }
        }
    }

    buildFeatures {
        buildConfig = true
    }
    buildTypes {
        debug {
            applicationIdSuffix = SynapseBuildType.DEBUG.applicationIdSuffix
        }
//        release {
//            isMinifyEnabled = true
//            isShrinkResources = true
//            applicationIdSuffix = SynapseBuildType.RELEASE.applicationIdSuffix
//            proguardFiles(
//                getDefaultProguardFile("proguard-android-optimize.txt"),
//                "proguard-rules.pro",
//            )
//            signingConfig = signingConfigs.getByName("release")
//        }
    }
}
dependencies {
    libs.run {
        implementation(androidx.constraintlayout)
        implementation(kotlinx.collections.immutable)
//        implementation(accompanist.permissions)
    }
}
import com.android.build.api.dsl.ApplicationExtension
import com.android.build.api.dsl.KotlinMultiplatformAndroidLibraryTarget
import config.Config
import config.Config.android
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.invoke
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension
import kotlin.apply

/**
 * Configure base Kotlin with Android options
 */
internal fun Project.configureKotlinAndroid(commonExtension: ApplicationExtension) {
    commonExtension.apply {
        compileSdk = Config.android.compileSdkVersion
        defaultConfig {
            minSdk = Config.android.minSdkVersion
        }
        compileOptions {
            sourceCompatibility = Config.jvm.javaVersion
            targetCompatibility = Config.jvm.javaVersion
        }
        packaging.resources.excludes += "/META-INF/{AL2.0,LGPL2.1}"
    }

    dependencies {
        add("implementation", versionCatalog.findLibrary("androidx-core").get())
        add("testImplementation", versionCatalog.findLibrary("junit").get())
        add("androidTestImplementation", versionCatalog.findBundle("test").get())
    }
}

internal fun Project.configureComposeMultiPlatform() {
    extensions.configure<KotlinMultiplatformExtension> {

        targets.withType(KotlinMultiplatformAndroidLibraryTarget::class.java)
            .configureEach {
                compileSdk = Config.android.compileSdkVersion
                minSdk = Config.android.minSdkVersion
                val formattedPath = project.path.replace(":", ".").replace("-", "_")
                namespace = Config.android.nameSpace+formattedPath
                compilerOptions {
                    jvmTarget.set(org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_17)
                }
            }

        iosArm64()
        iosSimulatorArm64()

        sourceSets {
            commonMain.dependencies {
                val compose = versionCatalog.findBundle("compose").get()
                implementation(compose)
            }
            iosMain.dependencies {}

        }
    }
}
internal fun Project.configureComposeMultiPlatformPresentation() {
    extensions.configure<KotlinMultiplatformExtension> {

        targets.withType(KotlinMultiplatformAndroidLibraryTarget::class.java)
            .configureEach {
                compileSdk = Config.android.compileSdkVersion
                minSdk = Config.android.minSdkVersion
                val formattedPath = project.path.replace(":", ".").replace("-", "_")
                namespace = Config.android.nameSpace+formattedPath
                compilerOptions {
                    jvmTarget.set(org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_17)
                }
            }

        iosArm64()
        iosSimulatorArm64()

        sourceSets {
            commonMain.dependencies {
                implementation(  project(":library:designsystem"))
                implementation(  project(":library:navigation"))
            }
            iosMain.dependencies {}
        }
    }
}

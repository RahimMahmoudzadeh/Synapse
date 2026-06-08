package plugins

import com.android.build.api.dsl.LibraryExtension
import config.Config
import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.internal.Actions.with
import org.gradle.kotlin.dsl.configure
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension
import versionCatalog

class CmpLibraryConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply(versionCatalog.findPlugin("kotlin.multiplatform").get().get().pluginId)
                apply(
                    versionCatalog.findPlugin("android.kotlin.multiplatform.library").get()
                        .get().pluginId
                )
                apply(versionCatalog.findPlugin("kotlinx.serialization").get().get().pluginId)
            }
            extensions.configure<KotlinMultiplatformExtension> {
                androidTarget {
                    compilerOptions {
                        jvmTarget.set(org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_17)
                    }
                }

                iosX64()
                iosArm64()
                iosSimulatorArm64()

                applyDefaultHierarchyTemplate()

                sourceSets.apply {
                    commonMain.dependencies {
                        implementation(versionCatalog.findLibrary("kotlin-stdlib"))
                    }
                    androidMain.dependencies {
                    }
                }
            }

            extensions.configure<LibraryExtension> {
                compileSdk = Config.android.compileSdkVersion
                defaultConfig {
                    minSdk = Config.android.minSdkVersion
                }
                compileOptions {
                    sourceCompatibility = JavaVersion.VERSION_17
                    targetCompatibility = JavaVersion.VERSION_17
                }
            }
        }
    }
}
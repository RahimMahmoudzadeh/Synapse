package plugins

import androidGradle
import applyPlugins
import com.android.build.api.dsl.KotlinMultiplatformAndroidLibraryTarget
import config.Config
import configureComposeMultiPlatform
import configureKotlinAndroid
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.invoke
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension
import versionCatalog

class LibraryConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            applyPlugins {
                listOf(
                    versionCatalog.findPlugin("kotlin.multiplatform").get().get().pluginId,
                    versionCatalog.findPlugin("android.kotlin.multiplatform.library").get()
                        .get().pluginId,
                )
            }
            configureComposeMultiPlatform()
        }
    }
}

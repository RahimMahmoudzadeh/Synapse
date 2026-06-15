package plugins

import com.android.build.api.dsl.KotlinMultiplatformAndroidLibraryTarget
import config.Config
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension
import versionCatalog

class NavigationConventionPlugin : Plugin<Project> {
  override fun apply(target: Project) {
    with(target) {
      extensions.configure<KotlinMultiplatformExtension> {

        targets.withType(KotlinMultiplatformAndroidLibraryTarget::class.java)
          .configureEach {
            compileSdk = Config.android.compileSdkVersion
            minSdk = Config.android.minSdkVersion
            namespace = Config.android.nameSpace+"shared"
            compilerOptions {
              jvmTarget.set(org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_17)
            }
          }

        iosArm64()
        iosSimulatorArm64()

        applyDefaultHierarchyTemplate()

        sourceSets.apply {
          commonMain.dependencies {
            implementation(versionCatalog.findBundle("navigation").get())
          }
          androidMain.dependencies {
          }
        }
      }
    }
  }
}

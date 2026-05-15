package plugins

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import versionCatalog

class NavigationConventionPlugin : Plugin<Project> {
  override fun apply(target: Project) {
    with(target) {

      dependencies {
        add("api", versionCatalog.findBundle("navigation").get())
      }
    }
  }
}

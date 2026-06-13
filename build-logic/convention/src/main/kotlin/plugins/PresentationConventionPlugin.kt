package plugins

import applyPlugins
import configureComposeMultiPlatformPresentation
import org.gradle.api.Plugin
import org.gradle.api.Project

class PresentationConventionPlugin : Plugin<Project> {
  override fun apply(target: Project) {
    with(target) {
      applyPlugins {
        listOf("library", "di")
      }
      configureComposeMultiPlatformPresentation()

    }
  }
}

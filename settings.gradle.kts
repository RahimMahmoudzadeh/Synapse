pluginManagement {
    includeBuild("build-logic")
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "1.0.0"
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}
private fun subprojects(path: String) =
    file(path)
        .listFiles()
        .filter {
            it.isDirectory && it.listFiles().any { file -> file.name == "build.gradle.kts" }
        }.map {
            "${path.replace('/', ':')}:${it.name}"
        }
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
rootProject.name = "Synapse"

include(":app")
include(subprojects("login"))
include(subprojects("library"))
include(subprojects("shared"))

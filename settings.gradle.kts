// 自定义插件存储库
pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
        maven("https://jitpack.io")
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven("https://jitpack.io")
    }
}

rootProject.name = "awesome-android"
include(":app")
include(":core")
include(":library:net")
include(":feature:arch")
include(":feature:foundation")
include(":feature:ui")

buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:8.4.0-beta02")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.9.0")
  //      classpath("com.google.dagger:hilt-android-gradle-plugin:2.50")
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.jetbrains.kotlin.android) apply false
    id("com.google.dagger.hilt.android") version "2.50" apply false
}
buildscript {
    repositories {
        // other repositories...
        mavenCentral()
    }
}
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.ksp) apply false
    alias(libs.plugins.dagger.hilt.android) apply false
    alias(libs.plugins.google.services) apply false
    alias(libs.plugins.androidLibrary) apply false
}

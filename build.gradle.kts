buildscript {
    repositories {
        // other repositories...
        mavenCentral()
    }
}
plugins {
    id("com.android.application") version "8.1.1" apply false
    id("org.jetbrains.kotlin.android") version "1.9.0" apply false
    id("com.google.devtools.ksp") version "1.9.0-1.0.13" apply false
    id("com.google.dagger.hilt.android") version "2.48.1" apply false
    id("com.google.gms.google-services") version "4.4.0" apply false
}

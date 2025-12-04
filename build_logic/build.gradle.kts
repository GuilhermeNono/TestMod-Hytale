plugins {
    `kotlin-dsl`
}

// this is the Java version used to build this gradle plugin, NOT the Java version for your project!
// note that currently Kotlin does not support building with Java 25 yet.
val javaVersion = 21

repositories {
    gradlePluginPortal()
    mavenCentral()
}

dependencies {
    implementation("net.harawata:appdirs:1.5.0")
    implementation("org.jetbrains.gradle.plugin.idea-ext:org.jetbrains.gradle.plugin.idea-ext.gradle.plugin:1.3")
}

kotlin {
    jvmToolchain {
        languageVersion = JavaLanguageVersion.of(javaVersion)
    }
}

plugins {
    alias(libs.plugins.kotlinx.serialization)
    kotlin("jvm")
    application
}

group = "xyz.malefic.gupta"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(platform("org.http4k:http4k-bom:6.17.0.0"))
    implementation(libs.kotlinx.serialization.json)
    implementation(libs.bundles.http4k)
    implementation(libs.kermit)
    testImplementation(kotlin("test"))
}

kotlin {
    jvmToolchain(21)
}

tasks {
    test {
        useJUnitPlatform()
    }

    register<JavaExec>("runServer") {
        group = "application"
        description = "Run the server"
        mainClass.set("xyz.malefic.gupta.MainKt")
        classpath = sourceSets["main"].runtimeClasspath
    }
}

application {
    mainClass.set("xyz.malefic.gupta.MainKt")
}

import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.9.22"
    id("com.github.johnrengelman.shadow") version "8.1.1"
    id("org.jlleitschuh.gradle.ktlint") version "12.1.0"
}

group = "love.chihuyu"
version = ""

repositories {
    mavenCentral()
    maven("https://s01.oss.sonatype.org/content/repositories/snapshots")
    maven("https://repo.mattmalec.com/repository/releases")
}

dependencies {
    implementation("org.apache.logging.log4j:log4j-api:2.22.1")
    implementation("org.apache.logging.log4j:log4j-core:2.22.1")
    implementation("org.apache.logging.log4j:log4j-slf4j-impl:2.22.1")
    implementation("dev.kord:kord-common:0.13.0")
    implementation("dev.kord:kord-core:0.13.0")
    implementation("dev.kord:kord-core-voice:0.13.0")
    implementation("dev.kord:kord-rest:0.13.0")
    implementation("dev.kord:kord-voice:0.13.0")
    implementation("dev.kord:kord-gateway:0.13.0")
    implementation(platform("com.aallam.openai:openai-client-bom:3.6.2"))
    implementation("io.ktor:ktor-client-okhttp-jvm:2.3.7")
    implementation("com.aallam.openai:openai-client")
    implementation("com.mattmalec:Pterodactyl4J:2.BETA_140")
    implementation("org.xerial:sqlite-jdbc:3.44.1.0")
    implementation("org.jetbrains.exposed:exposed-dao:0.46.0")
    implementation("org.jetbrains.exposed:exposed-core:0.46.0")
    implementation("org.jetbrains.exposed:exposed-jdbc:0.46.0")
    implementation(kotlin("stdlib"))
}

ktlint {
    ignoreFailures.set(true)
    disabledRules.add("no-wildcard-imports")
}

tasks {
    jar {
        manifest.attributes["Main-Class"] = "love.chihuyu.BotKt"
    }

    test {
        useJUnitPlatform()
    }
}

kotlin {
    jvmToolchain(17)
}

val compileKotlin: KotlinCompile by tasks
compileKotlin.kotlinOptions {
    jvmTarget = "17"
}

val compileTestKotlin: KotlinCompile by tasks
compileTestKotlin.kotlinOptions {
    jvmTarget = "17"
}

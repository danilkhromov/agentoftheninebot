import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.3.72"
    id("org.jetbrains.kotlin.plugin.spring") version "1.3.72"
}

group = "io.agentofthenine"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation("org.jetbrains.kotlin", "kotlin-reflect", "1.3.72")
    implementation("com.fasterxml.jackson.module","jackson-module-kotlin","2.9.+")
    implementation("ch.qos.logback", "logback-classic", "1.2.3")
    implementation("org.springframework.boot", "spring-boot-starter-web", "2.0.4.RELEASE")
    implementation("org.telegram", "telegrambots-spring-boot-starter", "4.0.1")
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

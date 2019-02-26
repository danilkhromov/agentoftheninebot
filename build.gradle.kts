import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.2.60"
}

group = "io.agentofthenine"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    compile(kotlin("stdlib-jdk8"))
    compile("org.jetbrains.kotlin", "kotlin-reflect", "1.2.60")
    compile("ch.qos.logback", "logback-classic", "1.2.3")
    compile("org.springframework.boot", "spring-boot-starter-web", "2.0.4.RELEASE")
    compile("org.telegram", "telegrambots-spring-boot-starter", "4.0.1")
    compile("org.hibernate", "hibernate-validator", "6.0.10.Final")
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

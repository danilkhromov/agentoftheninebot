package io.agentofthenine

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.telegram.telegrambots.ApiContextInitializer


@SpringBootApplication
open class Application

fun main(args: Array<String>) {
    ApiContextInitializer.init()
    SpringApplication.run(Application::class.java, *args)
}
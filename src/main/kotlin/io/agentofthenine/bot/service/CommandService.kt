package io.agentofthenine.bot.service

import io.agentofthenine.bot.command.Command
import io.agentofthenine.bot.command.CommandIdentifier
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.ApplicationContext
import org.springframework.context.ApplicationContextAware
import org.springframework.stereotype.Service
import org.telegram.telegrambots.meta.api.objects.Message
import org.telegram.telegrambots.meta.bots.AbsSender
import javax.annotation.PostConstruct

@Service
open class CommandService(
        private var commands: MutableMap<String, Command> = mutableMapOf()
) : ApplicationContextAware {

    private lateinit var context: ApplicationContext

    @Value("\${commands}")
    private lateinit var commandIdentifiers: List<String>

    @PostConstruct
    open fun init() {
        commandIdentifiers.forEach{ c ->
            val command = CommandIdentifier.valueOf(c).getCommand(c)
            context.autowireCapableBeanFactory.autowireBean(command)
            commands[c] = command }
    }

    override fun setApplicationContext(applicationContext: ApplicationContext) {
        context = applicationContext
    }

    open fun executeCommand(absSender: AbsSender, message: Message) {
        if (message.hasText()) {
            val text: String = message.text
            if (text.startsWith("/")) {
                val commandIdentifier: String = text.substring(1).toUpperCase()
                if (commands.containsKey(commandIdentifier)) {
                    commands[commandIdentifier]!!.execute(absSender, message.from, message.chat)
                }
            }
        }

    }
}

package io.agentofthenine.bot

import io.agentofthenine.bot.service.CommandService
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import org.telegram.telegrambots.bots.TelegramLongPollingBot
import org.telegram.telegrambots.meta.api.objects.Message
import org.telegram.telegrambots.meta.api.objects.Update

@Component
open class AgentOfTheNineBot(
        @Value("\${bot.token}") private val botToken: String,

        private val commandService: CommandService
) : TelegramLongPollingBot() {

    override fun getBotUsername(): String {
        return "valera"
    }

    override fun getBotToken(): String {
        return botToken
    }

    override fun onUpdateReceived(update: Update) {
        if (update.hasMessage()) {
            val message: Message = update.message
            if (message.isCommand) {
                commandService.executeCommand(this, update.message)
            }
        }
    }
}

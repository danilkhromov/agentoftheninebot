package io.agentofthenine.bot.command

import org.telegram.telegrambots.meta.api.methods.send.SendMessage
import org.telegram.telegrambots.meta.api.objects.Chat
import org.telegram.telegrambots.meta.api.objects.User
import org.telegram.telegrambots.meta.bots.AbsSender

class InventoryCommand(commandIdentifier: String) : Command(commandIdentifier) {

    override fun execute(absSender: AbsSender, user: User, chat: Chat) {
        absSender.execute(SendMessage(chat.id, "Hallo"))
    }
}

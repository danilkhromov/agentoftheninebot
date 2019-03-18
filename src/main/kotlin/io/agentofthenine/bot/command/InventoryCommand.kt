package io.agentofthenine.bot.command

import io.agentofthenine.bot.service.MessageService
import org.springframework.beans.factory.annotation.Autowired
import org.telegram.telegrambots.meta.api.objects.Chat
import org.telegram.telegrambots.meta.api.objects.User
import org.telegram.telegrambots.meta.bots.AbsSender

class InventoryCommand(commandIdentifier: String) : Command(commandIdentifier) {

    @Autowired
    private lateinit var messageService: MessageService

    override fun execute(absSender: AbsSender, user: User, chat: Chat) {
        absSender.execute(messageService.getXurInventory(chat.id))
    }
}

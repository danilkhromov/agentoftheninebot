package io.agentofthenine.bot.command

import org.telegram.telegrambots.meta.api.objects.Chat
import org.telegram.telegrambots.meta.api.objects.User
import org.telegram.telegrambots.meta.bots.AbsSender

abstract class Command(
    val commandIdentifier: String
) {
    abstract fun execute(absSender: AbsSender, user: User, chat: Chat)
}

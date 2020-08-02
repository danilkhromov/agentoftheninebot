package io.agentofthenine.bot.service

import io.agentofthenine.bungie.BungieNetService
import org.springframework.stereotype.Service
import org.telegram.telegrambots.meta.api.methods.send.SendMessage

@Service
class MessageService(
    private val bungieNetService: BungieNetService
) {

    fun getXurInventory(userId: Long): SendMessage {
        val sendMessage = SendMessage().setChatId(userId)

        val destinyPublicVendors = bungieNetService.getDestinyPublicVendors()

        return sendMessage.setText(destinyPublicVendors.toString())
    }
}

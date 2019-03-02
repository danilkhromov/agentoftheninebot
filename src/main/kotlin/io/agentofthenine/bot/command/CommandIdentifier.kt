package io.agentofthenine.bot.command

import kotlin.reflect.KClass

enum class CommandIdentifier(private val clazz: KClass<out Command>) {
    INVENTORY(InventoryCommand::class);

    fun getCommand(commandIdentifier: String): Command {
        return clazz.java.getConstructor(String::class.java).newInstance(commandIdentifier)
    }
}

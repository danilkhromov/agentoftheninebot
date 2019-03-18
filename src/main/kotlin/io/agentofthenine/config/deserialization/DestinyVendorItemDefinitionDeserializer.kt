package io.agentofthenine.config.deserialization

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.deser.std.StdDeserializer
import io.agentofthenine.bungie.dto.DestinyVendorItemDefinition

open class DestinyVendorItemDefinitionDeserializer
    : StdDeserializer<DestinyVendorItemDefinition>(DestinyVendorItemDefinition::class.java) {

    override fun deserialize(p: JsonParser, ctxt: DeserializationContext?): DestinyVendorItemDefinition {
        val node: JsonNode = p.codec.readTree(p)
        val name = node.get("Response").get("displayProperties").get("name").textValue()
        val description = node.get("Response").get("displayProperties").get("description").textValue()
        val itemType = node.get("Response").get("itemTypeAndTierDisplayName").textValue()

        return DestinyVendorItemDefinition(name, description, itemType)
    }
}

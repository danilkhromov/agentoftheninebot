package io.agentofthenine.serivce.dto.deserialization

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.deser.std.StdDeserializer
import io.agentofthenine.serivce.dto.DestinyVendorItemDefinition

open class DestinyVendorItemDefinitionDeserializer(
        vc: Class<*>?
) : StdDeserializer<DestinyVendorItemDefinition>(vc) {

    override fun deserialize(p: JsonParser, ctxt: DeserializationContext?): DestinyVendorItemDefinition {
        val node: JsonNode = p.codec.readTree(p)
        val name: String = node.get("Response.displayProperties.name").textValue()
        val description: String = node.get("Response.displayProperties.description").textValue()
        val itemType: String = node.get("Response.itemTypeAndTierDisplayName").textValue()

        return DestinyVendorItemDefinition(name, description, itemType)
    }
}

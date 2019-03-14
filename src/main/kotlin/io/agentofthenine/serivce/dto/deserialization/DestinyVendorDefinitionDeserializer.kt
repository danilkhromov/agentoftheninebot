package io.agentofthenine.serivce.dto.deserialization

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.deser.std.StdDeserializer
import io.agentofthenine.serivce.dto.DestinyVendorDefinition

open class DestinyVendorDefinitionDeserializer(vc: Class<*>?) : StdDeserializer<DestinyVendorDefinition>(vc) {

    override fun deserialize(p: JsonParser, ctxt: DeserializationContext): DestinyVendorDefinition {
        val node: JsonNode = p.codec.readTree(p)
        val name: String = node.get("Response.displayProperties.name").textValue()

        return DestinyVendorDefinition(name)
    }
}

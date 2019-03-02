package io.agentofthenine.serivce.dto.deserialization

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.deser.std.StdDeserializer
import io.agentofthenine.serivce.dto.DestinyVendorDefinitionDto

open class DestinyVendorDefinitionDeserializer(vc: Class<*>?) : StdDeserializer<DestinyVendorDefinitionDto>(vc) {

    override fun deserialize(p: JsonParser, ctxt: DeserializationContext?): DestinyVendorDefinitionDto {
        val node: JsonNode = p.codec.readTree(p)
        val name: String = node.get("Response.displayProperties.name").textValue()

        return DestinyVendorDefinitionDto(name)
    }
}

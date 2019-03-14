package io.agentofthenine.serivce.dto.deserialization

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.deser.std.StdDeserializer
import com.fasterxml.jackson.module.kotlin.KotlinModule
import io.agentofthenine.serivce.dto.DestinyPublicVendors
import io.agentofthenine.serivce.dto.DestinyVendorSales

class DestinyPublicVendorsDeserializer : StdDeserializer<DestinyPublicVendors>(DestinyPublicVendors::class.java) {

    override fun deserialize(p: JsonParser, ctxt: DeserializationContext): DestinyPublicVendors {
        val objectMapper = ObjectMapper().registerModule(KotlinModule())
        val node: JsonNode = p.codec.readTree(p)
        val sales: Map<String, DestinyVendorSales> = node.get("Response").get("sales").get("data").fields()
                .asSequence()
                .map { it.key to objectMapper.convertValue(it.value, DestinyVendorSales::class.java) }.toMap()

        return DestinyPublicVendors(sales)
    }
}

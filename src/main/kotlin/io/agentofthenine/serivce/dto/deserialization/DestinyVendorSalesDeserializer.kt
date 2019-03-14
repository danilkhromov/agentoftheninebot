package io.agentofthenine.serivce.dto.deserialization

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.deser.std.StdDeserializer
import com.fasterxml.jackson.module.kotlin.KotlinModule
import io.agentofthenine.serivce.dto.DestinyVendorSaleItem
import io.agentofthenine.serivce.dto.DestinyVendorSales

class DestinyVendorSalesDeserializer : StdDeserializer<DestinyVendorSales>(DestinyVendorSales::class.java) {

    override fun deserialize(p: JsonParser, ctxt: DeserializationContext): DestinyVendorSales {
        val objectMapper = ObjectMapper().registerModule(KotlinModule())
        val node: JsonNode = p.codec.readTree(p)
        val saleItems: Map<String, DestinyVendorSaleItem> = node.get("saleItems").fields()
                .asSequence()
                .map { it.key to objectMapper.convertValue(it.value, DestinyVendorSaleItem::class.java) }.toMap()

        return DestinyVendorSales(saleItems)
    }
}

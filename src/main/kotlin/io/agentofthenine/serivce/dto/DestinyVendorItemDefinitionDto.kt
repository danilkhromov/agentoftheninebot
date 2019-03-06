package io.agentofthenine.serivce.dto

import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import io.agentofthenine.serivce.dto.deserialization.DestinyVendorItemDefinitionDeserializer

@JsonDeserialize(using = DestinyVendorItemDefinitionDeserializer::class)
data class DestinyVendorItemDefinitionDto(
        val name: String,
        val description: String,
        val itemType: String
)

package io.agentofthenine.serivce.dto

import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import io.agentofthenine.serivce.dto.deserialization.DestinyVendorItemDefinitionDeserializer

@JsonDeserialize(using = DestinyVendorItemDefinitionDeserializer::class)
data class DestinyVendorItemDefinitionDto(
        private val name: String,
        private val description: String,
        private val itemType: String
)
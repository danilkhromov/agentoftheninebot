package io.agentofthenine.serivce.dto

import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import io.agentofthenine.serivce.dto.deserialization.DestinyVendorDefinitionDeserializer

@JsonDeserialize(using = DestinyVendorDefinitionDeserializer::class)
data class DestinyVendorDefinitionDto(
        private val name: String
)
package io.agentofthenine.serivce.dto

import com.fasterxml.jackson.annotation.JsonProperty

data class DestinyVendorItemDefinition(
        @JsonProperty
        val name: String,
        val description: String,
        val itemType: String
)

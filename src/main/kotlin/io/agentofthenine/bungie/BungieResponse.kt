package io.agentofthenine.bungie

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class BungieResponse(
    @JsonProperty("Response")
    var response: Response
)

data class Response(
    val sales: Sales
)

@JsonIgnoreProperties(ignoreUnknown = true)
data class Sales(
    val data: Map<String, Map<String, Map<String, SaleItem>>>
)

@JsonIgnoreProperties(ignoreUnknown = true)
data class SaleItem(
    val itemHash: Long
)
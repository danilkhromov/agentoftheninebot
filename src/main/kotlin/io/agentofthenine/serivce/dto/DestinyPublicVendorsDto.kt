package io.agentofthenine.serivce.dto

data class DestinyPublicVendorsDto(
        val vendorHash: String,
        val sales: Set<DestinyVendorSalesDto>
)

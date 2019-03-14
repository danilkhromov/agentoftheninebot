package io.agentofthenine.bungie.dto

data class DestinyVendorSaleItem(
        val vendorItemIndex: Long,
        val itemHash: Long,
        val quantity: Int,
        val costs: List<DestinyItemPrice>
)
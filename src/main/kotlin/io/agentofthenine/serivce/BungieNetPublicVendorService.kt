package io.agentofthenine.serivce

import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate

@Service
open class BungieNetPublicVendorService (
        private val bungieNetRestTemplate: RestTemplate
) {
    open fun getDestinyPublicVendors() {
    }

    open fun getDestinyVendorDefinition() {
    }

    open fun getDestinyVendorItemDefinition() {

    }
}

package io.agentofthenine.serivce

import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate

@Service
open class BungieNetPublicVendorService (
        bungieNetRestTemplate: RestTemplate
) {
    fun getPublicVendors() {

    }
}

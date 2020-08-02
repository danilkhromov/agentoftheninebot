package io.agentofthenine.bungie

import org.springframework.beans.factory.annotation.Value
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
import org.springframework.web.client.getForEntity
import org.springframework.web.util.UriComponentsBuilder

@Service
open class BungieNetService(
    @Value("\${public.vendors.url}")
    private val publicVendorsUrl: String,
    @Value("\${entity.definition.url}")
    private val entityDefinitionUrl: String,
    @Value("\${components}")
    private val vendorComponents: String,

    private val bungieNetRestTemplate: RestTemplate
) {

    fun getDestinyPublicVendors(): Map<String, SaleItem>? {
        val query = UriComponentsBuilder.fromUriString(publicVendorsUrl).apply {
            queryParam("components", vendorComponents)
        }

        val responseEntity: ResponseEntity<BungieResponse> = bungieNetRestTemplate.getForEntity(
            query.toUriString(),
            BungieResponse::class
        )

        return responseEntity.body!!.response.sales.data.getValue("2190858386")["saleItems"]
    }
}

package io.agentofthenine.bungie.service

import io.agentofthenine.bungie.dto.DestinyPublicVendors
import io.agentofthenine.bungie.dto.DestinyVendorDefinition
import io.agentofthenine.bungie.dto.DestinyVendorItemDefinition
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import org.springframework.util.LinkedMultiValueMap
import org.springframework.util.MultiValueMap
import org.springframework.web.client.RestTemplate
import org.springframework.web.client.getForEntity
import org.springframework.web.util.UriComponentsBuilder

@Service
open class BungieNetService (
        @Value("\${public.vendors.url}")
        private val publicVendorsUrl: String,
        @Value("\${entity.definition.url}")
        private val entityDefinitionUrl: String,
        @Value("\${components}")
        private val vendorComponents: String,

        private val bungieNetRestTemplate: RestTemplate
) {

    open fun getDestinyPublicVendors(): DestinyPublicVendors? {
        val query = UriComponentsBuilder.fromUriString(publicVendorsUrl)
        query.queryParam("components", vendorComponents)
        val responseEntity: ResponseEntity<DestinyPublicVendors> = bungieNetRestTemplate.getForEntity(
                query.toUriString(),
                DestinyPublicVendors::class
        )

        return responseEntity.body
    }

    open fun getDestinyVendorDefinition(entityType: String, hashIdentifier: Long): DestinyVendorDefinition? {
        val responseEntity: ResponseEntity<DestinyVendorDefinition> = bungieNetRestTemplate.getForEntity(
                entityDefinitionUrl,
                DestinyVendorDefinition::class,
                entityType,
                hashIdentifier
        )

        return responseEntity.body
    }

    open fun getDestinyVendorItemDefinition(hashIdentifier: Long): DestinyVendorItemDefinition? {
        val responseEntity: ResponseEntity<DestinyVendorItemDefinition> = bungieNetRestTemplate.getForEntity(
                entityDefinitionUrl,
                "DestinyInventoryItemDefinition",
                hashIdentifier
        )

        return responseEntity.body
    }
}

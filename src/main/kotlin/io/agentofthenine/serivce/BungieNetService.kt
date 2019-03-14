package io.agentofthenine.serivce

import io.agentofthenine.serivce.dto.DestinyPublicVendors
import io.agentofthenine.serivce.dto.DestinyVendorDefinition
import io.agentofthenine.serivce.dto.DestinyVendorItemDefinition
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
import org.springframework.web.client.getForEntity
import javax.annotation.PostConstruct

@Service
open class BungieNetService (
        @Value("\${public.vendors.url}")
        private val publicVendorsUrl: String,
        @Value("\${entity.definition.url}")
        private val entityDefinitionUrl: String,

        private val bungieNetRestTemplate: RestTemplate
) {

    @PostConstruct
    open fun init() {
        getDestinyPublicVendors()
    }

    open fun getDestinyPublicVendors(): DestinyPublicVendors? {
        val query = mutableMapOf("components" to "402")
        val responseEntity: ResponseEntity<DestinyPublicVendors> = bungieNetRestTemplate.getForEntity(
                publicVendorsUrl,
                DestinyPublicVendors::class
        )

        return responseEntity.body
    }

    open fun getDestinyVendorDefinition(entityType: String, hashIdentifier: String): DestinyVendorDefinition? {
        val responseEntity: ResponseEntity<DestinyVendorDefinition> = bungieNetRestTemplate.getForEntity(
                entityDefinitionUrl,
                DestinyVendorDefinition::class,
                entityType,
                hashIdentifier
        )

        return responseEntity.body
    }

    open fun getDestinyVendorItemDefinition(
            entityType: String,
            hashIdentifier: String
    ): DestinyVendorItemDefinition? {
        val responseEntity: ResponseEntity<DestinyVendorItemDefinition> = bungieNetRestTemplate.getForEntity(
                entityDefinitionUrl,
                DestinyVendorItemDefinition::class,
                entityType,
                hashIdentifier
        )

        return responseEntity.body
    }
}

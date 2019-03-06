package io.agentofthenine.serivce

import io.agentofthenine.serivce.dto.DestinyVendorDefinitionDto
import io.agentofthenine.serivce.dto.DestinyVendorItemDefinitionDto
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpMethod
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
import org.springframework.web.client.getForEntity

@Service
open class BungieNetService (
        @Value("\${public.vendors.url}")
        private val publicVendorsUrl: String,
        @Value("\${entity.definition.url}")
        private val entityDefinitionUrl: String,

        private val bungieNetRestTemplate: RestTemplate
) {

    open fun getDestinyPublicVendors(): DestinyVendorDefinitionDto? {
        val query = mutableMapOf("components" to PublicVendorsComponents.values())
        val responseEntity: ResponseEntity<DestinyVendorDefinitionDto> = bungieNetRestTemplate.getForEntity(
                publicVendorsUrl,
                DestinyVendorDefinitionDto::class,
                query
        )

        return responseEntity.body
    }

    open fun getDestinyVendorDefinition(entityType: String, hashIdentifier: String): DestinyVendorDefinitionDto? {
        val responseEntity: ResponseEntity<DestinyVendorDefinitionDto> = bungieNetRestTemplate.getForEntity(
                entityDefinitionUrl,
                DestinyVendorDefinitionDto::class,
                entityType,
                hashIdentifier
        )

        return responseEntity.body
    }

    open fun getDestinyVendorItemDefinition(
            entityType: String,
            hashIdentifier: String
    ): DestinyVendorItemDefinitionDto? {
        val responseEntity: ResponseEntity<DestinyVendorItemDefinitionDto> = bungieNetRestTemplate.getForEntity(
                entityDefinitionUrl,
                DestinyVendorItemDefinitionDto::class,
                entityType,
                hashIdentifier
        )

        return responseEntity.body
    }
}

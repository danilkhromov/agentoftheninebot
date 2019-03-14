package io.agentofthenine.config

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.module.SimpleModule
import com.fasterxml.jackson.module.kotlin.KotlinModule
import io.agentofthenine.bungie.dto.DestinyPublicVendors
import io.agentofthenine.config.deserialization.DestinyPublicVendorsDeserializer
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter
import org.springframework.web.client.RestTemplate

@Configuration
open class RestTemplateConfig(
        @Value("\${root.uri}")
        private val rootUri: String,
        @Value("\${x.api.key}")
        private val xApiKey: String
) {

    @Autowired
    private lateinit var templateBuilder: RestTemplateBuilder

    @Bean
    open fun getBungieNetRestTemplate(): RestTemplate {
        return templateBuilder
                .rootUri(rootUri)
                .messageConverters(getMappingJackson2HttpMessageConverter())
                .interceptors(BungieNetXApiKeyInterceptor(xApiKey))
                .build()
    }

    @Bean
    open fun getMappingJackson2HttpMessageConverter(): MappingJackson2HttpMessageConverter {
        val converter = MappingJackson2HttpMessageConverter()
        converter.objectMapper = getObjectMapper()

        return converter
    }

    @Bean
    open fun getObjectMapper(): ObjectMapper {
        val module: SimpleModule = SimpleModule()
        module.addDeserializer(DestinyPublicVendors::class.java, DestinyPublicVendorsDeserializer())

        return ObjectMapper().registerModule(KotlinModule()).registerModule(module)
    }
}

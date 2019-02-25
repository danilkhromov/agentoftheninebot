package io.agentofthenine.config

import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.client.RestTemplate

@Configuration
open class RestTemplateConfig(
        templateBuilder: RestTemplateBuilder,
        @Value("\${root.uri}") rootUri: String,
        @Value("\${x.api.key}") xApiKey: String
) {
    private val bunieNetRestTemplate = templateBuilder
            .rootUri(rootUri)
            .interceptors(BungieNetXApiKeyInterceptor(xApiKey))
            .build()

    @Bean
    open fun getBungieNetRestTemplate(): RestTemplate {
        return bunieNetRestTemplate
    }
}
package io.agentofthenine.config

import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.client.RestTemplate

@Configuration
open class RestTemplateConfig(
        @Value("\${root.uri}")
        private val rootUri: String,
        @Value("\${x.api.key}")
        private val xApiKey: String,

        private val templateBuilder: RestTemplateBuilder
) {
    @Bean
    open fun getBungieNetRestTemplate(): RestTemplate {
        return templateBuilder
                .rootUri(rootUri)
                .interceptors(BungieNetXApiKeyInterceptor(xApiKey))
                .build()
    }
}

package io.agentofthenine.config

import org.springframework.http.HttpRequest
import org.springframework.http.client.ClientHttpRequestExecution
import org.springframework.http.client.ClientHttpRequestInterceptor
import org.springframework.http.client.ClientHttpResponse

class BungieNetXApiKeyInterceptor (private val xApiKey: String) : ClientHttpRequestInterceptor {

    override fun intercept(request: HttpRequest,
                           body: ByteArray,
                           execution: ClientHttpRequestExecution): ClientHttpResponse {
        val response = execution.execute(request, body)
        response.headers.add("X-API-Key", xApiKey)
        return response
    }
}
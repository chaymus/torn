package org.klang.torn.configuration;

import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class RequestResponseLoggerInterceptor implements ClientHttpRequestInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(RequestResponseLoggerInterceptor.class);

    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
        // Log the request details before execution
        traceRequest(request, body);

        // Execute the request
        ClientHttpResponse response = execution.execute(request, body);

        // Log the response details after execution
        traceResponse(response);

        return response;
    }

    private void traceRequest(HttpRequest request, byte[] body) throws IOException {
        logger.info("Request: {} {} body: {}", request.getMethod(), request.getURI(), new String(body, StandardCharsets.UTF_8));
    }

    private void traceResponse(ClientHttpResponse response) throws IOException {
        // Note: Reading the body here consumes the stream. In a real application,
        // you might need a buffering request factory to allow the actual client
        // to read the body later.
        // String body = new String(response.getBody().readAllBytes(), StandardCharsets.UTF_8);
        logger.info("Response status: {} {}", response.getStatusCode(), response.getStatusText());
        // logger.info("Response body: {}", body);
    }
}

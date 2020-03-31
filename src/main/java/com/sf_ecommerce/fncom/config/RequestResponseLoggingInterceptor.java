package com.sf_ecommerce.fncom.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Service;
import org.springframework.util.StreamUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.util.Optional;

@Service
public class RequestResponseLoggingInterceptor implements ClientHttpRequestInterceptor {

    private final Logger logger = LoggerFactory.getLogger(getClass());
    private static String header = "auth_token";

    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution)
            throws IOException {
        HttpServletRequest httpServletRequest = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
                .getRequest();
        Optional.ofNullable(httpServletRequest.getHeader(header))
                .ifPresent(headerValue -> request.getHeaders().add(header, headerValue));
        logRequest(request, body);
        ClientHttpResponse response =execution.execute(request, body);
        logResponse(response);
        return response;
    }

    private void logRequest(HttpRequest request, byte[] body) throws IOException {
        logger.info("\n========================Request Begin========================================="
                + "\nURI        :[" + request.getMethod() + "] " + request.getURI()
                + "\n -- \n Headers         :" + request.getHeaders() + "\n -- \n Request body :"
                + new String(body, StandardCharsets.UTF_8) + "\n -- \n Timestamp(ms):" + Instant.now().toEpochMilli()
                + "\n =============================Request END========================================");
    }

    private void logResponse(ClientHttpResponse response) throws IOException {
        logger.info("\n ============================ Response Begin=========================================="
                    + "\n Status code  : " + response.getStatusCode() + "\n -- \n Headers      : "
                    + response.getHeaders() + "\n -- \n Response body: "
                    + StreamUtils.copyToString(response.getBody(), Charset.defaultCharset()) + "\n -- \n Timestamp(ms):"
                + Instant.now().toEpochMilli()
                + "\n ======================= Response END =================================================");
    }
}

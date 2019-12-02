package com.ubs.ga0.llcp.payments;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.var;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
@Slf4j
@RefreshScope
@RequiredArgsConstructor
public class HelloController {

    @NonNull
    private RestTemplate restTemplate;

    @Value("${app.config.urls.contractsApi}")
    private String baseUrl;

    @GetMapping("/hello")
    public String hello() {
        try {
            var helloUrl = baseUrl + "/hello";
            log.info("Calling the contracts service at url: {}", helloUrl);
            return this.restTemplate.getForObject(new URI(helloUrl), String.class);
        } catch (URISyntaxException e) {
            log.error("error while calling contracts");
            throw new RuntimeException(e);
        }
    }
}

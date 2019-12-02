package com.ubs.ga0.llcp.payments;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.function.Supplier;

@SpringBootApplication(exclude = {
        org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class,
        org.springframework.boot.actuate.autoconfigure.security.servlet.ManagementWebSecurityAutoConfiguration.class}
)
@Slf4j
@EnableDiscoveryClient
public class PaymentsServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(PaymentsServiceApplication.class, args);
    }

    // calls the contracts service via rest template via eureka service registry
//    @Bean
//    @Lazy
//    Supplier<String> hello(RestTemplate restTemplate, @Lazy @Value("${app.config.urls.contractsApi}") String url) {
//        return () -> {
//            String result = null;
//            try {
//                log.info("Calling the contracts service at url: {}", url);
//                result = restTemplate.getForObject(new URI(url), String.class);
//            } catch (URISyntaxException e) {
//                e.printStackTrace();
//            }
//            log.info("result from contracts service api: {}", result);
//            return "Result from contracts call: " + result;
//        };
//    }
}

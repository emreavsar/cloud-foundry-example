package com.ubs.ga0.llcp.payments;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.cloud.client.ConditionalOnDiscoveryEnabled;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Takes care about rest template configuration based on cloud discovery settings.
 */
@Configuration
public class RestTemplateConfiguration {
    @Configuration
    @ConditionalOnDiscoveryEnabled
    static class EurekaConfiguration {
        @Bean
        @LoadBalanced // make the rest template load balanced
        public RestTemplate restTemplate() {
            return new RestTemplate();
        }
    }

    @Configuration
    static class LocalConfiguration {
        @Bean
        @ConditionalOnMissingBean
        public RestTemplate restTemplate() {
            return new RestTemplate();
        }
    }
}
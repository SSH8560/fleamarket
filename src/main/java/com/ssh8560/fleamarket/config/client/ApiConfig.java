package com.ssh8560.fleamarket.config.client;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class ApiConfig {
    @Value("${kakao.restapi.key}")
    private String kakaoApiKey;

    @Bean
    public WebClient kakaoWebClient() {
        return WebClient.builder()
            .baseUrl("https://dapi.kakao.com/v2")
            .defaultHeader("Authorization", "KakaoAK " + kakaoApiKey)
            .build();
    }
}

package com.ssh8560.fleamarket.client;

import com.ssh8560.fleamarket.config.client.AddressResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.function.Consumer;

@Service
@RequiredArgsConstructor
public class KakaoAddressClient {
    private final WebClient webClient;

    public void requestAddress(Double x, Double y, Consumer<AddressResponse> addressResponseConsumer) {
        Mono<AddressResponse> mono = webClient.get()
            .uri(uriBuilder -> uriBuilder
                .path("/local/geo/coord2address.json")
                .queryParam("x", x)
                .queryParam("y", y)
                .queryParam("input_coord", "WGS84")
                .build())
            .retrieve()
            .bodyToMono(AddressResponse.class);

        mono.subscribe(addressResponseConsumer, throwable -> {
            System.out.println("throwable = " + throwable);
        });
    }
}

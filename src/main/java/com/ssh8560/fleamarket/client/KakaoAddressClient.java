package com.ssh8560.fleamarket.client;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;


@Service
@RequiredArgsConstructor
public class KakaoAddressClient {
    private final WebClient webClient;

    public RegionResponse getRegion(Double x, Double y) {
        Mono<RegionResponse> mono = webClient.get()
            .uri(uriBuilder -> uriBuilder
                .path("/local/geo/coord2regioncode.json")
                .queryParam("x", x)
                .queryParam("y", y)
                .queryParam("input_coord", "WGS84")
                .build())
            .retrieve()
            .bodyToMono(RegionResponse.class);

        return mono.block();
    }

    public AddressResponse getAddress(String query) {
        Mono<AddressResponse> mono = webClient.get()
            .uri(uriBuilder -> uriBuilder
                .path("/local/search/address.json")
                .queryParam("query", query)
                .build())
            .retrieve()
            .bodyToMono(AddressResponse.class);

        return mono.block();
    }
}

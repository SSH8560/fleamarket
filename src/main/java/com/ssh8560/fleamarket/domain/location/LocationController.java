package com.ssh8560.fleamarket.domain.location;

import com.ssh8560.fleamarket.client.AddressResponse;
import com.ssh8560.fleamarket.client.KakaoAddressClient;
import com.ssh8560.fleamarket.client.RegionResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/location")
@RequiredArgsConstructor
public class LocationController {
    private final KakaoAddressClient client;

    @GetMapping("/region")
    public ResponseEntity<RegionResponse> getRegion(
        @RequestParam(name = "x") Double x,
        @RequestParam(name = "y") Double y
    ) {
        RegionResponse regionResponse = client.getRegion(x, y);

        return ResponseEntity.ok(regionResponse);
    }

    @GetMapping("/address")
    public ResponseEntity<AddressResponse> getAddress(
        @RequestParam(name = "query") String query
    ){
        AddressResponse address = client.getAddress(query);

        return ResponseEntity.ok(address);
    }
}

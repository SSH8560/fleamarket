package com.ssh8560.fleamarket.config.client;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class AddressResponse {
    private Meta meta;
    private List<Document> documents;

    @Data
    static class Meta {
        @JsonProperty("total_count")
        private int totalCount;
    }

    @Data
    public static class Document {
        @JsonProperty("address")
        private Address address;
    }

    @Data
    public static class Address {
        @JsonProperty("address_name")
        private String addressName;
        @JsonProperty("region_1depth_name")
        private String region1depthName;
        @JsonProperty("region_2depth_name")
        private String region2depthName;
        @JsonProperty("region_3depth_name")
        private String region3depthName;
    }
}

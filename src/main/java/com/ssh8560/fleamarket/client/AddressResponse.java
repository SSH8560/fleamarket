package com.ssh8560.fleamarket.client;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class AddressResponse {
    private RegionResponse.Meta meta;
    private List<Document> documents;

    @Data
    public static class Meta {
        @JsonProperty("total_count")
        private int totalCount;
        @JsonProperty("pageable_count")
        private int pageableCount;
        @JsonProperty("isEnd")
        private int isEnd;
    }

    @Data
    public static class Document {
        @JsonProperty("address_name")
        private String addressName;
        private Double x;
        private Double y;
        @JsonProperty("address_type")
        private String addressType;
        private Address address;
    }

    @Data
    public static class Address {
        private String code;
        @JsonProperty("address_name")
        private String addressName;
        @JsonProperty("region_1depth_name")
        private String region1depthName;
        @JsonProperty("region_2depth_name")
        private String region2depthName;
        @JsonProperty("region_3depth_name")
        private String region3depthName;
        @JsonProperty("region_3depth_h_name")
        private String region3depthHName;
        @JsonProperty("x")
        private Double x;
        @JsonProperty("y")
        private Double y;
    }
}

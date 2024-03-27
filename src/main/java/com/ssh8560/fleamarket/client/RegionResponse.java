package com.ssh8560.fleamarket.client;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class RegionResponse {
    private Meta meta;
    @JsonProperty("documents")
    private List<Address> addresses;

    @Data
    static class Meta {
        @JsonProperty("total_count")
        private int totalCount;
    }

    @Data
    public static class Address {
        private String code;
        @JsonProperty("region_type")
        private String regionType;
        @JsonProperty("address_name")
        private String addressName;
        @JsonProperty("region_1depth_name")
        private String region1depthName;
        @JsonProperty("region_2depth_name")
        private String region2depthName;
        @JsonProperty("region_3depth_name")
        private String region3depthName;
        @JsonProperty("region_4depth_name")
        private String region4depthName;
        private Double x;
        private Double y;
    }
}

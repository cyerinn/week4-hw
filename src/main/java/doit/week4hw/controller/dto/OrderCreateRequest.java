package doit.week4hw.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record OrderCreateRequest (
        @JsonProperty("productId")
        Long item,
        @JsonProperty("quantity")
        int count
){}

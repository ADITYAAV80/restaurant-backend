package org.myprojects.yummy_rest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ProductResponse(
        @JsonProperty
        Long id,
        @JsonProperty
        String name,
        @JsonProperty
        double price
) {
}

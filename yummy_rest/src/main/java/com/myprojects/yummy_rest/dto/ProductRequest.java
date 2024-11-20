package org.myprojects.yummy_rest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record ProductRequest(
        @NotNull(message = "Product name is required")
        @NotEmpty(message = "Product name is required")
        @NotBlank(message = "Product name is required")
        @JsonProperty("name")
        String name,

        @NotNull(message = "Price is required")
        @Positive(message = "Price should be positive")
        @JsonProperty("price")
        double price
) {
}

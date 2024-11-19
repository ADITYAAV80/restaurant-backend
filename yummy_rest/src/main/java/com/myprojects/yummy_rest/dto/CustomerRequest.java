package com.myprojects.yummy_rest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;
public record CustomerRequest(
        @NotNull
        @NotEmpty
        @NotBlank
        @JsonProperty("first_name")
        String firstName,
        @JsonProperty("last_name")
        String lastName,
        @NotNull(message = "Email is required")
        @NotEmpty(message = "Email is required")
        @NotBlank(message = "Email is required")
        @Email(message = "Email must be in correct format")
        @JsonProperty("email")
        String email,
        @NotNull(message = "Password is required")
        @NotEmpty(message = "Password is required")
        @NotBlank(message = "Password is required")
        @Size(min = 3, max = 6, message = "Invalid password size")
        @JsonProperty("password")

        String password
) {
}
package com.myprojects.yummy_rest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record LoginRequest(
        @NotBlank(message = "Email is required")
        @Email(message = "Email must be in correct format")
        @JsonProperty("email")
        String email,
        @NotBlank(message = "Password is required")
        @Size(min = 3, max = 6, message = "Invalid password size")
        @JsonProperty("password")
        String password
) {
}
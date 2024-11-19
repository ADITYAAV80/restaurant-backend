package com.myprojects.yummy_rest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
public record CustomerResponse(
        @JsonProperty("first_name")
        String firstName,
        @JsonProperty("last_name")
        String lastName,
        @JsonProperty("email")
        String email
) {
}
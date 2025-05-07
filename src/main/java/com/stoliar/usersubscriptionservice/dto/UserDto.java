package com.stoliar.usersubscriptionservice.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record UserDto(
        @JsonProperty(access = JsonProperty.Access.READ_ONLY) Long id,
        String name,
        String email
) {}

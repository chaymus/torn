package org.klang.torn.user.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record MoneyResponseDTO(
        @JsonProperty("money")
        MoneyDTO money
) {}


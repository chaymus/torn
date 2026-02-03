package org.klang.torn.user.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.time.Instant;

public record CityBankDTO(
        Long amount,
        Long profit,
        Long duration,
        @JsonProperty("interest_rate")
        BigDecimal interestRate,
        Long until,
        @JsonProperty("invested_at")
        Instant investedAt
) {}

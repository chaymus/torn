package org.klang.torn.user.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.Instant;

public record CityBankDTO(
        BigInteger amount,
        BigInteger profit,
        BigInteger duration,
        @JsonProperty("interest_rate")
        BigDecimal interestRate,
        BigInteger until,
        Instant invested_at
) {}

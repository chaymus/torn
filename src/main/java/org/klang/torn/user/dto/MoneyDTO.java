package org.klang.torn.user.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.Instant;

public record MoneyDTO(
        @JsonProperty("money")
        Money money
) {}

record Money (
        BigInteger points,
        BigInteger wallet,
        BigInteger company,
        BigInteger vault,
        @JsonProperty("cayman_bank")
        BigInteger caymanBank,
        @JsonProperty("city_bank")
        CityBank cityBank,
        @JsonProperty("faction")
        Faction faction,
        @JsonProperty("daily_networth")
        BigInteger dailyNetworth
        ) {}

record CityBank (
        BigInteger amount,
        BigInteger profit,
        BigInteger duration,
        @JsonProperty("interest_rate")
        BigDecimal interestRate,
        BigInteger until,
        Instant invested_at
) {}

record Faction (
        BigInteger money,
        BigInteger points
) {}
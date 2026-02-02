package org.klang.torn.user.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigInteger;

public record MoneyDTO(
        BigInteger points,
        BigInteger wallet,
        BigInteger company,
        BigInteger vault,
        @JsonProperty("cayman_bank")
        BigInteger caymanBank,
        @JsonProperty("city_bank")
        CityBankDTO cityBank,
        @JsonProperty("faction")
        FactionDTO faction,
        @JsonProperty("daily_networth")
        BigInteger dailyNetworth
        ) {}

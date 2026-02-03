package org.klang.torn.user.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record MoneyDTO(
        Long points,
        Long wallet,
        Long company,
        Long vault,
        @JsonProperty("cayman_bank")
        Long caymanBank,
        @JsonProperty("city_bank")
        CityBankDTO cityBank,
        @JsonProperty("faction")
        FactionDTO faction,
        @JsonProperty("daily_networth")
        Long dailyNetworth
        ) {}

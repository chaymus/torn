package org.klang.torn.user.dto;

import java.math.BigInteger;

public record FactionDTO(
        BigInteger money,
        BigInteger points
) {}

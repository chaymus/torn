package org.klang.torn.user;

import org.klang.torn.user.dto.CityBankDTO;
import org.klang.torn.user.dto.FactionDTO;
import org.klang.torn.user.dto.MoneyDTO;
import org.klang.torn.user.dto.MoneyResponseDTO;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.time.Instant;

@Component
public class MoneyMapper {

    public MoneyEntity toEntity(BigInteger userId, MoneyResponseDTO moneyResponseDTO) {
        return MoneyEntity.builder()
                .points(moneyResponseDTO.money().points())
                .wallet(moneyResponseDTO.money().wallet())
                .company(moneyResponseDTO.money().company())
                .vault(moneyResponseDTO.money().vault())
                .caymanBank(moneyResponseDTO.money().caymanBank())
                .dailyNetworth(moneyResponseDTO.money().dailyNetworth())
                .userId(userId)
                .timestamp(Timestamp.from(Instant.now()))
                .build();
    }

    public MoneyResponseDTO toDTO(MoneyEntity moneyEntity) {
        MoneyDTO moneyDTO = new MoneyDTO(
                moneyEntity.points,
                moneyEntity.wallet,
                moneyEntity.company,
                moneyEntity.vault,
                moneyEntity.caymanBank,
                new CityBankDTO(null, null, null, null, null, null),
                new FactionDTO(null, null),
                moneyEntity.dailyNetworth);
        return new MoneyResponseDTO(moneyDTO);
    }
}

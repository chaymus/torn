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

    public MoneyEntity toEntity(Long userId, MoneyResponseDTO moneyResponseDTO) {
        MoneyDTO m = moneyResponseDTO.money();

        CityBankEntity cityBank = null;
        if(m.cityBank() != null) {
            cityBank = CityBankEntity.builder()
                    .amount(m.cityBank().amount())
                    .profit(m.cityBank().profit())
                    .duration(m.cityBank().duration())
                    .interestRate(m.cityBank().interestRate())
                    .until(m.cityBank().until())
                    .investedAt(m.cityBank().investedAt())
                    .build();
        }

        FactionEntity faction = null;
        if (m.faction() != null) {
            faction = FactionEntity.builder()
                    .money(m.faction().money())
                    .points(m.faction().points())
                    .build();
        }

        return MoneyEntity.builder()
                .points(moneyResponseDTO.money().points())
                .wallet(moneyResponseDTO.money().wallet())
                .company(moneyResponseDTO.money().company())
                .vault(moneyResponseDTO.money().vault())
                .caymanBank(moneyResponseDTO.money().caymanBank())
                .dailyNetworth(moneyResponseDTO.money().dailyNetworth())
                .userId(userId)
                .timestamp(Timestamp.from(Instant.now()))
                .cityBank(cityBank)
                .faction(faction)
                .build();
    }

    public MoneyResponseDTO toDTO(MoneyEntity moneyEntity) {
        CityBankDTO cityBankDTO = null;
        if (moneyEntity.getCityBank() != null) {
            var cb = moneyEntity.getCityBank();
            cityBankDTO = new CityBankDTO(
                    cb.getAmount(),
                    cb.getProfit(),
                    cb.getDuration(),
                    cb.getInterestRate(),
                    cb.getUntil(),
                    cb.getInvestedAt()
            );
        }

        FactionDTO factionDTO = null;
        if (moneyEntity.getFaction() != null) {
            var f = moneyEntity.getFaction();
            factionDTO = new FactionDTO(f.getMoney(), f.getPoints());
        }

        MoneyDTO moneyDTO = new MoneyDTO(
                moneyEntity.getPoints(),
                moneyEntity.getWallet(),
                moneyEntity.getCompany(),
                moneyEntity.getVault(),
                moneyEntity.getCaymanBank(),
                cityBankDTO,
                factionDTO,
                moneyEntity.getDailyNetworth()
        );

        return new MoneyResponseDTO(moneyDTO);
    }
}

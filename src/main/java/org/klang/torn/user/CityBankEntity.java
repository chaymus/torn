package org.klang.torn.user;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.Instant;

@Entity
@Table(name="city_bank")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class CityBankEntity {

    @Id
    @Column(name="city_bank_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cityBankId;

    @Column(name="amount")
    private Long amount;

    @Column(name="profit")
    private Long profit;

    @Column(name="duration")
    private Long duration;

    @Column(name = "interest_rate")
    private BigDecimal interestRate;

    @Column(name="until")
    private Long until;

    @Column(name="invested_at")
    private Instant investedAt;

    @OneToOne(mappedBy = "cityBank")
    MoneyEntity money;
}

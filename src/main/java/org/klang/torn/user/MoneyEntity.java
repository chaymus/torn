package org.klang.torn.user;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Entity
@Table(name="money")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class MoneyEntity {

    @Id
    @Column(name="money_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long moneyId;

    @Column(name="points")
    private Long points;

    @Column(name="wallet")
    private Long wallet;

    @Column(name="company")
    private Long company;

    @Column(name="vault")
    private Long vault;

    @Column(name="cayman_bank")
    private Long caymanBank;

    @Column(name="daily_networth")
    private Long dailyNetworth;

    @Column(name="timestamp")
    private Timestamp timestamp;

    @Column(name="user_id")
    private Long userId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "faction_id", referencedColumnName = "faction_id")
    private FactionEntity faction;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="city_bank_id", referencedColumnName = "city_bank_id")
    private CityBankEntity cityBank;
}

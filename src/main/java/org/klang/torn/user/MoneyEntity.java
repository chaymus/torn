package org.klang.torn.user;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.math.BigInteger;
import java.sql.Timestamp;

@Entity
@Table(name="money")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MoneyEntity {

    @Id
    @Column(name="money_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    BigInteger moneyId;

    @Column(name="points")
    BigInteger points;

    @Column(name="wallet")
    BigInteger wallet;

    @Column(name="company")
    BigInteger company;

    @Column(name="vault")
    BigInteger vault;

    @Column(name="cayman_bank")
    BigInteger caymanBank;

    @Column(name="daily_networth")
    BigInteger dailyNetworth;

    @Column(name="timestamp")
    Timestamp timestamp;

    @Column(name="user_id")
    BigInteger userId;
}

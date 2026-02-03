package org.klang.torn.user;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name="faction")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class FactionEntity {

    @Id
    @Column(name="faction_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long factionId;

    @Column(name="money")
    private Long money;

    @Column(name="points")
    private Long points;

    @OneToOne(mappedBy = "faction")
    private MoneyEntity ownerMoney;
}

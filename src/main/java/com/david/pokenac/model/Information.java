package com.david.pokenac.model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Information {
    @Id
    private Long id;
    private String genus;
    private String flavorText;
    private Long height;
    private Long weight;
    @Column(nullable = false)
    private String generation;
    @Column(nullable = false)
    private Integer hp;
    @Column(nullable = false)
    private Integer speed;
    @Column(nullable = false)
    private Integer attack;
    @Column(nullable = false)
    private Integer defense;
    @Column(nullable = false)
    private Integer special_attack;
    @Column(nullable = false)
    private Integer special_defense;
    @Column(nullable = false)
    private Long evo_chain_id;
    @OneToMany(fetch = FetchType.LAZY, targetEntity = Pokemon.class)
    private List<Pokemon> forms = new ArrayList<>();
}

package com.david.pokenac.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class EvoChain {
    @Id
    @Column(name = "id")
    private Long id;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "chain_id", referencedColumnName = "id")
    private Chain chain;
}

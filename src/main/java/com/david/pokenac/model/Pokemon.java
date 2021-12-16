package com.david.pokenac.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter @Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Pokemon {
    @Id
    private Long id;
    @Column(nullable = false)
    private String name;
    @ElementCollection
    private List<String> types;
    @Embedded
    private Sprites sprites;
}

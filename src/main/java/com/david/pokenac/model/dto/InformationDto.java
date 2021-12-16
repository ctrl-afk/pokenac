package com.david.pokenac.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.ElementCollection;
import javax.persistence.FetchType;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class InformationDto {
    private Long id;
    private String genus;
    private String flavorText;
    private Long height;
    private Long weight;
    @NotEmpty(message = "Insert generetion. ")
    private String generation;
    @NotEmpty(message = "Insert HP. ")
    private Integer hp;
    @NotEmpty(message = "Insert Speed. ")
    private Integer speed;
    @NotEmpty(message = "Insert Attack. ")
    private Integer attack;
    @NotEmpty(message = "Insert Defense. ")
    private Integer defense;
    @NotEmpty(message = "Insert Special Attack. ")
    private Integer special_attack;
    @NotEmpty(message = "Insert Special Defense. ")
    private Integer special_defense;
    @NotEmpty
    private Long evo_chain_id;
    @ElementCollection(fetch = FetchType.LAZY)
    private List<PokemonDto> forms = new ArrayList<>();
}

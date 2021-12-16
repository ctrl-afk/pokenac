package com.david.pokenac.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.ElementCollection;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PokemonDto {
    private Long id;
    @NotEmpty(message = "Add pokemon name")
    @Size(min = 4)
    private String name;
    @NotEmpty(message = "Add primary type")
    @ElementCollection
    private List<String> types;
    private SpritesDto sprites;
}

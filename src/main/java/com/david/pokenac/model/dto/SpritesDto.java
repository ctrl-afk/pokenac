package com.david.pokenac.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SpritesDto {
    //default
    @NotEmpty(message = "Front default img is required.")
    @Size(min = 10)
    private String front_default;
    private String back_default;
    private String front_default_female;
    private String back_default_female;
    //shiny
    private String front_shiny;
    private String back_shiny;
    private String front_shiny_female;
    private String back_shiny_female;
}

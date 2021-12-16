package com.david.pokenac.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter @Setter
@Embeddable
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Sprites {
    @NotNull
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

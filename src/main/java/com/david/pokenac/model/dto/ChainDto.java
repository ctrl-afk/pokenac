package com.david.pokenac.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter
public class  ChainDto {
    private Long id;
    private String name;
    private List<ChainDto> evolves_to = new ArrayList<>();
}

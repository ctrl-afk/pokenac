package com.david.pokenac.service;

import com.david.pokenac.exception.ResourceNotFoundException;
import com.david.pokenac.model.dto.PokemonDto;
import com.david.pokenac.model.Pokemon;
import com.david.pokenac.repository.PokemonRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PokemonService {

    @Autowired
    PokemonRepository repository;
    @Autowired
    ModelMapper mapper;

    public PokemonDto toDto(Object o){return mapper.map(o, PokemonDto.class);}
    public Pokemon toModel(Object o){return mapper.map(o, Pokemon.class);}

    public Pokemon save(PokemonDto dto) {return repository.save(this.toModel(dto));}

    @Query("SELECT p FROM Pokemon p ORDER BY p.id")
    public List<PokemonDto> findAll(){
        List<Pokemon> pkm = repository.findAll();
        return pkm.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    public List<PokemonDto> findByName(String name){
        List<Pokemon> pkm = repository.findPokemonsByNameContaining(name);
        return  pkm.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    public List<PokemonDto> findAll(Integer limit, Integer page){
        Page<Pokemon> pkm = repository.findAll(Pageable.ofSize(limit).withPage(page));
        return pkm.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }
    
    public PokemonDto findById(Long id) throws ResourceNotFoundException {
        Pokemon pkm = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Pokemon", id));
        return this.toDto(pkm);
    }
    public void update(Long id, PokemonDto pokemonDto) throws  ResourceNotFoundException{
        checkIfExist(id);
        this.save(pokemonDto);

    }
    public void delete(Long id) throws ResourceNotFoundException {
        checkIfExist(id);
        repository.deleteById(id);
    }

    public void checkIfExist(Long id) throws ResourceNotFoundException {
        repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Pokemon", id));
    }
}

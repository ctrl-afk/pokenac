package com.david.pokenac.controller;

import com.david.pokenac.exception.ResourceNotFoundException;
import com.david.pokenac.model.dto.PokemonDto;
import com.david.pokenac.model.Pokemon;
import com.david.pokenac.service.PokemonService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "https://ctrl-afk.github.io")
@RestController
@RequestMapping("/api/v1/pokemon")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PokemonController {
    PokemonService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Pokemon save(@RequestBody @Valid PokemonDto dto) {return service.save(dto);}

    @GetMapping
    public List<PokemonDto> findAll() {return service.findAll();}

    @GetMapping(params = {"page", "limit"})
    public List<PokemonDto> findAll(
            @RequestParam(value = "page") Integer page,
            @RequestParam(value = "limit") Integer limit){
        return service.findAll(limit, page);
    }

    @GetMapping(params = {"name"})
    public  List<PokemonDto> findByName(@RequestParam(value = "name") String name) {
        return service.findByName(name);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PokemonDto findById(@PathVariable Long id) throws ResourceNotFoundException {
        return service.findById(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable Long id, @RequestBody @Valid PokemonDto dto) throws ResourceNotFoundException {
        service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) throws ResourceNotFoundException {
        service.delete(id);
    }
}

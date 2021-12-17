package com.david.pokenac.controller;

import com.david.pokenac.exception.ResourceNotFoundException;
import com.david.pokenac.model.dto.InformationDto;
import com.david.pokenac.model.Information;
import com.david.pokenac.service.InformationService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

//Information é chamado a parte do pokemon, usando o id
@CrossOrigin(origins = "https://ctrl-afk.github.io/pokenac-front/")
@RestController
@RequestMapping("/api/v1/info")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class InformationController {
    InformationService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Information save(@RequestBody @Valid InformationDto dto){
        return service.save(dto);
    }

    @GetMapping
    public List<InformationDto> findAll(){return service.findAll();}

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public InformationDto findById(@PathVariable Long id) throws ResourceNotFoundException {
        return service.findById(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable Long id, @RequestBody @Valid InformationDto dto) throws ResourceNotFoundException {
        service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) throws ResourceNotFoundException {
        service.delete(id);
    }
}

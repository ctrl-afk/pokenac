package com.david.pokenac.controller;

import com.david.pokenac.exception.ResourceNotFoundException;
import com.david.pokenac.model.EvoChain;
import com.david.pokenac.model.dto.EvoChainDto;
import com.david.pokenac.service.EvoChainService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "https://ctrl-afk.github.io")
@RestController
@RequestMapping("/api/v1/evo")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class EvoChainController {
    @Autowired
    EvoChainService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EvoChain save(@RequestBody @Valid EvoChainDto dto){
        return service.save(dto);
    }

    @GetMapping
    public List<EvoChainDto> findAll(){return service.findAll();}

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public EvoChainDto findById(@PathVariable Long id) throws ResourceNotFoundException {
        return service.findById(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable Long id, @RequestBody @Valid EvoChainDto dto) throws ResourceNotFoundException {
        service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) throws ResourceNotFoundException {
        service.delete(id);
    }
}

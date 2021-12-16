package com.david.pokenac.service;

import com.david.pokenac.exception.ResourceNotFoundException;
import com.david.pokenac.model.EvoChain;
import com.david.pokenac.model.dto.EvoChainDto;
import com.david.pokenac.repository.EvoChainRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EvoChainService {
    @Autowired
    EvoChainRepository repository;
    @Autowired
    ModelMapper mapper;

    public EvoChainDto toDto(Object obj){
        return mapper.map(obj, EvoChainDto.class);
    }
    public EvoChain toModel(Object obj) {
        return mapper.map(obj, EvoChain.class);
    }

    public EvoChain save(EvoChainDto dto) {
        return repository.save(this.toModel(dto));
    }

    public List<EvoChainDto> findAll(){
        List<EvoChain> info = repository.findAll();
        return info.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    public EvoChainDto findById(Long id) throws ResourceNotFoundException {
        EvoChain info = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("EvoChain", id));
        return this.toDto(info);
    }
    public void update(Long id, EvoChainDto dto) throws  ResourceNotFoundException{
        checkIfExist(id);
        this.save(dto);

    }
    public void delete(Long id) throws ResourceNotFoundException {
        checkIfExist(id);
        repository.deleteById(id);
    }

    public void checkIfExist(Long id) throws ResourceNotFoundException {
        repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("EvoChain", id));
    }
}


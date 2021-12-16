package com.david.pokenac.service;

import com.david.pokenac.exception.ResourceNotFoundException;
import com.david.pokenac.model.dto.InformationDto;
import com.david.pokenac.model.Information;
import com.david.pokenac.repository.InformationRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InformationService {
    @Autowired
    InformationRepository repository;
    @Autowired
    ModelMapper mapper;

    public InformationDto toDto(Object obj){
        return mapper.map(obj, InformationDto.class);
    }
    public Information toModel(Object obj) {
        return mapper.map(obj, Information.class);
    }

    public Information save(InformationDto dto) {
        return repository.save(this.toModel(dto));
    }

    public List<InformationDto> findAll(){
        List<Information> info = repository.findAll();
        return info.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    public InformationDto findById(Long id) throws ResourceNotFoundException {
        Information info = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Information", id));
        return this.toDto(info);
    }
    public void update(Long id, InformationDto dto) throws  ResourceNotFoundException{
        checkIfExist(id);
        this.save(dto);

    }
    public void delete(Long id) throws ResourceNotFoundException {
        checkIfExist(id);
        repository.deleteById(id);
    }

    public void checkIfExist(Long id) throws ResourceNotFoundException {
        repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Information", id));
    }
}

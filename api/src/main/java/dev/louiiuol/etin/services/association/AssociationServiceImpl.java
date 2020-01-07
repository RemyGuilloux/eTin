package dev.louiiuol.etin.services.association;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import dev.louiiuol.etin.controllers.dtos.requests.associations.AssociationCreateDto;
import dev.louiiuol.etin.controllers.dtos.requests.associations.AssociationUpdateDto;
import dev.louiiuol.etin.controllers.dtos.responses.AssociationViewDto;
import dev.louiiuol.etin.models.Association;
import dev.louiiuol.etin.repositories.AssociationRepository;

@Service
public class AssociationServiceImpl implements AssociationService {

    private final AssociationRepository repository;

    private final ModelMapper mapper;

    protected AssociationServiceImpl(AssociationRepository repository, ModelMapper mapper) {
        this.repository = repository; 
        this.mapper = mapper; 
    }
    
    @Override
    public List<AssociationViewDto> getAll() {
        List<AssociationViewDto> dtos = new ArrayList<AssociationViewDto>();
        List<Association> associations = repository.findAll();
        associations.forEach(c -> { dtos.add(mapper.map(c, AssociationViewDto.class)); });
        return dtos;
    }

    @Override
    public AssociationViewDto get(Long id) {
        Association association  =  repository.findById(id).get();
        return mapper.map(association, AssociationViewDto.class);
    }

    @Override
    public AssociationViewDto create(@Valid AssociationCreateDto dto) {
        Association association = mapper.map(dto, Association.class);
        return mapper.map( repository.save(association), AssociationViewDto.class);
    }

    @Override
    public void delete(Long id) { repository.deleteById(id); }

    @Override
    public AssociationViewDto update(Long id, @Valid AssociationUpdateDto dto) {
        Association  association = repository.findById(id).get();
        mapper.map(dto, association);
        return mapper.map(repository.save(association), AssociationViewDto.class);
    }

    @Override
    public boolean existsByName(String name) { return repository.existsByName(name); }

}
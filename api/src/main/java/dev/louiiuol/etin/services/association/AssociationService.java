package dev.louiiuol.etin.services.association;

import java.util.List;

import javax.validation.Valid;

import dev.louiiuol.etin.controllers.dtos.requests.associations.AssociationCreateDto;
import dev.louiiuol.etin.controllers.dtos.requests.associations.AssociationUpdateDto;
import dev.louiiuol.etin.controllers.dtos.responses.AssociationViewDto;

/** <p> Public Interface to deal with {@code Association} </p> */
public interface AssociationService {

    /** <p> Get all {@code Association} present in database </p> 
     * @return List<{@code AssociationViewDto}> */
    public List<AssociationViewDto> getAll();

    /** <p> Get specific {@code Association}, with given id,  in database </p> 
     * @return {@code AssociationViewDto}*/
    public AssociationViewDto get(Long id);

    /** <p> Create a new {@code Association}  in database </p> 
     * @return {@code AssociationViewDto}*/
    public AssociationViewDto create(@Valid AssociationCreateDto dto);

    /** <p> Delete {@code Association}, with given id,  in database </p> 
     * @return {@code AssociationViewDto}*/
    public void delete(Long id);

    /** <p> Update specific {@code Association} with given id  in database </p> 
     * @return {@code AssociationViewDto}*/
    public AssociationViewDto update(Long id, @Valid AssociationUpdateDto dto);

    /** <p> Check if  specific {@code Association} exists in database with given name </p> 
     * @return {@code boolean}*/
    public  boolean existsByName(String name);

}

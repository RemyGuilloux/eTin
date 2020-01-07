package dev.louiiuol.etin.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.louiiuol.etin.controllers.dtos.requests.associations.AssociationCreateDto;
import dev.louiiuol.etin.controllers.dtos.requests.associations.AssociationUpdateDto;
import dev.louiiuol.etin.controllers.dtos.responses.AssociationViewDto;
import dev.louiiuol.etin.services.association.AssociationService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/secure/associations")
@PreAuthorize("hasRole('ADMIN')")
public class AssociationController extends ControllerAdvice {

	private final AssociationService service;

	/** <p> Inject {@code AssociationService} to persist Association functionalities. </p> */
	protected AssociationController( AssociationService service) { this.service = service; }

	/** <p> Returns a pageable containing all associations present in database. </p>
	 * @return [ ... Association ] */
	@GetMapping("")
	public List<AssociationViewDto> getAll() { return service.getAll(); }

	/** <p> Returns asocciation matching  the given id </p>
	 * @param
     * @return Association */
	@GetMapping("/{id}")
	public AssociationViewDto get(@PathVariable("id") Long id) { return service.get(id); }

	/** <p> Persists new action with the given {@code RequestBody} </p>
     * @param
     * @return AssociationViewDto */
	@PostMapping("")
	public AssociationViewDto create(@Valid @RequestBody AssociationCreateDto dto) { return service.create(dto); }

	/** <p> Delete Association matching  the given id </p>
	 * @param*/
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Long id) { service.delete(id); }

	/** <p> Update Association matching  the given id  with new  informations passed in {@code RequestBody}  </p>
	 * @param
     * @return AssociationViewDto */
	@PutMapping("/{id}")
	public AssociationViewDto  update(@PathVariable("id") Long id,  @Valid @RequestBody AssociationUpdateDto dto) { return service.update(id, dto);}

}
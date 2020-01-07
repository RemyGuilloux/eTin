package dev.louiiuol.etin.controllers;

import java.util.Set;

import javax.validation.Valid;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.louiiuol.etin.controllers.dtos.requests.tinees.SwearCreateDto;
import dev.louiiuol.etin.controllers.dtos.requests.tinees.TineeCreateDto;
import dev.louiiuol.etin.controllers.dtos.requests.tinees.TineeUpdateDto;
import dev.louiiuol.etin.controllers.dtos.responses.MemberViewDto;
import dev.louiiuol.etin.controllers.dtos.responses.SwearViewDto;
import dev.louiiuol.etin.controllers.dtos.responses.TineeViewDto;
import dev.louiiuol.etin.controllers.utils.EntityIdDto;
import dev.louiiuol.etin.services.tinee.TineeService;

/** <p> a {@code RestController} to handle {@code Tinee}. </p> */
@RestController
@RequestMapping("secure/tinees")
@PreAuthorize("hasRole('USER')")
public class TineeController  extends ControllerAdvice {

	/** <p> Inject {@code TineeService} to persist Tinee functionalities. </p> */
    private final TineeService service;

    protected TineeController( TineeService service ) { this.service = service; }

    /** <p> Returns a pageable containing all Tinees present in database. </p>
	 * @return [ ... TineeViewDto ] */
    @GetMapping
    public Set<TineeViewDto> getAll() { return service.getAll(); }

    /** <p> Returns asocciation matching  the given id </p>
	 * @param
     * @return TineeViewDto */
    @GetMapping("/{id}")
    public TineeViewDto get(@PathVariable("id") Long id) { return service.get(id); }

    /** <p> If they are authorized, this method allow user to create a new Tinee through a {@code TineeCreateDto}. </p>
     * @param
     * @return a TineeViewDto */
    @PostMapping("")
    // @PreAuthorize("hasRole('USER') and hasRole('ADMIN')")
    public TineeViewDto create(@Valid @RequestBody TineeCreateDto input){ return service.create(input); }

    /** <p> Update Tinee matching  the given id  with new  informations passed in {@code RequestBody}  </p>
	 * @param
     * @return TineeViewDto */
    @PutMapping("/{id}")
    public TineeViewDto update(@PathVariable("id") Long id, @Valid @RequestBody TineeUpdateDto dto ) { return service.update(id, dto); }

    @GetMapping("/{id}/members")
    public Set<MemberViewDto> getMembers(@PathVariable("id") Long id) { return service.getMembers(mapIdDto(id)); }

    /** <p> Add new to the tinee matching  the given id  with the given user's id  </p>
	 * @param
     * @return MemberViewDto */   
    @PostMapping("/{tinee}/members/{user}")
    public MemberViewDto addMember(@PathVariable("tinee") Long tinee, @PathVariable("user") Long user ) { 
        return service.addMember(mapIdDto(tinee), mapIdDto(user)); }

    /** <p> Remove member matching second id, from Tinee matching  first id </p>
	 * @param*/
    @DeleteMapping("/{tinee}/members/{user}")
    public void removeMember(@PathVariable("tinee") Long tinee, @PathVariable("user") Long user ) { service.removeMember(mapIdDto(tinee), mapIdDto(user)); }

    @PostMapping("/{tinee}/swears")
    public SwearViewDto addSwear(@PathVariable("tinee") Long tinee, @PathVariable("user") Long user, @RequestBody SwearCreateDto input ) { return service.addSwear(mapIdDto(tinee), input);}

    /** <p> Private utilitary method  to map Long  into EntityIdDto  </p>
	 * @param
     * @return EntityIdDto */
    private EntityIdDto mapIdDto(Long id) { return new EntityIdDto(id); }


}
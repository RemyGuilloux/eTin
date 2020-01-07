package dev.louiiuol.etin.controllers;

import java.util.Set;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.louiiuol.etin.controllers.auth.SecurityHelper;
import dev.louiiuol.etin.controllers.dtos.requests.users.UserInfoCreateDto;
import dev.louiiuol.etin.controllers.dtos.requests.users.UserInfoUpdateDto;
import dev.louiiuol.etin.controllers.dtos.responses.MemberBalanceViewDto;
import dev.louiiuol.etin.controllers.dtos.responses.MemberViewDto;
import dev.louiiuol.etin.controllers.dtos.responses.UserInfoViewDto;
import dev.louiiuol.etin.controllers.utils.EntityIdDto;
import dev.louiiuol.etin.services.balance.MemberBalanceService;
import dev.louiiuol.etin.services.user.UserService;

/** <p> This class exposes REST API containing multiple CRUD request to handle {@code Authentication} and {@code User} informations. </p>
 * @see javax.validation
 * @see org.springframework.http.HttpStatus
 * @see org.springframework.http.MediaType
 * @see org.springframework.http.ResponseEntity
 * @see org.springframework.web.bind.annotation.CrossOrigin */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping()
public class UserController  extends ControllerAdvice {

	private final UserService service;

	private final MemberBalanceService balanceService;

	/** <p> Inject {@code UserService} & {@code MemberBalanceService} to persist User datas </p> */
	protected UserController(UserService service, MemberBalanceService balanceService) {
		this.service = service; 
		this.balanceService = balanceService;
	}

	/** <p> Returns a pageable containing all users present in database. </p>
     * @return [ ... UserInfoViewDto ] */
	@GetMapping("secure/users")
	public Set<UserInfoViewDto> getAll() { return service.getAll(); }

	/** <p> Returns user matching  the given id. </p>
	 * @param
     * @return UserInfoViewDto */
	@GetMapping("secure/users/{id}")
	public UserInfoViewDto get(@PathVariable("id") Long id) { return service.getCurrentUserInfo(id); }

	/** <p> Persists new user with the given {@code RequestBody} </p>
     * @param
     * @return UserInfoViewDto */
	@PostMapping("auth/signup")
	public UserInfoViewDto create(@Valid @RequestBody UserInfoCreateDto dto) { return service.create(dto); }

	/** <p> Update user matching  the given id  with new  informations passed in {@code RequestBody}  </p>
	 * @param
     * @return UserInfoViewDto */
	@PutMapping("secure/users/{id}")
	public UserInfoViewDto  update(@PathVariable("id") Long id,  @Valid @RequestBody UserInfoUpdateDto dto) { return service.update(id, dto); }

	/** <p> Delete user matching  the given id. </p>
	 * @param
     * @return void */
	@DeleteMapping("secure/users/{id}")
	public void delete(@PathVariable("id") Long id) { service.delete(id); }

	/** <p> Returns user's Tinees, matching  the given id, as list. </p>
	 * @param
     * @return Set<MemberViewDto> */
	@GetMapping("secure/users/{id}/tinees")
	public Set<MemberViewDto> getAllTinees(@PathVariable("id") Long id) { return balanceService.getAllByUser(mapIdDto(id)); }
	
	/** <p> Returns user's Tinees, matching  the given id, as list. </p>
	 * @param
     * @return MemberViewDto */
	@GetMapping("secure/users/{user}/tinees/{tinee}")
	public MemberViewDto getTinee(@PathVariable("user") Long user, @PathVariable("tinee") Long tinee) { return balanceService.get(mapIdDto(tinee), mapIdDto(user));  }

	/** <p> Returns user's Tinees, matching  the given id, as list. </p>
	 * @param*/
	@DeleteMapping("secure/users/{user}/tinees/{tinee}")
	public void leaveTinee(@PathVariable("user") Long user, @PathVariable("tinee") Long tinee ) {  balanceService.delete(mapIdDto(tinee), mapIdDto(user)); }

	/** <p> Returns user's Tinees, matching  the given id, as list. </p>
	 * @param
     * @return Set<MemberBalanceViewDto> */
	@GetMapping("secure/users/{id}/balances")
	public Set<MemberBalanceViewDto> getAllTineeBalance(@PathVariable("id") Long id) { return balanceService.getAllBalanceByUser(mapIdDto(id)); }

	/** <p> Returns user's Tinees, matching  the given id, as list. </p>
	 * @param
     * @return MemberBalanceViewDto */
	@GetMapping("secure/users/{user}/balances/{tinee}")
	public MemberBalanceViewDto getTineeBalance(@PathVariable("user") Long user, @PathVariable("tinee") Long tinee) { return balanceService.getBalance(mapIdDto(tinee), mapIdDto(user)); }

	/** <p> Returns user's Tinees, matching  the given id, as list. </p>
	 * @param
     * @return MemberBalanceViewDto */
	@PutMapping("secure/users/{user}/balances/{tinee}/{balance}")
	public MemberBalanceViewDto updateTineeBalance(@PathVariable("user") Long user, @PathVariable("tinee") Long tinee, @PathVariable("balance") Double balance ) { 
		return balanceService.update(mapIdDto(tinee), mapIdDto(user), balance);
	}

	/** <p> Private utilitary method  to map Long  into EntityIdDto  </p>
	 * @param
     * @return EntityIdDto */
	private EntityIdDto mapIdDto(Long id) { return new EntityIdDto(id); }

	/** <p> Standard enpoint returning a view of the current authenticated user. </p>
     * @param
     * @return a view of the current authenticated user */
    @GetMapping("/secure/whoami")
    public UserInfoViewDto userInfo() {
        Long userId = SecurityHelper.getUserId();
        return service.getCurrentUserInfo(userId);
    }

}
package dev.louiiuol.etin.services.user;

import java.util.Set;

import org.springframework.security.core.userdetails.UserDetailsService;

import dev.louiiuol.etin.controllers.dtos.requests.users.UserInfoCreateDto;
import dev.louiiuol.etin.controllers.dtos.requests.users.UserInfoUpdateDto;
import dev.louiiuol.etin.controllers.dtos.responses.UserInfoViewDto;

/** <p> This class provides Service to handle {@code User} persistence. </p> */
public interface UserService extends UserDetailsService {

    /**  <p> Return Pageable containing all users existing in  database. </p>
     * @return {@code List<UserInfoViewDto} */
    public Set<UserInfoViewDto> getAll();

    /**  <p> Return user matching the given id </p> 
     * @param
     *  @return {@code List<UserInfoViewDto} */
    public UserInfoViewDto getCurrentUserInfo(Long id);

    /**  <p> Allow user to register through a {@code UserRegisterDto}. </p>
     * @param 
     * @return a UserInfoViewDto */
    public UserInfoViewDto create(UserInfoCreateDto UserInfoCreateDto);
    
    /**  <p> Update user matching the given id </p> 
     * @param
     *  @return {@code UserInfoViewDto} */
    public UserInfoViewDto update(Long id, UserInfoUpdateDto UserInfoUpdateDto);

    /**  <p> Delete user matching the given id </p> 
     * @param*/
    public void delete(Long id);

    /**  <p> Return either the {@code email} is unique or not. </p> 
     * @param
     *  @return {@code true} if {@code email} exists; {@code false} otherwise. */
    public boolean existsByEmail(String email);

    /**  <p> Return either the {@code username} is unique or not. </p> 
     * @param
     *  @return {@code true} if {@code username} exists; {@code false} otherwise. */
    public boolean existsByUserName(String username);

}
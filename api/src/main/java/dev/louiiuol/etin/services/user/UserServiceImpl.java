package dev.louiiuol.etin.services.user;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import dev.louiiuol.etin.controllers.dtos.requests.users.UserInfoCreateDto;
import dev.louiiuol.etin.controllers.dtos.requests.users.UserInfoUpdateDto;
import dev.louiiuol.etin.controllers.dtos.responses.UserInfoViewDto;
import dev.louiiuol.etin.models.CustomUser;
import dev.louiiuol.etin.models.CustomUserDetails;
import dev.louiiuol.etin.models.Role;
import dev.louiiuol.etin.repositories.RoleRepository;
import dev.louiiuol.etin.repositories.UserRepository;

/** <p> Concrete implementation of {@code UserService}. </p> */
@Service
public class UserServiceImpl implements UserService {

    private final PasswordEncoder encoder;

    private final UserRepository repo;

    private final ModelMapper mapper;

    private final RoleRepository roleRepo;

    protected UserServiceImpl(PasswordEncoder encoder, UserRepository repo, ModelMapper mapper, RoleRepository roleRepo) {
        this.encoder = encoder; 
        this.repo = repo; 
        this.mapper = mapper;
        this.roleRepo = roleRepo;
    }

    @Override
    public Set<UserInfoViewDto> getAll() {
        Set<UserInfoViewDto> odts = new HashSet<UserInfoViewDto>();
        List<CustomUser> users = repo.findAll();
        users.forEach(c -> { odts.add(mapper.map(c, UserInfoViewDto.class)); });
        return odts;
    };

    @Override
    public UserInfoViewDto create(UserInfoCreateDto input) {
        String passwordEncoded = encoder.encode(input.getPassword());
        input.setPassword(passwordEncoded);
        CustomUser user = mapper.map(input, CustomUser.class);
        Role roleUser = roleRepo.findByCode("ROLE_USER");
        Set<Role> roles = new HashSet<>(); 
        roles.add(roleUser);
        user.setRoles(roles);
        return mapper.map(repo.save(user), UserInfoViewDto.class);
    };

    @Override
    public UserInfoViewDto update(Long id, UserInfoUpdateDto dto) {
        CustomUser user = repo.findById(id).get();
        mapper.map(dto, user);
        return mapper.map(repo.save(user), UserInfoViewDto.class);
    };

    @Override
    public void delete(Long id) { repo.deleteById(id); };

    @Override
    public boolean existsByEmail(String email) { return repo.existsByEmail(email); };

    @Override
    public boolean existsByUserName(String username) { return repo.existsByUsername(username); };

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        CustomUser user = repo.findByUsername(username).get();
        return new CustomUserDetails(user);
    }

    // Throws ResourceNotFoundException (restful practice)
    @Override
    public UserInfoViewDto getCurrentUserInfo(Long id) {
        CustomUser user = repo.findById(id).get(); 
        return mapper.map(user, UserInfoViewDto.class);
    }

}
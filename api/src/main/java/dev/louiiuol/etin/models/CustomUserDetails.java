package dev.louiiuol.etin.models;

import java.text.MessageFormat;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;


/** <p> Custom {@code UserDetails} for Spring authentication contract and custom properties we want in the token (such as the id). </p> */
public class CustomUserDetails extends User {

    private static final long serialVersionUID = 5803283930339051994L;

    private Long id;

    public CustomUserDetails(CustomUser user) {
		super(user.getUsername(), user.getPassword(), user.isEnabled(),
			user.isAccountNonExpired(), user.isCredentialsNonExpired(),
			user.isAccountNonLocked(), buildAuthorities(user.getRoles()));
		id = user.getId();
    }

    private static Set<GrantedAuthority> buildAuthorities(Set<Role> roles) {
		return roles.stream().map(r -> new SimpleGrantedAuthority(r.getCode()))
			.collect(Collectors.toUnmodifiableSet());
    }

    public Long getId() { return id; }

    @Override
    public String toString() {
	return MessageFormat.format("[ id: {0}, authorities: {1}, password: [PROTECTED], username: {2}, enabled: {3}, expired: {4}, locked: {5}, credentials-expired: {6} ]",
		getId(), getAuthorities(), getUsername(), isEnabled(), !isAccountNonExpired(), !isAccountNonLocked(), !isCredentialsNonExpired() );
    }
}

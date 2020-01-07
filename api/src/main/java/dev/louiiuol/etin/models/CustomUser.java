package dev.louiiuol.etin.models;

import java.text.MessageFormat;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import dev.louiiuol.etin.services.utils.BooleanConverter;

/** <p> Describes a {@code User} </p> */
@Entity
public class CustomUser extends AbstractEntity {

    private static final long serialVersionUID = -9139538865891144579L;

    @Column(length = 20, nullable = false, unique = true)
    private String username;

    @Column(nullable = false, length = 100, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    @Convert(converter = BooleanConverter.class)
    @Column(length = 1, nullable = false)
    private boolean enabled;

    @Convert(converter = BooleanConverter.class)
    @Column(length = 1, nullable = false)
    private boolean accountNonExpired;

    @Convert(converter = BooleanConverter.class)
    @Column(length = 1, nullable = false)
    private boolean accountNonLocked;

    @Convert(converter = BooleanConverter.class)
    @Column(length = 1, nullable = false)
    private boolean credentialsNonExpired;

    public CustomUser() {  }

    public String getUsername() { return username; }

    public String getEmail() { return email; }

    public String getPassword() { return password; }

    public Set<Role> getRoles() { return roles; }

    public boolean isEnabled() { return enabled; }

    public boolean isAccountNonExpired() { return accountNonExpired; }

    public boolean isAccountNonLocked() { return accountNonLocked; }

    public boolean isCredentialsNonExpired() { return credentialsNonExpired; }

    @Override
    public int hashCode() { return Objects.hash(username, email, password, roles, enabled, credentialsNonExpired, accountNonExpired, accountNonLocked ); }

    @Override
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if ( !(obj instanceof CustomUser) )
			return false;
		return username.equals(( (CustomUser) obj ).username);
    }
    
    @Override
    public String toString() { return MessageFormat.format("Custom-User#{0}: [username: {1}, email: {2}, roles: {3}, enabled: {4} ]", getId(), username, email, roles, enabled ); }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

}
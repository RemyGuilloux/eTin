package dev.louiiuol.etin.controllers.dtos.responses;

public class UserAuthViewDto {

    private Long id;

    private String username;

    private String password;

    private boolean enabled;

    private boolean accountNonExpired;

    private boolean accountNonLocked;

    private boolean credentialsNonExpired;

    public UserAuthViewDto() { }

    public Long getId(){ return id; }

    public String getUsername() { return username; }

    public String getPassword() { return password; }

    public boolean isEnabled() { return enabled; }

    public boolean isAccountNonExpired() { return accountNonExpired; }

    public boolean isAccountNonLocked() { return accountNonLocked; }

    public boolean isCredentialsNonExpired() { return credentialsNonExpired; }

}
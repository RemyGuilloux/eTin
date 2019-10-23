package dev.louiiuol.etin.domain.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "users")
public class User{

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 20)
    private String firstName;

    @Column(length = 20)
    private String lastName;

    @Column(length = 20, nullable = false, unique=true)
    private String userName;

    @Column(nullable = false, length = 100, unique=true)
    private String email;

    @Column(length=10)
    private  String phone;

    @Column(length=100)
    private String avatar; 

    @Column
    private LocalDate birthDate;

    @Column(nullable = false, updatable = false)
    private LocalDateTime subscriptionDate = LocalDateTime.now();

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_tinees", 
    	joinColumns = @JoinColumn(name = "user_id"), 
    	inverseJoinColumns = @JoinColumn(name = "tinee_id"))
    private Set<Tinee> tinees;

    @NotBlank
    @Size(min=6, max = 100)
    private String password;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles", 
    	joinColumns = @JoinColumn(name = "user_id"), 
    	inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    /**
     * Default empty no-args constructor.
     */
    public User() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public LocalDateTime getSubscriptionDate() {
        return subscriptionDate;
    }

    public void setSubscriptionDate(LocalDateTime subscriptionDate) {
        this.subscriptionDate = subscriptionDate;
    }

    public Set<Tinee> getTinees() {
        return tinees;
    }

    public void setTinees(Set<Tinee> tinees) {
        this.tinees = tinees;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "User [LastName=" + this.lastName + ", avatar=" + avatar + ", birthDate=" + birthDate + ", email=" + email
                + ", firstName=" + firstName + ", id=" + id + ", password=" + password
                + ", phone=" + phone + ", roles=" + roles + ", subscriptionDate=" + subscriptionDate + ", tinees="
                + tinees + ", userName=" + userName + "]";
    }

    public User(Long id, @NotBlank @Size(min = 3, max = 50) String firstName,
            @NotBlank @Size(min = 3, max = 50) String lastName, @NotBlank @Size(min = 3, max = 50) String userName,
            @NotBlank @Size(max = 50) @Email String email, @Size(max = 10) String phone, @Size(max = 50) String avatar,
            LocalDate birthDate, LocalDateTime subscriptionDate, Set<Tinee> tinees,
            @NotBlank @Size(min = 6, max = 100) String password, Set<Role> roles) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.email = email;
        this.phone = phone;
        this.avatar = avatar;
        this.birthDate = birthDate;
        this.subscriptionDate = subscriptionDate;
        this.tinees = tinees;
        this.password = password;
        this.roles = roles;
    }

   
}
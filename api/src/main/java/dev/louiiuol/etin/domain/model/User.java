package dev.louiiuol.etin.domain.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User extends AbstractEntity{

    /**
     *
     */
    private static final long serialVersionUID = -9139538865891144579L;

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

    @Column(length=6, nullable = false)
    private String password;

    /**
     * Default empty no-args constructor.
     */
    public User() {}

}
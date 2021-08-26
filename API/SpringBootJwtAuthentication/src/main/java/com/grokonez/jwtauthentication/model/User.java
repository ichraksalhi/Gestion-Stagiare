package com.grokonez.jwtauthentication.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


import org.hibernate.annotations.NaturalId;

@Entity
@Table(name = "users", uniqueConstraints = {
        @UniqueConstraint(columnNames = {
            "username"
        }),
        @UniqueConstraint(columnNames = {
            "email"
        })
})
public class User{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long user_id;

    @NotBlank
    @Size(min=3, max = 50)
    @Column(name="name")
    private String name;

    @NotBlank
    @Size(min=3, max = 50)
    private String username;

    @NaturalId
    @NotBlank
    @Size(max = 50)
    @Email
    private String email;

    @NotBlank
    @Size(min=6, max = 100)
    private String password;

    @NotBlank
    @Size(min=6, max = 100)
    @Column(name="cin")
    private String cin;

    @NotBlank
    @Size(min=6, max = 100)
    @Column(name="phone")
    private String phone;

    @Column(name="status")
    private Status status ;

    @ManyToMany
    @JoinTable(
            name = "user_stage",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "stage_id"))
    private Set<Stage> stages= new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "user_technologies",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "technologie_id"))
    private Set<Technologie> technologies= new HashSet<>();

    @OneToMany(mappedBy = "user")
    private Set<Sujet> sujets = new HashSet<>();


    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();



    public User() {}

    public User(String name, String username, String email, String password ,String cin, String phone) {
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
        this.cin = cin;
        this.phone = phone;


    }

    public Long getId() {
        return user_id;
    }

    public void setId(Long id) {
        this.user_id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCin() { return cin;}

    public void setCin(String cin) {this.cin = cin; }

    public String getPhone() { return phone; }

    public void setPhone(String phone) { this.phone = phone; }


    @Enumerated(EnumType.STRING)

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
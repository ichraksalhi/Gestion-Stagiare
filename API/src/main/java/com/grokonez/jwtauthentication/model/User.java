package com.grokonez.jwtauthentication.model;

import java.util.Set;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import org.hibernate.annotations.NaturalId;

@lombok.Getter
@lombok.Setter
@lombok.ToString
@lombok.RequiredArgsConstructor
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
    private Long id;

    @NotBlank
    @Size(min = 3, max = 50)
    @Column(name= "name")
    private String name;

    @NotBlank
    @Size(min = 3, max = 50)
    @Column(name= "username")
    private String username;

    @NaturalId
    @NotBlank
    @Size(max = 50)
    @Email
    @Column(name= "email")
    private String email;

    @NotBlank
    @Size(min = 6, max = 100)
    @Column(name= "password")
    private String password;

    @NotBlank
    @Size(min = 6, max = 100)
    @Column(name= "cin")
    private String cin;

    @NotBlank
    @Size(min = 6, max = 100)
    @Column(name= "phone")
    private String phone;

    @Enumerated(EnumType.ORDINAL)
    @Column(name="role")
    private RoleName role;
    @Enumerated(EnumType.STRING)
    @Column(name="Status")
    private Status status;




    @javax.persistence.ManyToMany(fetch = javax.persistence.FetchType.LAZY)
    @javax.persistence.JoinTable(name = "user_roles",
    	joinColumns = @javax.persistence.JoinColumn(name = "user_id"),
    	inverseJoinColumns = @javax.persistence.JoinColumn(name = "role_id"))
    @lombok.ToString.Exclude
    private java.util.Set<com.grokonez.jwtauthentication.model.Role> roles = new java.util.HashSet<>();

    @javax.persistence.ManyToMany
    @javax.persistence.JoinTable(name = "USER_TECHNOLOGIE",
            joinColumns = @javax.persistence.JoinColumn(name = "USER_ID"),
            inverseJoinColumns = @javax.persistence.JoinColumn(name = "TECHNOLOGIE_ID"))
    private java.util.List<Technologie> uilise;

    @javax.persistence.ManyToMany
    @javax.persistence.JoinTable(name = "USER_STAGE",
            joinColumns = @javax.persistence.JoinColumn(name = "USER_id"),
            inverseJoinColumns = @javax.persistence.JoinColumn(name = "STAGE_id"))
    private java.util.List<com.grokonez.jwtauthentication.model.Stage> stages;

    public User(String name, String username, String email, String password , String cin, String phone) {
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
        this.cin = cin;
        this.phone = phone;


    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || org.hibernate.Hibernate.getClass(this) != org.hibernate.Hibernate.getClass(o)) return false;
        com.grokonez.jwtauthentication.model.User user = (com.grokonez.jwtauthentication.model.User) o;

        return java.util.Objects.equals(email, user.email);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hashCode(email);
    }
}
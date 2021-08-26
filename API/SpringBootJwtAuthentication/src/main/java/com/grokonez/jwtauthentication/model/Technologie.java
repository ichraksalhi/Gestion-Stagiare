package com.grokonez.jwtauthentication.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "technologies", uniqueConstraints = {
        @UniqueConstraint(columnNames = {
                "name"
        }),
        @UniqueConstraint(columnNames = {
                "id"
        })
})
public class Technologie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(min=3, max = 50)
    private String name;

    @NotBlank
    @Size(min=20, max = 500)
    @Column(name="description")
    private String description;

    @NotBlank
    @DateTimeFormat
    @Column(name="date")
    private Date date;

    @ManyToMany
    @JoinTable (
            name = "technologie_sujet",
            joinColumns = @JoinColumn(name = "technologie_id"),
            inverseJoinColumns = @JoinColumn(name = "sujet_id"))
    private Set<Sujet> sujets = new HashSet<>();


    @ManyToMany
    @JoinTable (
            name = "technologie_user",
            joinColumns = @JoinColumn(name = "technologie_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private Set<User> users = new HashSet<>();

    public Technologie() {
    }

    public Technologie(Long id, String name, String description, Date date) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}

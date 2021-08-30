package com.grokonez.jwtauthentication.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "sujets", uniqueConstraints = {
        @UniqueConstraint(columnNames = {
                "name"
        }),
        @UniqueConstraint(columnNames = {
                "id"
        })
})
public class Sujet {
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


    @ManyToMany
    @JoinTable (
            name = "sujet_technologie",
            joinColumns = @JoinColumn(name = "sujet_id"),
            inverseJoinColumns = @JoinColumn(name = "technologie_id"))
    private Set<Technologie> technologies = new HashSet<>();

    @ManyToOne
    @JoinColumn(name="user_id", nullable = false)
    private User user;

    @OneToMany(mappedBy = "sujet")
    private Set<Stage> stages;




    public Sujet(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
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
}

package com.grokonez.jwtauthentication.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.*;

@Entity
@Table(name = "stages", uniqueConstraints = {
        @UniqueConstraint(columnNames = {
                "name"
        }),
        @UniqueConstraint(columnNames = {
                "id"
        })
})
public class Stage {
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

    @NotBlank
    @Column(name="periode")
    private int periode;

    @ManyToMany
    @JoinTable(
            name = "stage_user",
            joinColumns = @JoinColumn(name = "stage_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private Set<User> users = new HashSet<>();

    @ManyToOne
    @JoinColumn(name="sujet_id", nullable=false)
    private Sujet sujet;

    public Stage() {
    }

    public Stage(Long id, String name, String description, Date date, int periode) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.date = date;
        this.periode = periode;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Date getDate() {
        return date;
    }

    public int getPeriode() {
        return periode;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setPeriode(int periode) {
        this.periode = periode;
    }
}

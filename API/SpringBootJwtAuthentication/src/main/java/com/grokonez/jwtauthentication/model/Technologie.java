package com.grokonez.jwtauthentication.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

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
    private Long technologie_id;

    @NotBlank
    @Size(min=3, max = 50)
    private String name;

    @NotBlank
    @Size(min=20, max = 500)
    private String description;

    @NotBlank
    @DateTimeFormat
    private DateTimeFormat date;

    public Technologie() {
    }

    public Technologie(Long id, String name, String description, DateTimeFormat date) {
        this.technologie_id = id;
        this.name = name;
        this.description = description;
        this.date = date;
    }

    public Long getId() {
        return technologie_id;
    }

    public void setId(Long id) {
        this.technologie_id = id;
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

    public DateTimeFormat getDate() {
        return date;
    }

    public void setDate(DateTimeFormat date) {
        this.date = date;
    }
}

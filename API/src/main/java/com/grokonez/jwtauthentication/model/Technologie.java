package com.grokonez.jwtauthentication.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;
import java.util.List;


@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@Entity
@Table(name = "Technologie")

public class Technologie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id_Techno;

    @Column(name ="titre_techno")
    private String titre_techno ;

    @Basic
    @Column(name = "Description_techno")
    private String Description_techno ;
    @Basic
    @Column(name = "Date_Techno")
    private Date Date_Techno ;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "TECHNOLOGIE_SUJET",
            joinColumns = @JoinColumn(name = "TECHNOLOGIE_id"),
            inverseJoinColumns = @JoinColumn(name = "SUJET_id"))
    private Collection<Sujet> sujets;

    @ManyToMany(mappedBy = "technologies", cascade = CascadeType.ALL)
    private List<User> users;

}
package com.grokonez.jwtauthentication.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.Collection;


@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@Entity
@Table(name = "Sujet")
public class Sujet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_Sujet")
    private long Id_Sujet;

    @Basic
    @Column(name = "Titre_sujet")
    private String Titre_Sujet ;

    @Basic
    @Column(name = "Description__Sujet")
    private String Description_Sujet;

    @ManyToMany(mappedBy = "sujets", cascade = CascadeType.ALL)
    private Collection<Technologie> technologies;

}


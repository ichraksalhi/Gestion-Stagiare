package com.grokonez.jwtauthentication.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;


@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@Entity
@Table(name = "Sujet")
public class Sujet {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "IdSujet", updatable = false, nullable = false)
    private Long IdSujet;

    @Basic
    @Column(name = "sujetname")
    private String sujetname ;

    @Basic
    @Column(name = "sujetDescription")
    private String sujetDescription;


}


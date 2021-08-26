package com.grokonez.jwtauthentication.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Collection;


@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@Entity
@Table(name = "Stage")

public class Stage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id_Stage ;

    @Basic
    @Column(name = "Titre_stage")
    private String TitreStage;

    @Basic
    @Column(name = "Description_Stage")
    private String DescriptionStage;


    @Basic
    @Column(name = "Date_D:")
    private DateTimeFormat  DateD ;

    @Basic
    @Column(name = "Periode_stage")
    private  int PeriodStage;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "sujet_id_sujet")
    private Sujet sujet;

    @javax.persistence.ManyToMany
    @javax.persistence.JoinTable(name = "STAGE_STAGE",
            joinColumns = @javax.persistence.JoinColumn(name = "STAGE_1_id"),
            inverseJoinColumns = @javax.persistence.JoinColumn(name = "STAGE_2_id"))
    private java.util.List<com.grokonez.jwtauthentication.model.Stage> stages;

}

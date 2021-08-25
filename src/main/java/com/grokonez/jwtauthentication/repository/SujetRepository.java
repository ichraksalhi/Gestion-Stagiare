package com.grokonez.jwtauthentication.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.grokonez.jwtauthentication.model.Sujet  ;
import com.grokonez.jwtauthentication.model.User;
public interface  SujetRepository  extends JpaRepository<Sujet, Long> {
    long countById_SujetIs(long Id_Sujet);
}
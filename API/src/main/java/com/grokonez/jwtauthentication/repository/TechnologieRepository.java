package com.grokonez.jwtauthentication.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.grokonez.jwtauthentication.model.Technologie;
import org.springframework.data.jpa.repository.Query ;

public interface TechnologieRepository extends JpaRepository<Technologie, Long> {

}
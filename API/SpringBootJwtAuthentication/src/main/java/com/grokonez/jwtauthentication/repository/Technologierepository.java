package com.grokonez.jwtauthentication.repository;

import com.grokonez.jwtauthentication.model.Technologie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface Technologierepository extends JpaRepository<Technologie, Long> {

    Optional<Technologie> findByName(String name);
    Optional<Technologie> findById(Long id);
    List<Technologie> findAll();
}

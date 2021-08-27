package com.grokonez.jwtauthentication.repository;


import com.grokonez.jwtauthentication.model.Sujet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SujetRepository extends JpaRepository<Sujet,Long> {
    Optional<Sujet> findByName(String name);
    Optional<Sujet> findById(Long id);
}

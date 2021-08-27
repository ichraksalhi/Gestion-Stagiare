package com.grokonez.jwtauthentication.repository;

import com.grokonez.jwtauthentication.model.Stage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StageRepository extends JpaRepository<Stage, Long> {
    Optional<Stage> findById(Long id);
}

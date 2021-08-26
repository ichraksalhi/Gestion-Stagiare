package com.grokonez.jwtauthentication.repository;

import java.util.Optional;
import com.grokonez.jwtauthentication.model.User ;
import java.util.List ;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grokonez.jwtauthentication.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);

    List<User> findAll();
    //Boolean existById (Long Id);
}
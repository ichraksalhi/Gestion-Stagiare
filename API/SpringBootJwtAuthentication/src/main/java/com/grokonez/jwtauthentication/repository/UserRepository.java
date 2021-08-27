package com.grokonez.jwtauthentication.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grokonez.jwtauthentication.model.*;

@Repository
public interface UserRepository extends JpaRepository<User, Long>, UserRepositoryCustom {
    Optional<User> findByUsername(String username);

    //List<User> findByRole(RoleName role);

   List<User> findByRoles_Name(RoleName name);

    //static List<User> findByRoles_Name(RoleName name) {

       // return null;
    //}


    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
}

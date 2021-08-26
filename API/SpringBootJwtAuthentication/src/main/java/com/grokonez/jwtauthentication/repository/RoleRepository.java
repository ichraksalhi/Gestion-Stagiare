package com.grokonez.jwtauthentication.repository;

import java.util.List ;
import  com.grokonez.jwtauthentication.model.Role ;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grokonez.jwtauthentication.model.Role;
import com.grokonez.jwtauthentication.model.RoleName;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    List<Role> findByName(RoleName  ROLE_USER);


}
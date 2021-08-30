package com.grokonez.jwtauthentication.repository;

import com.grokonez.jwtauthentication.model.User;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface UserRepositoryCustom {
    List<User> getUserByDateStage();
}

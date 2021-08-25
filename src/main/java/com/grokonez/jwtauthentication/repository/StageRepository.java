package com.grokonez.jwtauthentication.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.grokonez.jwtauthentication.model.Stage ;
import com.grokonez.jwtauthentication.model.User;
@Repository
public interface StageRepository  extends JpaRepository<Stage, Long> {
    Stage findById_StageEquals(long Id_Stage);
}

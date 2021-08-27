package com.grokonez.jwtauthentication.repository;

import com.grokonez.jwtauthentication.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Date;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public class UserRepositoryImpl implements UserRepositoryCustom{
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<User> getUserByDateStage() {
        Query query = entityManager.createNativeQuery("select * from users, stages, user_stage where user_stage.stage_id=stages.id and user_stage.user_id=users.id and extract(year from stages.date)=extract(year from (now())) and stages.periode> extract (month from now())- extract (month from stages.date)"
                    , User.class);

        return query.getResultList();
    }
}

package com.example.core.repositories;

import com.example.core.models.UserTgBotModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserTgBotModelRepository extends JpaRepository<UserTgBotModel, UUID> {

    @Query("select u from UserTgBotModel u where u.index = ?1")
    Optional<UserTgBotModel> findByIndex(Long index);

    @Query(value = "INSERT INTO user_tg_bots(uuid, index, is_active, create_at, update_at, specification_uuid)\n" +
            "select ?1, ?2, ?3, ?4, ?5, s.uuid\n" +
            "FROM specification_tg_bots s\n" +
            "WHERE name_bot = ?6 returning uuid, index, is_active, create_at, update_at, specification_uuid", nativeQuery = true)
    Optional<UserTgBotModel> createUser(UUID uuid, Long index, Boolean is_active, Timestamp create_at, Timestamp update_at, String name_bot);

}

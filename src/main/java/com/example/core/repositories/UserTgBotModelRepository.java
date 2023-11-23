package com.example.core.repositories;

import com.example.core.models.UserTgBotModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserTgBotModelRepository extends JpaRepository<UserTgBotModel, UUID> {

    @Query("select u from UserTgBotModel u where u.index = ?1")
    Optional<UserTgBotModel> findByIndex(Long index);

}

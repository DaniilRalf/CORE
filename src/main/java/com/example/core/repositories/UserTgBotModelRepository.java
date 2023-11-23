package com.example.core.repositories;

import com.example.core.models.UserTgBotModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserTgBotModelRepository extends JpaRepository<UserTgBotModel, UUID> {
}

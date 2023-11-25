package com.example.core.repositories;

import com.example.core.models.SpecificationTgBotModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface SpecificationTgBotRepository extends JpaRepository<SpecificationTgBotModel, UUID> {

    @Query("select s from SpecificationTgBotModel s where s.nameBot = ?1")
    Optional<SpecificationTgBotModel> checkSpecification(String nameBot);
}

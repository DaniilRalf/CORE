package com.example.core.services;

import com.example.core.dto.UserData;
import com.example.core.helpers.errorHandler.exceptions.MainException;
import com.example.core.models.UserTgBotModel;
import com.example.core.repositories.UserTgBotModelRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserTgBotService {

    private final UserTgBotModelRepository userTgBotRepository;

    private final SpecificationTgBotService specificationTgBotService;

    public UserTgBotService(
            UserTgBotModelRepository userTgBotRepository,
            SpecificationTgBotService specificationTgBotService
    ) {
        this.userTgBotRepository = userTgBotRepository;
        this.specificationTgBotService = specificationTgBotService;
    }

    public Optional<UserTgBotModel> findByIndex(Long index) {
        return this.userTgBotRepository.findByIndex(index);
    }

    public UserTgBotModel createUser(UserData userData) {
        /** find User by index */
        Optional<UserTgBotModel> existingUser = this.userTgBotRepository.findByIndex(userData.getIndex());
        if (!this.specificationTgBotService.checkSpecification(userData.getBotName())) {
            throw new MainException("bot not found", HttpStatus.NOT_FOUND.value());
        }
        if (existingUser.isEmpty()) {
            /** create new User */
            Optional<UserTgBotModel> activeUser = this.userTgBotRepository.createUser(
                    UUID.randomUUID(),
                    userData.getIndex(),
                    true,
                    Timestamp.valueOf(LocalDateTime.now()),
                    Timestamp.valueOf(LocalDateTime.now()),
                    userData.getBotName()
            );
            return activeUser.get();
        } else {
            /** update existing User */
            existingUser.get().setIsActive(true);
            existingUser.get().setUpdatedAt(Timestamp.valueOf(LocalDateTime.now()));
            this.userTgBotRepository.save(existingUser.get());
            throw new MainException("user already exists, data has been updated", HttpStatus.ACCEPTED.value());
        }
    }
}

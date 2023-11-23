package com.example.core.services;

import com.example.core.dto.UserData;
import com.example.core.models.UserTgBotModel;
import com.example.core.repositories.UserTgBotModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserTgBotService {

    private final UserTgBotModelRepository userTgBotRepository;

    @Autowired
    public UserTgBotService(UserTgBotModelRepository userTgBotRepository) {
        this.userTgBotRepository = userTgBotRepository;
    }

    public Optional<UserTgBotModel> findByIndex(Long index) {
        return this.userTgBotRepository.findByIndex(index);
    }

//    public UserTgBotModel createUser(UserData userData) {
    public UserTgBotModel createUser(UserData userData) {
        /** find User by index */
        Optional<UserTgBotModel> existingUser = this.userTgBotRepository.findByIndex(userData.getIndex());
        UserTgBotModel activeUser;
        if (existingUser.isEmpty()) {
            /** create new User */
            activeUser = new UserTgBotModel();
            activeUser.setUuid(UUID.randomUUID());
            activeUser.setIndex(userData.getIndex());
            activeUser.setCreatedAt(Timestamp.valueOf(LocalDateTime.now()));
            activeUser.setSpecificationUuid(UUID.fromString("1fa1add2-3b45-6789-abcd-000000000002"));
        } else {
            activeUser = existingUser.get();
            //TODO: сделать обработку ошибок, пользователь уже существует
        }
        activeUser.setUpdatedAt(Timestamp.valueOf(LocalDateTime.now()));
        activeUser.setIsActive(true);
        userTgBotRepository.save(activeUser);
        System.out.println("========================");
        System.out.println(activeUser);
        System.out.println("========================");

        return activeUser;
    }
}

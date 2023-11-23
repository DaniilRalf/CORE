package com.example.core.api;

import com.example.core.dto.UserData;
import com.example.core.models.UserTgBotModel;
import com.example.core.services.UserTgBotService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tg-bots")
public class TgBotsController {

    private final UserTgBotService userTgBotService;

    public TgBotsController(UserTgBotService userTgBotService) {
        this.userTgBotService = userTgBotService;
    }

    @PostMapping("create-user")
    public UserTgBotModel createUser(@RequestBody() UserData userData) {
        return this.userTgBotService.createUser(userData);
    }

}

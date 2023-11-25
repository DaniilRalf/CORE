package com.example.core.helpers.workers;

import com.example.core.config.EnvConfig;
import com.example.core.models.UserTgBotModel;
import com.example.core.repositories.UserTgBotModelRepository;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.util.List;

@Component
@EnableScheduling
public class CheckUserActivity {

    private final UserTgBotModelRepository userTgBotModelRepository;
    private final Integer notActiveDays;

    public CheckUserActivity(UserTgBotModelRepository userTgBotModelRepository, EnvConfig envConfig) {
        this.notActiveDays = envConfig.getNotActiveDays();
        this.userTgBotModelRepository = userTgBotModelRepository;
    }

    /** Start every day at midnight */
    @Scheduled(cron = "0 0 0 * * *")
    public void checkAndUpdateUserActivity() {
        Timestamp currentDate = Timestamp.valueOf(LocalDateTime.now());
        List<UserTgBotModel> usersList = userTgBotModelRepository.findAll();
        for (UserTgBotModel user : usersList) {
            Timestamp lastUpdatedDate = user.getUpdatedAt();
            long daysDifference = ChronoUnit.DAYS.between((Temporal) lastUpdatedDate, (Temporal) currentDate);

            if (daysDifference > notActiveDays) {
                user.setIsActive(false);
                userTgBotModelRepository.save(user);
            }
        }
    }

}

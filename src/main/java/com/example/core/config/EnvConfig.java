package com.example.core.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
public class EnvConfig {

    @Value("${env.auth-token}")
    private String authToken;

    @Value("${env.not-active-days}")
    private Integer notActiveDays;
}

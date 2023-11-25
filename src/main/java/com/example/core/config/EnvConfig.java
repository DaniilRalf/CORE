package com.example.core.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
public class EnvConfig {

    @Value("${env.auth_token}")
    private String authToken;
}

package com.example.core.config;

import com.example.core.helpers.interceptors.CheckAuthorization;
import lombok.Data;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Data
@Configuration
public class MvcConfig implements WebMvcConfigurer {

    private final EnvConfig envConfig;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new CheckAuthorization(envConfig));
    }
}

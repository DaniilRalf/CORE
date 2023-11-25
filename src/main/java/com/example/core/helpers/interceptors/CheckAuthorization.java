package com.example.core.helpers.interceptors;

import com.example.core.config.EnvConfig;
import com.example.core.helpers.errorHandler.exceptions.MainException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Data
@Component
public class CheckAuthorization implements HandlerInterceptor {

    private final EnvConfig envConfig;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        String authorizationHeader = request.getHeader("Authorization");
        if (!authorizationHeader.equals(envConfig.getAuthToken())) {
            throw new MainException("Unauthorized", HttpStatus.UNAUTHORIZED.value());
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
        //
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        //
    }
}

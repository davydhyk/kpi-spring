package com.example.spring.config;

import com.example.spring.middleware.UserMiddleware;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MiddlewareConfig implements WebMvcConfigurer {

    private final UserMiddleware userMiddleware;

    public MiddlewareConfig(UserMiddleware userMiddleware) {
        this.userMiddleware = userMiddleware;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(userMiddleware);
    }
}

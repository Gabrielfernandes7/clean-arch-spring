package com.cleanapi.springbootcleanarch.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cleanapi.springbootcleanarch.application.gateway.UserGateway;
import com.cleanapi.springbootcleanarch.application.usecases.CreateUserInteractor;
import com.cleanapi.springbootcleanarch.infrastructure.controllers.UserDTOMapper;
import com.cleanapi.springbootcleanarch.infrastructure.gateways.UserEntityMapper;
import com.cleanapi.springbootcleanarch.infrastructure.gateways.UserRepositoryGateway;
import com.cleanapi.springbootcleanarch.infrastructure.persistence.UserRepository;

@Configuration
public class UserConfig {
    @Bean
    CreateUserInteractor createUserCase(UserGateway userGateway) {
        return new CreateUserInteractor(userGateway);
    }

    @Bean
    UserGateway userGateway(UserRepository userRepository, UserEntityMapper userEntityMapper) {
        return new UserRepositoryGateway(userRepository, userEntityMapper);
    }

    @Bean
    UserEntityMapper userEntityMapper() {
        return new UserEntityMapper();
    }

    @Bean
    UserDTOMapper userDTOMapper() {
        return new UserDTOMapper();
    }
}

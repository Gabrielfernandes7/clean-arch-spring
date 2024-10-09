package com.cleanapi.springbootcleanarch.infrastructure.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cleanapi.springbootcleanarch.application.usecases.CreateUserInteractor;
import com.cleanapi.springbootcleanarch.domain.entity.User;

@RestController
public class UserController {
    private final CreateUserInteractor createUserUseCase;
    private final UserDTOMapper userDTOMapper;

    public UserController(CreateUserInteractor createUserUseCase,
        UserDTOMapper userDTOMapper) {
        this.createUserUseCase = createUserUseCase;
        this.userDTOMapper = userDTOMapper;
    }

    @PostMapping
    public CreateUserResponse createUser(@RequestBody CreateUserRequest request) {
        User userBusinessObj = userDTOMapper.toUser(request);
        User user = createUserUseCase.createUser(userBusinessObj);
        return userDTOMapper.toResponse(user);
    }
}

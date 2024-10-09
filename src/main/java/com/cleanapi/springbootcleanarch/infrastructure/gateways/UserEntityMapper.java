package com.cleanapi.springbootcleanarch.infrastructure.gateways;

import com.cleanapi.springbootcleanarch.domain.entity.User;
import com.cleanapi.springbootcleanarch.infrastructure.persistence.UserEntity;

public class UserEntityMapper {
    UserEntity toEntity(User userDomainObject) {
        return new UserEntity(
            userDomainObject.username(),
            userDomainObject.password(),
            userDomainObject.email()
        );
    }

    User toDomainObject(UserEntity userEntity) {
        return new User(
            userEntity.getUsername(),
            userEntity.getPassword(),
            userEntity.getEmail()
        );
    }
}

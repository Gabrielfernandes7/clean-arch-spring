package com.cleanapi.springbootcleanarch.infrastructure.gateways;

import com.cleanapi.springbootcleanarch.application.gateway.UserGateway;
import com.cleanapi.springbootcleanarch.domain.entity.User;
import com.cleanapi.springbootcleanarch.infrastructure.persistence.UserEntity;
import com.cleanapi.springbootcleanarch.infrastructure.persistence.UserRepository;

public class UserRepositoryGateway implements UserGateway{

    private final UserRepository userRepository;
    private final UserEntityMapper userEntityMapper;

    public UserRepositoryGateway(UserRepository userRepository, UserEntityMapper userEntityMapper) {
        this.userEntityMapper = userEntityMapper;
        this.userRepository = userRepository;
    }

    @Override
    public User createUser(User userDomainObject) {
        // Utilizar o mapper para converter o usuário de domain para usuário de database
        // Estamos recebendo objeto de domínio(USER) e devolvendo objeto de domínio
        UserEntity userEntity = userEntityMapper.toEntity(userDomainObject);
        UserEntity saveEntity = userRepository.save(userEntity);
        return userEntityMapper.toDomainObject(saveEntity);
    }
    
}

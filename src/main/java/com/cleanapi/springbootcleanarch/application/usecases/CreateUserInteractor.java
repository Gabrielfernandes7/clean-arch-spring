package com.cleanapi.springbootcleanarch.application.usecases;

import com.cleanapi.springbootcleanarch.application.gateway.UserGateway;
import com.cleanapi.springbootcleanarch.domain.entity.User;

// Realiza a operação de criação de usuário
// O interctor acaba funcionando como um "service"
public class CreateUserInteractor {

    private UserGateway userGateway;

    // injeção de dependência via construtor
    public CreateUserInteractor(UserGateway userGateway) {
        this.userGateway = userGateway;
    }

    public User createUser(User user) {
        // Vou precisar do acesso ao repository do banco de dados
        // Para isso vamos criar o gateway

        return userGateway.createUser(user);
    }
    
}

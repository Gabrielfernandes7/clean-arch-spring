package com.cleanapi.springbootcleanarch.application.gateway;

import com.cleanapi.springbootcleanarch.domain.entity.User;

// Estrutura que vai nos perimitir criar um usuário
// O que preciso definir nessa interface é a assinatura de ciração de usuário
public interface UserGateway {
    User createUser(User user);
}

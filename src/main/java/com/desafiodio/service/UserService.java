package com.desafiodio.service;

import com.desafiodio.domain.model.User;

public interface UserService {

    User findById(Long id);

    User create(User userToCreate);
    
}

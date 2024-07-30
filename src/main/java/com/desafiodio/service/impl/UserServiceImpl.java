package com.desafiodio.service.impl;

import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import com.desafiodio.domain.model.User;
import com.desafiodio.domain.repository.UserRepository;
import com.desafiodio.service.UserService;

/**
 * Classe que implementa a interface UserService. Isso é uma boa prática
 * que garante que a implementação da classe de serviço não será exposta.
 * No caso é ma boa prática de encapsulamento, de não expor sua interface de uso.
 * @Service é para dizer que queremos que essa classe seja tratada como um Service
 */

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    /**
     * Injetando userRepository em meu construtor.
     * @param userRepository
     */
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Busca o usuário pelo id e caso não encontre lança uma NoSuchElementException
     */
    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    /**
     * Verifica se o usuário a ser criado já não existe através de seu account number.
     */
    @Override
    public User create(User userToCreate) {
        if (userRepository.existsByAccountNumber(userToCreate.getAccount().getNumber())) {
            throw new IllegalArgumentException("This Account number already exists.");
        }
        return userRepository.save(userToCreate);
    }
    
}

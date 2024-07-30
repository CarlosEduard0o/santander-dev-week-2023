package com.desafiodio.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.desafiodio.domain.model.User;

/**
 * JpaRepository<User, Long>, ou seja, JpaRepository usa
 * generics, que no meu contexto é de um User e Long
 * User porque é a entidade que estou trabalhando neste
 * repository e Long porque é o tipo da chave primária
 * desta minha entidade, que é o id.
 */

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
 
    //O spring já entende que o existsByAccountNumber 
    //precisa acessar e fazer um JOIN em uma tabela secundária
    boolean existsByAccountNumber(String accountNumber);
}

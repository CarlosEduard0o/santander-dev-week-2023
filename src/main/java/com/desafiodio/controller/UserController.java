package com.desafiodio.controller;

import java.net.URI;

import com.desafiodio.domain.model.User;
import com.desafiodio.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/users")
public class UserController {
    //Aqui utilizaremos, ou seja, iremos expor as classes que criamos
    //em nossa camada de serviço. Isso porque é a camada de serviço que
    //possui todas as regras de negócio.

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * ResponseEntity para podermos ter uma melhor 
     * apresentação das informações das requisições HTTP.
     * O que está dentro de <> é o tipo de retorno, que 
     * neste caso será User.
     * GetMapping é para dizer que esse método se trata de
     * um GET.
     * Além disso @PathVariable é para recuperar o /{id} e
     * injetar no findById.
     */
    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable("id") Long id) {
       var user = userService.findById(id);
       return ResponseEntity.ok(user);
    }

    /**
     * Post não recebe um PathVariable, pois ele precisa receber
     * todas as informações do usuário para poder persistir. Por
     * isso é usado @RequestBody invés de @PathVariable.
     * @param user
     * @return
     */
    @PostMapping
    public ResponseEntity<User> create(@RequestBody User userToCreate) {
        var userCreated = userService.create(userToCreate);
        //Em APIRest é interessante devolver, além da informação que o 
        //usuário foi criado, a localização dele. Para isso usamos o URI.
        //O Spring ja traz a implementação desse recurso URI. Para isso
        //Criamos o URI location. No caso location é a URL do usuario criado.
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(userCreated.getId())
            .toUri();

        //Agora, ao invés de usar o ResponseEntity.ok, usamos o
        //ResponseEntity.created(location).body(userCreated);
        return ResponseEntity.created(location).body(userCreated);
    }



}

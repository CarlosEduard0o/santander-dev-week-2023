package com.desafiodio.controller.exception;

import java.util.NoSuchElementException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class GlobalExceptionHandler {
    // Esta anotação é útil para centralizar os exceptions
    // O ResponseEntity é usado para melhorar os retornos de erro.

    //Usando @ExceptionHandler(IllegalArgumentException.class), pois quando
    //tentei cadastrar mais de um usuário com o mesmo número de conta me lançou
    //um IllegalArgumentException e ele não estava sendo tratado.
    //OBS.: numero da conta é unique, por isso não deixa repetir
    //Os erros foram sendo identificados durante testes, então fomos adicionando
    //métodos para tratar cada um desses erros.


    //Criando o logger para usar na classe handleUnexpectedException que lança
    //exceções gerais.
    private final Logger logger =  LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * 
     * @return String
     */
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleBusinessException(IllegalArgumentException businessException) {
        //HttpStatus.UNPROCESSABLE_ENTITY) é o erro 422, ou seja, quando der um erro
        //de negócio eu estarei retornando um erro 422 ao invés de 500.
        //Então vou refornar minha mensagem no corpo da resposta e o erro 422
       return new ResponseEntity<>(businessException.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
    }

    //HttpStatus.NOT_FOUND é o erro 404
    //NoSuchElementException não lançamos na mensagem como é no businessException
    //Neste cas colocamos uma mensagem como "Resource ID not found."
    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> handleNotFoundException(NoSuchElementException notFoundException) {
        return new ResponseEntity<>("Resource ID not found.", HttpStatus.NOT_FOUND);
    }

    //Aqui será tratado qualquer outro tipo de excessão diferente de IllegalArgumentException e NoSuchElementException
    @ExceptionHandler(Throwable.class)
    public ResponseEntity<String> handleUnexpectedException(Throwable unexpectedException) {
        var message = "Unexpected server error, see the logs.";
        logger.error("", unexpectedException);
        return new ResponseEntity<>(message, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

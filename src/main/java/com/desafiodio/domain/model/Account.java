package com.desafiodio.domain.model;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "tb_account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //@Column(unique = true) diz que
    //number é único, gera uma constraint
    @Column(unique = true)
    private String number;

    private String agency;

    //@Column(precision = 13, scale = 2) diz que
    //balance será um valor com 11 inteiros e 2
    //decimais, exemplo 10101010101.10
    //nullable = false diz que não aceita valor nulo
    // @Column(nullable = false, precision = 13, scale = 2)

    @Column(precision = 13, scale = 2)
    private BigDecimal balance;

    //Porque name = "additional_limit"?
    //Simples, a palavra limit pode ser palavra reservada
    //em alguns bancos de dados, para isso alteramos seu nome
    @Column(name = "additional_limit", precision = 13, scale = 2)
    private BigDecimal limit;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getAgency() {
        return agency;
    }

    public void setAgency(String agency) {
        this.agency = agency;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public BigDecimal getLimit() {
        return limit;
    }

    public void setLimit(BigDecimal limit) {
        this.limit = limit;
    }
    
}

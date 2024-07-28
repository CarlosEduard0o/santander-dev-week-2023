package com.desafiodio.domain.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity(name = "tb_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    //Um usuário tem uma conta
    //cascade = CascadeType.ALL significa que:
    //quando uma conta for deletada o usuário
    //será deletado junto.
    @OneToOne(cascade = CascadeType.ALL)
    private Account account;

    //Um para muitos, o fato de ser List já
    //indica o toMany
    //Um usuário tem uma lista de features
    //fetch = FetchType.EAGER é para dizer que
    //sempre que eu for buscar um usuário no banco
    //de dados eu sempre vou precisar da lista de
    //features deste cliente.
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Feature> features;

    //Um usuário tem um cartão
    //cascade = CascadeType.ALL significa que:
    //quando um cartão for deletado o usuário
    //será deletado junto.
    @OneToOne(cascade = CascadeType.ALL)
    private Card card;

    //Um para muitos, o fato de ser List já
    //indica o toMany
    //Um usuário tem uma lista de news
    //fetch = FetchType.EAGER é para dizer que
    //sempre que eu for buscar um usuário no banco
    //de dados eu sempre vou precisar da lista de
    //news deste cliente.
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<News> news;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public List<Feature> getFeatures() {
        return features;
    }

    public void setFeatures(List<Feature> features) {
        this.features = features;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public List<News> getNews() {
        return news;
    }
    
    public void setNews(List<News> news) {
        this.news = news;
    }
    
}

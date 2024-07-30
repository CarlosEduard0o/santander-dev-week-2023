package com.desafiodio.domain.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

/**
 * Essa classe abstrata foi criada para melhora o seguinte caso:
 * As entidades News e Features tinham os exatos mesmos atributos.
 * A única diferença entre elas era o nome.
 * Sendo assim, criamos essa classe abstrata com esses atributos,
 * onde News e Features herdará dela.
 * Para isso, usamos o conceito de padrões de projeto DRY.
 * DRY - Don't repeat yourself
 */
@MappedSuperclass
public abstract class BaseItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String icon;

    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

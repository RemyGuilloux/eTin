package dev.louiiuol.etin.domain.models;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Action extends AbstractEntity {

    private static final long serialVersionUID = -924764706329055084L;

    @Column(length = 20, nullable = false)
    private String name; 

    protected Action() {}

}
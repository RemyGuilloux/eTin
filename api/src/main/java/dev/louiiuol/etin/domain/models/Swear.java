package dev.louiiuol.etin.domain.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "swear")

public class Swear extends AbstractEntity{

	private static final long serialVersionUID = -8560959912330250597L;

	@Column(length=20, nullable = false)
    private String name; 

    @Column(nullable = false)
    private Integer multiplier;
    
    protected Swear() {}
    
}

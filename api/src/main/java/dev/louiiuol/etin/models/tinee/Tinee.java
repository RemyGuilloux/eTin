package dev.louiiuol.etin.models.tinee;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import dev.louiiuol.etin.models.AbstractEntity;
import dev.louiiuol.etin.models.Association;
import dev.louiiuol.etin.models.CustomUser;

/** <p> Describes a {@code Tinee}</p> */
@Entity
@Table(name="tinee")
public class Tinee extends AbstractEntity {

    private static final long serialVersionUID = 1336305530679958140L;

    @Column(length = 20, nullable = false)
    private String title;

    @Column(length = 280)
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private CustomUser author;

    @Column(nullable = false)
    private Boolean active;

    @OneToMany(fetch = FetchType.LAZY)
    private Set<Swear> swears;

    @Column(nullable = false)
    private LocalDate  endDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private Association goal;

    @Column(nullable = false)
    private Long maxAmount;

    @OneToMany(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
    private Set<Rule> rules;

    @Column(nullable = false, updatable = false)
    private LocalDate startDate = LocalDate.now();

    public Tinee() {  /* Default constructor with empty params */  }

	public void setActive(boolean active) { this.active = active; }
    
    public void setRules(Set<Rule> rules) { this.rules = rules; }

}

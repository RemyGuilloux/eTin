package dev.louiiuol.etin.domain.model;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="tinee")
public class Tinee extends AbstractEntity {

    /**
     *
     */
    private static final long serialVersionUID = 1336305530679958140L;

    @Column(length = 20, nullable = false)
    private String title;

    @Column(length = 280)
    private String description;

    @Column(nullable = false, updatable = false)
    private LocalDate startDate;

    @Column(nullable = false)
    private LocalDate  endDate;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private Set<User> members;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private User author;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private Action goal;

    @Column(nullable = false)
    private Long maxAmount;

    @Column(nullable = false)
    private Long balance;

    @OneToMany(fetch = FetchType.LAZY)
    private Set<Swear> swears;

    protected Tinee(){}
    
}

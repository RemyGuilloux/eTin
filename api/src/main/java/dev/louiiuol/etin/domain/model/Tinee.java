package dev.louiiuol.etin.domain.model;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="tinee")
public class Tinee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Set<User> getMembers() {
        return members;
    }

    public void setMembers(Set<User> members) {
        this.members = members;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Action getGoal() {
        return goal;
    }

    public void setGoal(Action goal) {
        this.goal = goal;
    }

    public Long getMaxAmount() {
        return maxAmount;
    }

    public void setMaxAmount(Long maxAmount) {
        this.maxAmount = maxAmount;
    }

    public Set<Swear> getSwears() {
        return swears;
    }

    public void setSwears(Set<Swear> swears) {
        this.swears = swears;
    }
    
    
}

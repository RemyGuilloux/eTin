package dev.louiiuol.etin.domain.model.dtos.request;

import java.time.LocalDate;
import java.util.Set;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import dev.louiiuol.etin.domain.model.Swear;

public class TineeCreateDto {

    @NotBlank
    private String title;

    private String description;

    private LocalDate startDate = LocalDate.now();

    @NotNull
    private LocalDate  endDate; 

    @NotNull
    private Set<Long> members; 

    @NotNull
    private UserIdDto author;

    @NotNull
    private GoalIdDto goal;

    @NotNull
    private Long maxAmount;

    @NotNull
    private Long balance = (long) 0;

    private Set<Swear> swears;

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

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Set<Long> getMembers() {
        return members;
    }

    public void setMembers(Set<Long> members) {
        this.members = members;
    }

    public UserIdDto getAuthor() {
        return author;
    }

    public void setAuthor(UserIdDto author) {
        this.author = author;
    }

    public GoalIdDto getGoal() {
        return goal;
    }

    public void setGoalId(GoalIdDto goal) {
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

    public void setGoal(GoalIdDto goal) {
        this.goal = goal;
    }

    public Long getBalance() {
        return balance;
    }
    
}
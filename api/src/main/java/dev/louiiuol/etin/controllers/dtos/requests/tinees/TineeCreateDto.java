package dev.louiiuol.etin.controllers.dtos.requests.tinees;

import java.time.LocalDate;
import java.util.Set;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import dev.louiiuol.etin.controllers.dtos.requests.tinees.rules.TineeRuleCreateDto;
import dev.louiiuol.etin.controllers.utils.EntityIdDto;

/** <p> A DTO representing the {@code TineeCreateDto} to create new {@code Tinee} </p> */
public class TineeCreateDto {

    /** <p> The title of the TInee. </p> */
    @NotBlank
    private String title;

    /** <p> The description of the TInee. </p> */
    @Size(max=280)
    private String description;

    /** <p> The end date of the TInee. </p> */
    @NotNull
    private LocalDate  endDate; 

    /** <p> The athor of the TInee. </p>  */
    @NotNull
    private EntityIdDto author;

    /** <p> The goal of the TInee. </p>  */
    @NotNull
    private EntityIdDto goal;

    /** <p> The max amount of the TInee. </p>  */
    @NotNull
    private Long maxAmount;

     /** <p> The rules defined of the TInee. </p>  */
    @NotNull
    private Set<TineeRuleCreateDto> rules;

    
    /** <p> Default empty no-arg constructor </p>  */
    protected TineeCreateDto() {}

    /** <p> Return Tinee's title </p>  */
    public String getTitle() { return title; }

    /** <p> Return Tinee's description </p>  */
    public String getDescription() { return description; }

    /** <p> Return Tinee's end date set on creation </p>  */
    public LocalDate getEndDate() { return endDate; }

    /** <p> Return Tinee's author </p>  */
    public EntityIdDto getAuthor() { return author; }

    /** <p> Return Tinee's goal (actions) </p>  */
    public EntityIdDto getGoal() { return goal; }

    /** <p> Return Tinee's max amount set on creation </p>  */
    public Long getMaxAmount() { return maxAmount; }

    /** <p> Return Tinee's rules set on creation </p>  */
    public Set<TineeRuleCreateDto> getRules() { return rules; }

}
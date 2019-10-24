package dev.louiiuol.etin.domain.models.dtos.requests;

import java.time.LocalDate;
import java.util.Set;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * A DTO representing the {@code TineeCreateDto} to create new {@code Tinee}
 */
public class TineeCreateDto {

    /**
     * The title of the given entity.
     */
    @NotBlank
    private String title;

    /**
     * The description of the given entity.
     */
    private String description;

    /**
     * The starting date of the given entity.
     */
    private LocalDate startDate = LocalDate.now();

    /**
     * The end date of the given entity.
     */
    @NotNull
    private LocalDate  endDate; 

    /**
     * The Set of members of the given entity.
     */
    @NotNull
    private Set<Long> members; 

    /**
     * The athor of the given entity.
     */
    @NotNull
    private EntityIdDto author;

    /**
     * The goal of the given entity.
     */
    @NotNull
    private EntityIdDto goal;

    /**
     * The max amount of the given entity.
     */
    @NotNull
    private Long maxAmount;

    /**
     * The balance of the given entity.
     */
    @NotNull
    private Long balance = (long) 0;
    
    /**
     * Default empty no-arg constructor
     */
    protected TineeCreateDto() {}
}
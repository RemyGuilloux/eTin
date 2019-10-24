package dev.louiiuol.etin.domain.models.dtos.requests;

import java.time.LocalDate;
import java.util.Set;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

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
    private EntityIdDto author;

    @NotNull
    private EntityIdDto goal;

    @NotNull
    private Long maxAmount;

    @NotNull
    private Long balance = (long) 0;
    
    /**
     * Default empty no-arg constructor
     */
    protected TineeCreateDto() {}
}
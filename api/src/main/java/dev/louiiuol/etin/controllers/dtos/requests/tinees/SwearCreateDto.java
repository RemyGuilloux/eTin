package dev.louiiuol.etin.controllers.dtos.requests.tinees;

import javax.validation.constraints.NotBlank;

import dev.louiiuol.etin.controllers.utils.EntityIdDto;

public class SwearCreateDto {

    @NotBlank
    private String name;

    private String severity;

    private Double amount;

    private String proof;

    private EntityIdDto author;

    private EntityIdDto reporter;

    public EntityIdDto getAuthor() { return this.author; }
    public Double getAmount() { return this.amount; }

}

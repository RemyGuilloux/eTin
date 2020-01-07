package dev.louiiuol.etin.controllers.dtos.requests.tinees.rules;

import javax.validation.constraints.NotNull;

public class TineeRuleCreateDto {

    @NotNull
    private String severity; 

    @NotNull
    private Double multiplier;

    protected TineeRuleCreateDto() { }
    public String getSeverity() { return severity; }

    public Double getMultiplier() { return multiplier; }

}

package dev.louiiuol.etin.controllers.dtos.responses;

public class TineeViewDto {

    private String title;

    private String description;

    private Boolean active;

    private Long maxAmount;

    protected TineeViewDto() {
    }

    public Boolean getActive() { return active; }

    public String getDescription() { return description; }

    public Long getMaxAmount() { return maxAmount; }

    public String getTitle() { return title; }

}

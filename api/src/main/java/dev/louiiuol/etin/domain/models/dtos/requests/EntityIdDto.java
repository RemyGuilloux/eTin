package dev.louiiuol.etin.domain.models.dtos.requests;

/**
 * A DTO representing the {@code id} of an entity.
 */
public class EntityIdDto {

    /**
     * The id of the given entity.
     */
    private Long id;

    /**
     * Default empty no-arg constructor
     */
    protected EntityIdDto() {}

    /**
     * Overriding method to return JSON naturally
     */
    @Override
    public String toString() {
        return "{id=" + id + "}";
    }
    
}
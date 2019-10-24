package dev.louiiuol.etin.domain.model.dtos.request;

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

    @Override
    public String toString() {
        return "{id=" + id + "}";
    }
    
}
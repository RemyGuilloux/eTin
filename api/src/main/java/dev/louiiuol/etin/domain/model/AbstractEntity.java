package dev.louiiuol.etin.domain.model;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * Abstract class representing the identifier of an {@code Entity}.
 * <p>
 * Provides primary key to each {@code Entity} that extends it.
 */
@MappedSuperclass
@SuppressWarnings("serial")
public abstract class AbstractEntity implements Serializable {

    /**
     * Returns the identifier of an {@code Entity} extending
     * {@linkplain AbstractEntity}.
     * 
     * @return an identifier
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Override
    public String toString() {
        return "id=" + id;
    }

}
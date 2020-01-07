package dev.louiiuol.etin.models.tinee;

import java.text.MessageFormat;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;

import dev.louiiuol.etin.models.AbstractEntity;

/** <p> Describes a {@code Tinee}'s rules </p> */
@Entity
public class Rule extends AbstractEntity {

    private static final long serialVersionUID = -1206917401021401326L;

    @Column(nullable = false, updatable = false)
    private String severity;

    @Column(nullable = false)
    private Double multiplier;

    protected Rule() { /* Default constructor with empty param */ }

    @Override
    public int hashCode() { return Objects.hash(severity, multiplier); }

    @Override
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if ( !(obj instanceof Rule) )
			return false;
		return severity.equals(( (Rule) obj ).severity) && multiplier.equals(( (Rule) obj ).multiplier);
    }

    @Override
    public String toString() { return MessageFormat.format("[ severity: {0}, multiplier: {1} ] ", severity, multiplier); }

}

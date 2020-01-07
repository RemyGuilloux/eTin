package dev.louiiuol.etin.models.tinee;

import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import dev.louiiuol.etin.models.AbstractEntity;
import dev.louiiuol.etin.models.CustomUser;

/** <p> Describes a {@code CustomUser}'s swear</p> */
@Entity
@Table(name="swear")
public class Swear extends AbstractEntity {

    private static final long serialVersionUID = -8560959912330250597L;

    @Column(length = 20, nullable = false)
    private String name;

    @Column(nullable = false, updatable = false)
    private String severity;

    @Column(nullable = false)
    private Double amount;

    //@Column(nullable = this.author == this.reporter)
    @Column
    private String proof;

    @Column(nullable = false)
    private CustomUser author;

    @Column
    private CustomUser reporter;

    @Column(nullable = false, updatable = false)
    private LocalDateTime date = LocalDateTime.now();

    protected Swear() { /* Default constructor with empty param */ }

    @Override
    public int hashCode() { return Objects.hash(name, severity, amount, proof, author, reporter, date); }

    @Override
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if ( !(obj instanceof Swear) )
			return false;
		return name.equals(( (Swear) obj ).name) && author.equals(( (Swear) obj ).author) && date.equals( ((Swear) obj ).date);
    }

    @Override
    public String toString() { return MessageFormat.format("[ name: {0}, author: {1}, amount: {2}, date: {3}, reporter: {4}, proof: {5} ] ", name, author, amount, date, reporter, proof); }

}

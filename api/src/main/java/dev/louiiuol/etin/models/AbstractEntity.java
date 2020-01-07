package dev.louiiuol.etin.models;

import java.io.Serializable;
import java.text.MessageFormat;
import java.util.Objects;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/** <p> Provides primary key to each {@code Entity} that extends it. </p> */
@MappedSuperclass
public abstract class AbstractEntity implements Serializable {

    private static final long serialVersionUID = 4461731511372760807L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public void setId(Long id) { this.id =id; }

    public Long getId() { return id; }

    @Override
    public int hashCode() { return Objects.hash(id); }

    @Override
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if ( !(obj instanceof AbstractEntity) )
			return false;
		return id.equals(( (AbstractEntity) obj ).id);
    }

    @Override
    public String toString() { return MessageFormat.format("[ id: {0} ] ", id); }

}
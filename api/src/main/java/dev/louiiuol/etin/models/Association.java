package dev.louiiuol.etin.models;

import java.text.MessageFormat;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/** <p> Describes an {@code Association}: it will be used when the tinee is complete => Users will send payment to it </p> */
@Entity
@Table(name = "association")
public class Association  extends AbstractEntity {

    private static final long serialVersionUID = 6670582233712532279L;

    @Column(length = 20, nullable = false)
    private String name; 

    @Column
    private String description; 

    @Column
    private Long balance;
    
    protected Association() {  }

    public String getName() { return name; }

    public String getDescription() { return description; }

    public Long getBalance() { return balance; }

    @Override
    public int hashCode() { return Objects.hash(name, description, balance ); }

    @Override
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if ( !(obj instanceof Association) )
			return false;
		return name.equals(( (Association) obj ).name);
    }

    @Override
    public String toString() { return MessageFormat.format("Custom-User#{0}: [name: {1}, description: {2}, balance: {3}, enabled: {4} ]", getId(), name, description, balance ); }

}
package dev.louiiuol.etin.models;

import java.text.MessageFormat;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import dev.louiiuol.etin.services.utils.BooleanConverter;

/** <p> Describes a {@code Role}</p> */
@Entity
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 256, nullable = false, unique = true)
    private String code;

    @Convert(converter = BooleanConverter.class)
    @Column(length = 1, nullable = false)
    private boolean defaultRole = false;

    protected Role() { }

    public Role(String code) { setCode(code); }

    public Long getId() { return id; }

    public String getCode() { return code; }

    private void setCode(String code) { this.code = code; }

    public boolean isDefaultRole() { return defaultRole; }

    @Override
    public int hashCode() { return Objects.hash(code, defaultRole ); }

    @Override
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if ( !(obj instanceof Role) )
			return false;
		return code.equals(( (Role) obj ).code);
    }
    
    @Override
    public String toString() { return MessageFormat.format("Role#{0}: [code: {1} ]", id, code); }
}

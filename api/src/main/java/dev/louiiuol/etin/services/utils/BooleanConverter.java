package dev.louiiuol.etin.services.utils;

import javax.persistence.AttributeConverter;

/** <p> A custom converter to convert entity {@code Boolean} attribute state into
 * database column representation and back again: converts {@code Boolean} from/to {@code String}s such as: </p>
 * <li>{@code Boolean.TRUE} from/to {@code "T"} </li>
 * <li>{@code Boolean.FALSE} from/to {@code "F"} </li>  */
public class BooleanConverter implements AttributeConverter<Boolean, String> {

    @Override
    public String convertToDatabaseColumn(Boolean value) { return Boolean.TRUE.equals(value) ? "T" : "F"; }

    @Override
    public Boolean convertToEntityAttribute(String value) { return "T".equals(value); }
}

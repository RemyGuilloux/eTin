package dev.louiiuol.etin.controllers.utils.errors;

import java.io.Serializable;

/** Represents a validation error */
public final class ValidationError implements Serializable {

    private static final long serialVersionUID = -3177218154124197588L;

    private String entityName;

    private String fieldName;

    private String error;

    private Type type = Type.FIELD;

    private ValidationError(String entityName, String fieldName, String error) {
        this.entityName = entityName;
        this.fieldName = fieldName;
        this.error = error;
    }

    public String getEntityName() { return entityName; }

    /** <p> Return the field name, global validator name in case of global error. </p>
     * @return the field name or global validator name */
    public String getFieldName() { return fieldName; }

    /** <p> Returns the error code or message. </p>
     * @return the error code or message */
    public String getError() { return error; }

    /** <p> Returns the type of error. </p>
     * @return the type of error */
    public Type getType() { return type; }

    public static ValidationError ofGlobalType(String entityName,  String fieldName, String errorMessage) {
        ValidationError error = new ValidationError(entityName, fieldName, errorMessage);
        error.type = Type.GLOBAL;
        return error;
    }

    public static ValidationError ofFieldType(String entityName, String fieldName, String errorMessage) { 
        return new ValidationError(entityName, fieldName, errorMessage); 
    }

    @Override
    public String toString() { 
        return "{entityName=" + entityName + ", fieldName=" + fieldName+ ", error=" + error + ", type=" + type + "}"; 
    }

    public static enum Type { FIELD, GLOBAL;  }

}
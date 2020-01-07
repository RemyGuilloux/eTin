package dev.louiiuol.etin.controllers.auth;

public class ResourceNotFoundException extends RuntimeException {

    private static final long serialVersionUID = -2116382467187866675L;

    public ResourceNotFoundException() { }

    public ResourceNotFoundException(String message) { super(message); }
}

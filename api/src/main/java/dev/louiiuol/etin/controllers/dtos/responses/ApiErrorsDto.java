package dev.louiiuol.etin.controllers.dtos.responses;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.*;

/** <p> This class represents some validation errors.  </p> */
public final class ApiErrorsDto<T> implements Serializable {

    private static final long serialVersionUID = 7277092767926099434L;

    private final List<T> errors;

    private final int errorCount;

    private final LocalDateTime timestamp = LocalDateTime.now();

    private final int status;

    private final String path;

    /** <p> Creates a new {@code ErrorDetails} with given validation errors. </p>
     * @throws NullPointerException if {@code errors} is {@code null */
    public ApiErrorsDto(List<T> errors, int status, String path) {
        this.errors = Collections.unmodifiableList(errors);
        errorCount = errors.size();
        this.status = status;
        this.path = path;
    }

    /** <p> Returns an immutable list of {@code ValidationError}s. </p>
     *  @return an immutable list of {@code ValidationError}s; 
     *  never {@code null}, may be empty */
    public List<T> getErrors() { return errors; }

    /** <p> Returns the number of validation errors contained in this {@code error details}. </p>
     * @return the number of validation errors */
    public int getErrorCount() { return errorCount; }

    /** <p> Returns the time this {@code error details} was constructed. </p>
     * @return the time this {@code error details} was constructed */
    public LocalDateTime getTimestamp() { return timestamp; }

    /** <p> Returns the HTTP status code for this {@code error details}. </p>
     * @return the HTTP status code */
    public int getStatus() { return status; }

    /** <p> Returns the requested path which produced this {@code error details}. </p>
     * @return the requested path */
    public String getPath() { return path; }

    /** <p> Returns a string representation of this {@code error details}. </p>
     * @return a string representation of this {@code error details} */
    @Override
    public String toString() { return "{errorCount=" + errorCount + ", timestamp=" + timestamp + ", status=" + status + ", path=" + path + "}"; }

}
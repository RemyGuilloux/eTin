package dev.louiiuol.etin.controllers.utils.errors;

import java.io.Serializable;

/** <p> Represents a message not readable error. </p */
public class MessageNotReadableError implements Serializable {

    private static final long serialVersionUID = -6144595402971494591L;

    private String cause;

    private String error = "{E_MESSAGE_NOT_READABLE}";

    /** <p> Creates a new {@code MessageNotReadableError} with default {@code null} values. </p> */
    public MessageNotReadableError() { /* Default no-arg constructor */ }

    /** <p> Creates a new {@code MessageNotReadableError} with given values. </p>
     * @param*/
    public MessageNotReadableError(String cause) { setCause(cause); }

    /** <p> Returns reason why the message is not readable</p> */
    public String getCause() { return cause; }

    /** <p> Sets reason why the message is not readable</p> */
    public void setCause(String cause) { this.cause = cause; }

    /** <p> Returns error message </p> */
    public String getError() { return error;  }

    /** <p> Creates a new {@code MessageNotReadableError} as string </p> */
    @Override
    public String toString() { return "{cause=" + cause + ", error=" + error + "}"; }

}
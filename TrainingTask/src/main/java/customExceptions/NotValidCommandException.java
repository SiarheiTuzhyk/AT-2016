package customExceptions;

import java.io.IOException;

/**
 * Exception class for entered invalid command.
 * @author Siarhei_Tuzhyk
 */
public class NotValidCommandException extends IOException {

    public NotValidCommandException(String message) {
        super(message);
    }
}

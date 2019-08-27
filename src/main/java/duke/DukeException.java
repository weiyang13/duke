package duke;

/**
 * Encapsulates an exception that occurs within the chatbot from unexpected or undefined behavior.
 */
public class DukeException extends Exception {
    /**
     * Initializes a DukeException object.
     *
     * @param message Message detailing exception encountered.
     */
    public DukeException(String message) {
        super(message);
    }
}

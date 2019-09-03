package duke;

import java.util.Scanner;

/**
 * Encapsulates the unit managing user interface for Duke.
 * Acts as a builder for the response of Duke.
 * Duke's response is stored here, and flushed when necessary.
 */

public class Ui {
    /** String storing unflushed response of chatbot. */
    private String response;

    /**
     * Initializes a Ui object.
     */
    public Ui() {
        response = "";
    }

    /**
     * Flushes response buffer of Ui and returns stored String.
     * @return Message stored in the buffer.
     */
    public String flush() {
        String buffer = response;
        response = "";
        return buffer;
    }

    /**
     * Returns the greeting message when the chatbot initializes.
     *
     * @param hasLoadingError Whether there is an error in loading saved tasks.
     * @return Greeting message.
     */
    public String greet(boolean hasLoadingError) {
        if (hasLoadingError) {
            return "Hello, fellow citizen. It appears your tea has spilled. I'll get Jeeves to prepare a new cup.";
        } else {
            return "Hello, fellow citizen. Have you had your cup of tea?";
        }
    }

    /**
     * Concatenates response buffer with message indicating an error due to user input.
     *
     * @param message String containing details of error.
     */
    public void addError(String message) {
        printLine("OOPS!!! " + message + " :( :(");
    }

    /**
     * Concatenates response buffer with text.
     *
     * @param string String containing response of chatbot.
     */
    public void printLine(String string) {
        if (!response.equals("")) {
            response += "\n";
        }
        response += string;
    }
}

package duke;

import java.util.Scanner;

/**
 * Encapsulates the unit managing user interface for Duke.
 */

public class Ui {
    /** Scanner object that receives user input. */
    private String response;

    /**
     * Initializes a Ui object.
     */
    public Ui() {
        response = "";
    }

    public String flush() {
        String buffer = response;
        response = "";
        return buffer;
    }

    public String greet(boolean hasLoadingError) {
        if (hasLoadingError) {
            return "Hello, fellow citizen. It appears your tea has spilled. I'll get Jeeves to prepare a new cup.";
        } else {
            return "Hello, fellow citizen. Have you had your cup of tea?";
        }
    }

    /**
     * Prints a message indicating an error due to user input.
     *
     * @param message String containing details of error.
     */
    public void addError(String message) {
        printLine("OOPS!!! " + message + " :( :(");
    }

    /**
     * Prints an indented line with chatbot responses.
     *
     * @param string String containing response of chatbot.
     */
    public void printLine(String string) {
        System.out.println("response1 is: " + response);
        if (!response.equals("")) {
            response += "\n";
        }
        System.out.println("screw you: " + response);
        response += string;
        System.out.println("yay? " + response);
    }
}

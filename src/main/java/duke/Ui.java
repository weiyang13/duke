package duke;

import java.util.Scanner;

/**
 * Encapsulates the unit managing user interface for Duke.
 */

public class Ui {
<<<<<<< HEAD
=======
    /** Scanner object that receives user input. */
>>>>>>> branch-A-JavaDoc
    private Scanner input;

    /**
     * Initializes a Ui object.
     */
    public Ui() {
        input = new Scanner(System.in);
    }

    /**
     * Prints an error message for when a loading error occurs.
     */
    public void showLoadingError() {
        System.out.println("LOADING ERROR. Creating new storage file.");
    }

    /**
     * Prints a welcome message. To be called when Duke starts to run.
     */
    public void showWelcome() {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        printLine("Hello! I'm Duke!");
        printLine("What can I do for you?");
    }

    /**
     * Prints a line to separate user input and chatbot responses.
     */
    public void showLine() {
        System.out.println("    ______________________________________________________________________");
    }

    /**
     * Prints a message indicating an error due to user input.
     *
     * @param message String containing details of error.
     */
    public void showError(String message) {
        printLine("OOPS!!! " + message + " :( :(");
    }

    /**
     * Prints an indented line with chatbot responses.
     *
     * @param string String containing response of chatbot.
     */
    public void printLine(String string) {
        System.out.println("     " + string);
    }

    /**
     * Reads next line of user input.
     *
     * @return String containing user input, ending with newline character.
     */
    public String readCommand() {
        return input.nextLine();
    }
}

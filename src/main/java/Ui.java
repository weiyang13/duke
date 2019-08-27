import java.util.Scanner;

public class Ui {
    Scanner input;

    public Ui() {
        input = new Scanner(System.in);
    }

    public void showLoadingError() {
    }

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

    public void showLine() {
        System.out.println("    ______________________________________________________________________");
    }

    public void showError(String message) {
        printLine("OOPS!!! " + message + " :( :(");
    }

    public void printLine(Object object) {
        System.out.println("     " + object.toString());
    }

    public String readCommand() {
        return input.nextLine();
    }
}

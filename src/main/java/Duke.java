import java.util.Scanner;
import java.util.ArrayList;

public class Duke {
    ArrayList<String> taskList;
    Scanner input;

    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        Duke duke = new Duke();
        duke.greet();
        duke.readCommand();
    }

    public Duke() {
        taskList = new ArrayList<>();
        input = new Scanner(System.in);
    }

    public void greet() {
        printHorizontal();
        printLine("Hello! I'm Duke");
        printLine("What can I do for you?");
        printHorizontal();
    }

    public void readCommand() {
        String cmd = input.nextLine();
        if (cmd.equals("bye")) {
            bye();
        } else if (cmd.equals("list")) {
            list();
            readCommand();
        } else {
            add(cmd);
            readCommand();
        }
    }

    public void list() {
        printHorizontal();
        printHorizontal();
    }

    public void add(String task) {
        printHorizontal();
        printHorizontal();
    }

    public void bye() {
        printHorizontal();
        printLine("Bye. Hope to see you again soon!");
        printHorizontal();
    }

    public void printHorizontal() {
        System.out.println("    ____________________________________________________________");
    }

    public void printLine(String output) {
        System.out.println("     " + output);
    }
}

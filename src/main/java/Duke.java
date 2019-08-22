import java.util.Scanner;
import java.util.ArrayList;

import java.lang.NumberFormatException;

public class Duke {
    protected ArrayList<Task> tasks;
    protected Scanner input;

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
        tasks = new ArrayList<>();
        input = new Scanner(System.in);
    }

    public void greet() {
        printHorizontal();
        printWithIndentation("Hello! I'm Duke");
        printWithIndentation("What can I do for you?");
        printHorizontal();
    }

    public void readCommand() {
        String command = input.nextLine();
        String[] commandTokens = command.split(" ");
        if (command.equals("bye")) {
            exit();
        } else if (command.equals("list")) {
            list();
            readCommand();
        } else {
            switch (commandTokens[0]) {
            case "done":
                markAsDone(commandTokens);
                break;
            case "todo":
                addToDo(commandTokens);
                break;
            case "deadline":
                addDeadline(commandTokens);
                break;
            case "event":
                addEvent(commandTokens);
                break;
            }
            readCommand();
        }
    }

    public void addToDo(String[] commandTokens) {
        String description = "";
        for (int i = 1; i < commandTokens.length; i++) {
            description += commandTokens[i] + " ";
        }
        description = description.substring(0, description.length() - 1);

        Task task = new ToDo(description);
        tasks.add(task);

        printHorizontal();
        printWithIndentation("Got it. I've added this task:");
        printWithIndentation("  " + task);
        printWithIndentation("Now you have " + tasks.size() +
                " in the list.");
        printHorizontal();
    }

    public void addDeadline(String[] commandTokens) {
        String description = "";
        String by = "";
        int i;
        for (i = 1; i < commandTokens.length; i++) {
            if (commandTokens[i].equals("/by")) {
                break;
            }
            description += commandTokens[i] + " ";
        }
        description = description.substring(0, description.length() - 1);

        for (i++; i < commandTokens.length; i++) {
            by += commandTokens[i] + " ";
        }
        by = by.substring(0, by.length() - 1);

        Task task = new Deadline(description, by);
        tasks.add(task);

        printHorizontal();
        printWithIndentation("Got it. I've added this task:");
        printWithIndentation("  " + task);
        printWithIndentation("Now you have " + tasks.size() +
                " in the list.");
        printHorizontal();
    }

    public void addEvent(String[] commandTokens){

    }

    public void markAsDone(String[] commandTokens) {
        try {
            int itemNo = Integer.parseInt(commandTokens[1]);
            Task task = tasks.get(itemNo - 1);
            task.setIsDone(true);
            printHorizontal();
            printWithIndentation("Nice! I've marked this task as done:");
            printWithIndentation("  " + task);
            printHorizontal();
        } catch (NumberFormatException e) {
            printHorizontal();
            printWithIndentation(e.toString());
            printHorizontal();
        }
    }

    public void list() {
        printHorizontal();
        int i = 1;
        String output = "";
        for (Task task : tasks) {
            printWithIndentation(i + ". " + task);
            i++;
        }
        printHorizontal();
    }


    public void exit() {
        printHorizontal();
        printWithIndentation("Bye. Hope to see you again soon!");
        printHorizontal();
    }

    public void printHorizontal() {
        System.out.println("    ____________________________________________________________");
    }

    public void printWithIndentation(String output) {
        System.out.println("     " + output);
    }
}

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
        try {
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
                default:
                    throw new DukeException("OOPS!! Sorry, I do not know what that means :(");
                }
                readCommand();
            }
        } catch (DukeException e) {
            printHorizontal();
            printWithIndentation(e.toString());
            printHorizontal();
            readCommand();
        }
    }

    public void addTask(Task task) {
        tasks.add(task);
        printHorizontal();
        printWithIndentation("Got it. I've added this task:");
        printWithIndentation("  " + task);
        printWithIndentation("Now you have " + tasks.size() +
                " in the list.");
        printHorizontal();
    }

    public void addToDo(String[] commandTokens) throws DukeException {
        if (commandTokens.length == 1) {
            throw new DukeException("OOPS! Description for todo must not be empty :(");
        }

        String description = "";
        for (int i = 1; i < commandTokens.length; i++) {
            description += commandTokens[i] + " ";
        }
        description = description.substring(0, description.length() - 1);

        Task task = new ToDo(description);
        addTask(task);
    }

    public void addDeadline(String[] commandTokens) throws DukeException {
        if (commandTokens.length == 1 || commandTokens[1].equals("/by")) {
            throw new DukeException("OOPS! Description for deadline must not be empty :(");
        }

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

        if (i == commandTokens.length) {
            throw new DukeException("OOPS! Indicate date/time for deadline with '/by/' :(");
        } else if (i == commandTokens.length - 1) {
            throw new DukeException("OOPS! Date/time for deadline must not be empty :(");
        }

        for (i++; i < commandTokens.length; i++) {
            by += commandTokens[i] + " ";
        }
        by = by.substring(0, by.length() - 1);

        Task task = new Deadline(description, by);
        addTask(task);
    }

    public void addEvent(String[] commandTokens) throws DukeException {
        if (commandTokens.length == 1 || commandTokens[1].equals("/at")) {
            throw new DukeException("OOPS! Description for event must not be empty :(");
        }

        String description = "";
        String at = "";
        int i;
        for (i = 1; i < commandTokens.length; i++) {
            if (commandTokens[i].equals("/at")) {
                break;
            }
            description += commandTokens[i] + " ";
        }
        description = description.substring(0, description.length() - 1);

        if (i == commandTokens.length) {
            throw new DukeException("OOPS! Indicate date/time for event with '/at/' :(");
        } else if (i == commandTokens.length - 1) {
            throw new DukeException("OOPS! Date/time for event must not be empty :(");
        }

        for (i++; i < commandTokens.length; i++) {
            at += commandTokens[i] + " ";
        }
        at = at.substring(0, at.length() - 1);

        Task task = new Event(description, at);
        addTask(task);
    }

    public void markAsDone(String[] commandTokens) throws DukeException {
        if (commandTokens.length != 2) {
            throw new DukeException("OOPS! 'done' command must be followed by a single integer :(");
        }

        try {
            int itemNo = Integer.parseInt(commandTokens[1]);
            if (itemNo > tasks.size() || itemNo < 1) {
                throw new DukeException("OOPS! Invalid item number for 'done' command :(");
            }

            Task task = tasks.get(itemNo - 1);
            if (task.getIsDone()) {
                throw new DukeException("OOPS! Task " + itemNo + " is already done :(");
            }
            task.setIsDone(true);

            printHorizontal();
            printWithIndentation("Nice! I've marked this task as done:");
            printWithIndentation("  " + task);
            printHorizontal();
        } catch (NumberFormatException e) {
            throw new DukeException("OOPS! 'done' command must be followed by a single integer :(");
        }
    }

    public void list() throws DukeException {
        if (tasks.size() == 0) {
            throw new DukeException("OOPS! You have no tasks to display :(");
        }

        printHorizontal();
        int i = 1;
        for (Task task : tasks) {
            printWithIndentation(i + "." + task);
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
        System.out.println("    ______________________________________________________________________");
    }

    public void printWithIndentation(String output) {
        System.out.println("     " + output);
    }
}

import java.util.Scanner;
import java.util.ArrayList;

public class Duke {
    ArrayList<String> taskList;

    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        Scanner input = new Scanner(System.in);
        Duke duke = new Duke();
        duke.greet();
        duke.readCommand(input);
    }

    public Duke() {
        taskList = new ArrayList<>();
    }

    public void greet() {
        System.out.println("Hello! I'm Duke");
        System.out.println("What can I do for you?");
    }

    public void readCommand(Scanner input) {
        String cmd = input.nextLine();
        if (cmd.equals("bye")) {
            bye();
        } else if (cmd.equals("list")) {
            list();
        } else {
            add(cmd);
            readCommand(input);
        }
    }

    public void list() {

    }

    public void add(String task) {
        
    }

    public void bye() {
        System.out.println("Bye. Hope to see you again soon!");
    }
}

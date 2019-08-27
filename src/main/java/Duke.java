public class Duke {
    private Storage storage;
    private TaskList tasks;
    private Ui ui;

    public Duke(String filePath) {
        ui = new Ui();
        storage = new Storage(filePath);
        try {
            tasks = new TaskList(storage.load());
        } catch (DukeException e) {
            ui.showLoadingError();
            tasks = new TaskList();
        }
    }

    public void run() {
        ui.showWelcome();
        boolean isExit = false;
        while (!isExit) {
            try {
                String fullCommand = ui.readCommand();
                ui.showLine();
                Command c = Parser.parse(fullCommand);
                c.execute(tasks, ui, storage);
                isExit = c.isExit();
            } catch (DukeException e) {
                ui.showError(e.getMessage());
            } finally {
                ui.showLine();
            }
        }
    }

    public static void main(String[] args) {
        new Duke("data/tasks.txt").run();
    }
}

/*

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

    public void deleteItem(String[] commandTokens) throws DukeException {
        if (commandTokens.length != 2) {
            throw new DukeException("OOPS! 'delete' must be followed by an integer :(");
        }

        try {
            int itemNo = Integer.parseInt(commandTokens[1]);
            if (itemNo > tasks.size() || itemNo < 1) {
                throw new DukeException("OOPS! Invalid task number for 'delete' command :(");
            }


            printHorizontal();
        } catch (NumberFormatException e) {
            throw new DukeException("OOPS! 'delete' must be followed by an integer :(");
        }
    }

    public void listTasks() throws DukeException {
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
    */

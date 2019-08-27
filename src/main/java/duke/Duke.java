package duke;

import duke.command.Command;

/**
 * Encapsulates chatbot 'Duke'. Contains main method for chatbot
 */

public class Duke {
    /** Unit that manages saved data of task list. */
    private Storage storage;
    /** List of tasks tracked by Duke. */
    private TaskList tasks;
    /** Unit that manages user interface of Duke. */
    private Ui ui;

    /**
     * Initializes a Duke object.
     *
     * @param filePath Pathname of the file used for storing data.
     */
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

    /**
     * Runs the chatbot.
     */
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

    /**
     * Creates the chatbot and runs it.
     *
     * @param args Command line arguments (unused).
     */
    public static void main(String[] args) {
        new Duke("data/tasks.txt").run();
    }
}

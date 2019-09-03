package duke;

import duke.command.Command;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * Encapsulates chatbot 'Duke'. Contains main method for chatbot
 */
public class Duke extends Application {
    /** Unit that manages saved data of task list. */
    private Storage storage;
    /** List of tasks tracked by Duke. */
    private TaskList tasks;
    /** Unit that manages user interface of Duke. */
    private Ui ui;

    public Duke() {
    }

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

    @Override
    public void start(Stage stage) {
        Label helloWorld = new Label("Hello World!"); // Creating a new Label control
        Scene scene = new Scene(helloWorld); // Setting the scene to be our Label

        stage.setScene(scene); // Setting the stage to show our screen
        stage.show(); // Render the stage.
    }
}

package duke;

import duke.command.Command;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

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
    private String filePath = "data/tasks.txt";


    public String initialize() {
        ui = new Ui();
        storage = new Storage(filePath);
        try {
            tasks = new TaskList(storage.load());
        } catch (DukeException e) {
            tasks = new TaskList();
            return ui.greet(true);
        }
        return ui.greet(false);
    }


    public String getResponse(String input) {
        try {
            Command c = Parser.parse(input);
            c.execute(tasks, ui, storage);
        } catch (DukeException e) {
            ui.addError(e.getMessage());
        } finally {
            return ui.flush();
        }
    }
}

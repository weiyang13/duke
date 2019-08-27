import duke.DukeException;
import duke.Storage;
import duke.TaskList;
import duke.Ui;

import duke.command.ListCommand;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;


public class ListCommandTest {
    @Test
    public void execute_emptyList_exceptionThrown() {
        TaskList tasks = new TaskList();
        Ui ui = new Ui();
        Storage storage = new Storage("data.txt");
        try {
            new ListCommand().execute(tasks, ui, storage);
            fail();
        } catch (DukeException e) {
            assertEquals("No tasks added.", e.getMessage());
        }
    }
}

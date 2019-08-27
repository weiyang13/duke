import duke.DukeException;
import duke.Storage;
import duke.TaskList;
import duke.Ui;

import duke.command.ListCommand;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

/**
 * Encapsulates the tests for the ListCommand class.
 */
public class ListCommandTest {
    /**
     * Executes a test for the execute method for when the list is empty.
     * Asserts if the correct exception is thrown.
     */
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

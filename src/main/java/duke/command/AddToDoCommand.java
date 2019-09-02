package duke.command;

import duke.DukeException;
import duke.task.Task;
import duke.task.ToDo;

/**
 * Encapsulates a command that adds a ToDo Task to the tasklist.
 */
public class AddToDoCommand extends AddTaskCommand {
    /**
     * Initializes an AddToDoCommand object.
     *
     * @param description Description of the ToDo to be created.
     */
    public AddToDoCommand(String description) {
        super(description);
    }

    @Override
    public Task createTask() throws DukeException {
        return new ToDo(description);
    }
}

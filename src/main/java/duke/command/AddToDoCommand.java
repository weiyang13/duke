package duke.command;

import duke.DukeException;
import duke.task.Task;
import duke.task.ToDo;

public class AddToDoCommand extends AddTaskCommand {
    public AddToDoCommand(String description) {
        super(description);
    }

    @Override
    public Task createTask() throws DukeException {
        return new ToDo(description);
    }
}

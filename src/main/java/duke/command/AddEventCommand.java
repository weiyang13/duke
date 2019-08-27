package duke.command;

import duke.DukeException;
import duke.task.Event;
import duke.task.Task;

public class AddEventCommand extends AddTaskCommand {
    private String dateString;

    public AddEventCommand(String description, String date) {
        super(description);
        dateString = date;
    }

    @Override
    public Task createTask() throws DukeException {
        return new Event(description, dateString);
    }
}

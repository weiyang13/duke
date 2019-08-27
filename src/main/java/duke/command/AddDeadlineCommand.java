package duke.command;

import duke.DukeException;
import duke.task.Deadline;
import duke.task.Task;

public class AddDeadlineCommand extends AddTaskCommand {
    private String dateString;

    public AddDeadlineCommand(String description, String date) {
        super(description);
        this.dateString = date;
    }

    @Override
    public Task createTask() throws DukeException {
        return new Deadline(description, dateString);
    }
}

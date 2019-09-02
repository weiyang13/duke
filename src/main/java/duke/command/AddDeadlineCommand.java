package duke.command;

import duke.DukeException;
import duke.task.Deadline;
import duke.task.Task;

/**
 * Encapsulates a command that adds a Deadline Task to the tasklist.
 */
public class AddDeadlineCommand extends AddTaskCommand {
    /** String containing date and time of Event to be created. */
    private String dateString;

    /**
     * Initializes an AddDeadlineCommand object.
     *
     * @param description Description of the Deadline to be created.
     * @param date String containing date and time of Deadline to be created.
     */
    public AddDeadlineCommand(String description, String date) {
        super(description);
        this.dateString = date;
    }

    @Override
    public Task createTask() throws DukeException {
        return new Deadline(description, dateString);
    }
}

package duke.command;

import duke.DukeException;
import duke.task.Event;
import duke.task.Task;

/**
 * Encapsulates a command that adds an Event Task to the tasklist.
 */
public class AddEventCommand extends AddTaskCommand {
    /** String containing date and time of Event to be created. */
    private String dateString;

    /**
     * Initializes an AddEventCommand object.
     *
     * @param description Description of the Event to be created.
     * @param date String containing date and time of Event to be created.
     */
    public AddEventCommand(String description, String date) {
        super(description);
        dateString = date;
    }

    /**
     * (@inheritDoc)
     */
    @Override
    public Task createTask() throws DukeException {
        return new Event(description, dateString);
    }
}

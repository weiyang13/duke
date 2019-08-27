package duke.task;

import duke.DukeException;

import java.text.ParseException;
import java.util.Date;

/**
 * Encapsulates an event Task.
 */
public class Event extends DatedTask {
    /**
     * Initializes an Event object.
     *
     * @param description Description of task.
     * @param at Date and time the event occurs at.
     * @throws DukeException If date and time format of at is wrong.
     */
    public Event (String description, String at) throws DukeException {
        super(description, at);
        taskType = TaskType.EVENT;
    }

    /**
     * (@inheritDoc)
     */
    @Override
    public String toString() {
        return super.toString() + " (at: " + dateFormat.format(date) + ")";
    }
}

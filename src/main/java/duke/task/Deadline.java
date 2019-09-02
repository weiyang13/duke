package duke.task;

import duke.DukeException;

import java.text.ParseException;
import java.util.Date;

/**
 * Encapsulates a Task with a deadline.
 */

public class Deadline extends DatedTask {
    /**
     * Initializes a Deadline object.
     *
     * @param description Description of task.
     * @param by Due date and time of task.
     * @throws DukeException If date and time format of by is incorrect.
     */
    public Deadline(String description, String by) throws DukeException {
        super(description, by);
        taskType = TaskType.DEADLINE;
    }

    @Override
    public String toString() {
        return super.toString() + " (by: " + dateFormat.format(date) + ")";
    }
}

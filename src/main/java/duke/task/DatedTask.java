package duke.task;

import duke.DukeException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Encapsulates a Task that is associated with a date.
 */
public abstract class DatedTask extends Task {
    /** Date associated with the task */
    protected Date date;
    /** Format of date and time for input and output (dd/MM/yyyy HHmm). */
    protected static SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HHmm");

    /**
     * Intializes a DatedTask object.
     *
     * @param description Description of task.
     * @param date Date associated with task.
     * @throws DukeException If date does not follow format.
     */
    public DatedTask(String description, String date) throws DukeException {
        super(description);
        hasDate = true;
        try {
            this.date = dateFormat.parse(date);
        } catch (ParseException e) {
            throw new DukeException("Date must be of format dd/MM/yyyy HHmm.");
        }
    }

    /**
     * (@inheritDoc)
     */
    @Override
    public String getDate() {
        return dateFormat.format(date);
    }
}

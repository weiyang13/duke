package duke.task;

import duke.DukeException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Encapsulates a Task that is associated with a date.
 */
public abstract class DatedTask extends Task {
    /** Date associated with the task. */
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

    @Override
    public String getDate() {
        return dateFormat.format(date);
    }

    /**
     * Comparator for tasks. Compatible with tasks with no dates.
     * Tasks that are done have lowest priority (greatest).
     * Then, tasks that do not have dates have lower priority.
     * Among dated tasks of same priority so far, Date comparison is used.
     * Then, priority is based on String comparison of description.
     *
     * @param other Task to be compared to.
     * @return A negative integer if the task has greater priority, a positive integer otherwise.
     */
    @Override
    public int compareTo(Task other) {
        if (other.isDone && !this.isDone) {
            return 1;
        } else if (!other.isDone && this.isDone) {
            return -1;
        } else if (!other.hasDate) {
            return -1;
        } else if (this.date.compareTo(((DatedTask) other).date) != 0) {
            return this.date.compareTo(((DatedTask) other).date);
        } else {
            return this.description.compareTo(other.description);
        }
    }
}

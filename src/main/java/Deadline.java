import java.text.ParseException;
import java.util.Date;

class Deadline extends DatedTask {
    public Deadline (String description, String by) throws DukeException {
        super(description, by);
        taskType = TaskType.DEADLINE;
    }

    @Override
    public String toString() {
        return super.toString() + " (by: " + dateFormat.format(by) + ")";
    }
}

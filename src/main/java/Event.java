import java.text.ParseException;
import java.util.Date;

class Event extends DatedTask {
    public Event (String description, String at) throws DukeException {
        super(description, at);
        taskType = TaskType.EVENT;
    }

    @Override
    public String toString() {
        return super.toString() + " (at: " + dateFormat.format(date) + ")";
    }
}

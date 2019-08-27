import java.text.ParseException;
import java.util.Date;

class Event extends Task {
    protected Date at;

    public Event (String description, String at) throws DukeException {
        super(description);
        try {
            this.at = dateFormat.parse(at);
        } catch (ParseException e) {
            throw new DukeException("Date must be of format dd/MM/yyyy HHmm");
        }
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + " (at: " + dateFormat.format(at) + ")";
    }
}

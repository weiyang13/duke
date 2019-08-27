import java.text.ParseException;
import java.util.Date;

class Deadline extends Task {
    protected Date by;

    public Deadline (String description, String by) throws DukeException {
        super(description);
        try {
            this.by = dateFormat.parse(by);
        } catch (ParseException e) {
            throw new DukeException("Date must be of format dd/MM/yyyy HHmm");
        }
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + dateFormat.format(by) + ")";
    }
}

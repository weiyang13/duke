import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class DatedTask extends Task {
    protected Date date;
    protected static SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HHmm");

    public DatedTask(String description, String date) throws DukeException {
        super(description);
        hasDate = true;
        try {
            this.date = dateFormat.parse(date);
        } catch (ParseException e) {
            throw new DukeException("Date must be of format dd/MM/yyyy HHmm");
        }
    }

    @Override
    public String getDate() {
        return dateFormat.format(by);
    }
}

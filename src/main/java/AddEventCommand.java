public class AddEventCommand extends AddTaskCommand {
    private String dateString;

    public AddEventCommand(String description, String date) {
        super(description);
        dateString = date;
    }

    @Override
    public Task createTask() throws DukeException {
        return new Event(description, dateString);
    }
}

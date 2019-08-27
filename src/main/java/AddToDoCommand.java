public class AddToDoCommand extends AddTaskCommand {
    public AddToDoCommand(String description) {
        super(description);
    }

    @Override
    public Task createTask() throws DukeException {
        return new ToDo(description);
    }
}

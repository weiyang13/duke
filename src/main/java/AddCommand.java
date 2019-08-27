public abstract class AddTaskCommand extends Command {
    protected String description;

    public AddTaskCommand(String description) {
        this.description = description;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        Task task = createTask();
        tasks.add(task);

        ui.printLine("Got it. I've added this task:");
        ui.printLine("  " + task);
        ui.printLine("Now you have " + tasks.size() + " in the list.");

        storage.save(tasks);
    }

    public abstract Task createTask() throws DukeException;
}

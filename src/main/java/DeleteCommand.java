public class DeleteCommand extends Command {
    private int taskNumber;

    public DeleteCommand(int taskNumber) throws DukeException {
        if (taskNumber < 1) {
            throw new DukeException("Task number must be positive.");
        }
        this.taskNumber = taskNumber;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        if (taskNumber > tasks.getNumTasks()) {
            throw new DukeException("You have less than " + taskNumber " tasks.");
        }

        Task task = tasks.getTask(itemNo - 1);
        tasks.deleteTask(itemNo - 1);

        ui.printLine("Noted. I've removed this task:");
        ui.printLine("  " + task);
        ui.printLine("Now you have " + tasks.size() + " tasks in the list.");

        storage.save(tasks);
    }
}

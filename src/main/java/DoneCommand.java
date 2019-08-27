public class DoneCommand extends Command {
    private int taskNumber;

    public DoneCommand(int taskNumber) {
        this.taskNumber = taskNumber;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        Task task = tasks.getTask(taskNumber);
        if (task.getIsDone()) {
            throw new DukeException("Task " + taskNumber + " is already done.");
        } else {
            task.setIsDone(true);

            ui.printLine("Nice! I've marked this task as done:");
            ui.printLine("  " + task);

            storage.save(tasks);
        }
    }
}

public class ListCommand extends Command {
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        int numTasks = tasks.getNumTasks();
        for (int i = 1; i <= numTasks; i++) {
            Task task = tasks.getTask(i);
            ui.printLine(i + "." + task);
        }

        if (numTasks == 0) {
            throw new DukeException("No tasks added.");
        }
    }
}

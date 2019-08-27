package duke.command;

import duke.DukeException;
import duke.Storage;
import duke.TaskList;
import duke.Ui;
import duke.task.Task;

/**
 * Encapsulates a command that lists all tasks in the list.
 */
public class ListCommand extends Command {
    /**
     * Executes the command to list all tasks.
     * Prints all tasks in storage order to the user.
     *
     * @param tasks List of tasks kept tracked of by Duke.
     * @param ui Unit that manages user interface of Duke.
     * @param storage Unit that manages saved data of Duke.
     * @throws DukeException If list of tasks is empty.
     */
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

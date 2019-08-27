package duke.command;

import duke.DukeException;
import duke.Storage;
import duke.TaskList;
import duke.Ui;
import duke.task.Task;

/**
 * Encapsulates a command that deletes a task from the list of tasks.
 */
public class DeleteCommand extends Command {
    /** Index of task to be deleted. */
    private int taskNumber;

    /**
     * Initializes a DeleteCommand object.
     *
     * @param taskNumber Index of task to be deleted.
     * @throws DukeException If taskNumber is non-positive.
     */
    public DeleteCommand(int taskNumber) throws DukeException {
        if (taskNumber < 1) {
            throw new DukeException("Task number must be positive.");
        }
        this.taskNumber = taskNumber;
    }

    /**
     * Executes a command to delete a task.
     * Deletes a task from the list of tasks.
     * Prints a message to the user indicating successful task deletion.
     * Saves the updated list through Storage.
     *
     * @param tasks List of tasks kept tracked of by Duke.
     * @param ui Unit that manages user interface of Duke.
     * @param storage Unit that manages saved data of Duke.
     * @throws DukeException If taskNumber is larger than number of tasks.
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        if (taskNumber > tasks.getNumTasks()) {
            throw new DukeException("You have less than " + taskNumber + " tasks.");
        }

        Task task = tasks.getTask(taskNumber);
        tasks.deleteTask(taskNumber);

        ui.printLine("Noted. I've removed this task:");
        ui.printLine("  " + task);
        ui.printLine("Now you have " + tasks.getNumTasks() + " tasks in the list.");

        storage.save(tasks);
    }
}

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
        checkValidTaskNumber(tasks, ui);
        deleteTask(tasks, ui);
        storage.save(tasks);
    }

    /**
     * Throws an exception if the task number is invalid.
     *
     * @param tasks List of tasks kept tracked of by Duke.
     * @param ui Unit that manages user interface of Duke.
     * @throws DukeException If task number is greater than number of tasks.
     */
    private void checkValidTaskNumber(TaskList tasks, Ui ui) throws DukeException {
        if (taskNumber > tasks.getNumTasks()) {
            throw new DukeException("You have less than " + taskNumber + " tasks.");
        }
    }

    /**
     * Deletes specified task and prints a message.
     *
     * @param tasks List of tasks kept tracked of by Duke.
     * @param ui Unit that manages user interface of Duke.
     */
    private void deleteTask(TaskList tasks, Ui ui) {
        Task task = tasks.getTask(taskNumber);
        tasks.deleteTask(taskNumber);
        assert tasks.getTask(taskNumber) != task : "Exact instance of task object should have been removed.";
        printMessage(tasks, ui, task);
    }

    /**
     * Prints a message indicating successful task deletion.
     *
     * @param tasks List of tasks kept tracked of by Duke.
     * @param ui Unit that manages user interface of Duke.
     * @param task Task to be deleted.
     */
    private void printMessage(TaskList tasks, Ui ui, Task task) {
        ui.printLine("Noted. I've removed this task:");
        ui.printLine("  " + task);
        ui.printLine("Now you have " + tasks.getNumTasks() + " task(s) in the list.");
    }
}

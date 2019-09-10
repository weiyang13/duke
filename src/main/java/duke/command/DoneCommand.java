package duke.command;

import duke.DukeException;
import duke.Storage;
import duke.TaskList;
import duke.Ui;
import duke.task.Task;

/**
 * Encapsulates a command that sets a task as done.
 */
public class DoneCommand extends Command {
    /** Index of task to be set as done. */
    private int taskNumber;

    /**
     * Intializes a DoneCommand object.
     *
     * @param taskNumber Index of task to be set as done.
     * @throws DukeException If taskNumber is non-positive.
     */
    public DoneCommand(int taskNumber) throws DukeException {
        if (taskNumber < 1) {
            throw new DukeException("Task number must be positive.");
        }

        this.taskNumber = taskNumber;
    }

    /**
     * Executes a command to set a task as done.
     * Sets a task from the list of tasks as done.
     * Prints a message to the user indicating successful command.
     * Saves the updated list through Storage.
     *
     * @param tasks List of tasks kept tracked of by Duke.
     * @param ui Unit that manages user interface of Duke.
     * @param storage Unit that manages saved data of Duke.
     * @throws DukeException If taskNumber is larger than number of tasks or task is already done.
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        if (taskNumber > tasks.getNumTasks()) {
            throw new DukeException("You have less than " + taskNumber + " tasks.");
        }

        Task task = tasks.getTask(taskNumber);
        if (task.getIsDone()) {
            throw new DukeException("Task " + taskNumber + " is already done.");
        } else {
            task.setIsDone(true);

            ui.printLine("Nice! I've marked this task as done:");
            ui.printLine("  " + task);

            storage.save(tasks);
        }
        assert task.getIsDone() : "Task should now be marked as done";
    }
}

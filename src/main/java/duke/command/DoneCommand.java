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
        checkValidTaskNumber(tasks, ui);
        checkTaskNotDone(tasks, ui);
        setTaskAsDone(tasks, ui);
        tasks.sortTasks();
        storage.save(tasks);
    }

    /**
     * Throws an exception if taskNumber is not valid.
     *
     * @param tasks List of tasks kept tracked of by Duke.
     * @param ui Unit that manages user interface of Duke.
     * @throws DukeException If taskNumber is larger than number of tasks.
     */
    private void checkValidTaskNumber(TaskList tasks, Ui ui) throws DukeException {
        if (taskNumber > tasks.getNumTasks()) {
            throw new DukeException("You have less than " + taskNumber + " tasks.");
        }
    }

    /**
     * Throws an exception if the task to be set as done is already done.
     *
     * @param tasks List of tasks kept tracked of by Duke.
     * @param ui Unit that manages user interface of Duke.
     * @throws DukeException If task is already done.
     */
    private void checkTaskNotDone(TaskList tasks, Ui ui) throws DukeException {
        Task task = tasks.getTask(taskNumber);
        if (task.getIsDone()) {
            throw new DukeException("Task " + taskNumber + " is already done.");
        }
    }

    /**
     * Sets the task as done.
     *
     * @param tasks List of tasks kept tracked of by Duke.
     * @param ui Unit that manages user interface of Duke.
     */
    private void setTaskAsDone(TaskList tasks, Ui ui) {
        Task task = tasks.getTask(taskNumber);
        task.setIsDone(true);
        printMessage(ui, task);
        assert task.getIsDone() : "Task should now be marked as done";
    }

    /**
     * Prints a message indicating that task is successfully marked as done.
     *
     * @param ui Unit that manages user interface of Duke.
     * @param task Task to be set as done.
     */
    private void printMessage(Ui ui, Task task) {
        ui.printLine("Nice! I've marked this task as done:");
        ui.printLine("  " + task);
    }

}

package duke.command;

import duke.DukeException;
import duke.Storage;
import duke.TaskList;
import duke.Ui;
import duke.task.Task;

/**
 * Encapsulates a command that adds a task to the list.
 */
public abstract class AddTaskCommand extends Command {
    /** Description of the task to be added. */
    protected String description;

    /**
     * Initializes an AddTaskCommand object.
     *
     * @param description Description of task to be added.
     */
    public AddTaskCommand(String description) {
        this.description = description;
    }

    /**
     * Executes the command to add a task.
     * Creates a task and adds it to the list of tasks.
     * Prints a message to the user indicating successful addition.
     * Saves the updated list through storage.
     *
     * @param tasks List of tasks kept tracked of by Duke.
     * @param ui Unit that manages user interface of Duke.
     * @param storage Unit that manages saved data of Duke.
     * @throws DukeException If error occurs in creating the task.
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        Task task = createTask();
        tasks.addTask(task);

        ui.printLine("Got it. I've added this task:");
        ui.printLine("  " + task);
        ui.printLine("Now you have " + tasks.getNumTasks() + " in the list.");

        storage.save(tasks);
    }

    /**
     * Returns the task to be created by the command.
     *
     * @return Task created by the command.
     * @throws DukeException If date associated with command is of wrong format.
     */
    public abstract Task createTask() throws DukeException;
}

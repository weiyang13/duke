package duke.command;

import duke.DukeException;
import duke.Storage;
import duke.TaskList;
import duke.Ui;
import duke.task.Task;

/**
 * Encapsulates a command that finds tasks containing a keyword.
 */
public class FindCommand extends Command {
    /** Keyword to be searched for. */
    private String keyword;
    private int taskCount;

    /**
     * Initializes a FindCommand object.
     *
     * @param keyword Keyword to be searched for.
     */
    public FindCommand(String keyword) {
        this.keyword = keyword;
        this.taskCount = 0;
    }

    /**
     * Executes a command to find commands with a keyword.
     * Searches list of tasks to find commands with keyword.
     * Prints a message to the user indicating successful search, and list of tasks found.
     *
     * @param tasks List of tasks kept tracked of by Duke.
     * @param ui Unit that manages user interface of Duke.
     * @param storage Unit that manages saved data of Duke.
     * @throws DukeException If there are no tasks, are no matching tasks tracked by Duke.
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        checkForEmptyTaskList(tasks, ui);
        searchTaskList(tasks, ui);
        checkIfNoTasksFound(ui);
    }

    /**
     * Throws an exception if there are no tasks in the TaskList.
     *
     * @param tasks List of tasks kept tracked of by Duke.
     * @param ui Unit that manages user interface of Duke.
     * @throws DukeException If there are no tasks
     */
    private void checkForEmptyTaskList(TaskList tasks, Ui ui) throws DukeException {
        if (tasks.getNumTasks() == 0) {
            throw new DukeException("There are no tasks in the list.");
        }
    }

    /**
     * Searches the tasklist for tasks that match the keyword and prints the task.
     *
     * @param tasks List of tasks kept tracked of by Duke.
     * @param ui Unit that manages user interface of Duke.
     */
    private void searchTaskList(TaskList tasks, Ui ui) {
        for (int i = 1; i <= tasks.getNumTasks(); i++) {
            Task task = tasks.getTask(i);
            printIfMatch(task, ui);
        }
    }

    /**
     * Prints a task if it has a keyword. Also prints a message for the first task found.
     *
     * @param task Task to be checked
     * @param ui Unit that manages user interface of Duke.
     */
    private void printIfMatch(Task task, Ui ui) {
        if (task.containsKeyword(keyword)) {
            printFirstLine(ui);
            ui.printLine(taskCount +  "." + task);
            taskCount++;
        }
    }

    /**
     * Prints a message indicating there are matching task(s).
     *
     * @param ui Unit that manages user interface of Duke.
     */
    private void printFirstLine(Ui ui) {
        if (taskCount == 0) {
            ui.printLine("Here are the matching tasks in your list:");
        }
    }

    /**
     * Throws an exception if no tasks are found.
     *
     * @param ui Unit that manages user interface of Duke.
     * @throws DukeException If no tasks are found.
     */
    private void checkIfNoTasksFound(Ui ui) throws DukeException {
        if (taskCount == 0) {
            throw new DukeException("No task with keyword '" + keyword + "' found.");
        }
    }
}

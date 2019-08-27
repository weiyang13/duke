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

    /**
     * Initializes a FindCommand object.
     *
     * @param keyword Keyword to be searched for.
     */
    public FindCommand(String keyword) {
        this.keyword = keyword;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        int numTasks = tasks.getNumTasks();
        int taskCount = 0;

        if (numTasks == 0) {
            throw new DukeException("There are no tasks in the list.");
        }

        for (int i = 1; i <= numTasks; i++) {
            Task task = tasks.getTask(i);
            if (task.containsKeyword(keyword)) {
                taskCount++;
                if (taskCount == 1) {
                    ui.printLine("Here are the matching tasks in your list:");
                }
                ui.printLine(taskCount +  "." + task);
            }
        }

        if (taskCount == 0) {
            throw new DukeException("No task with keyword '" + keyword + "' found.");
        }
    }
}

package duke.command;

import duke.Storage;
import duke.TaskList;
import duke.Ui;

/**
 * Encapsulates a command that exits the chatbot.
 */
public class ExitCommand extends Command {
    /**
     * Prints an exit message to the user.
     *
     * @param tasks List of tasks kept tracked of by Duke.
     * @param ui Unit that manages user interface of Duke.
     * @param storage Unit that manages saved data of Duke.
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        ui.printLine("Bye. Hope to see you again soon!");
    }

    /**
     * (@inheritDoc)
     */
    @Override
    public boolean isExit() {
        return true;
    }
}

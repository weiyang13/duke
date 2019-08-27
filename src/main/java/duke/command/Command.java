package duke.command;

import duke.DukeException;
import duke.Storage;
import duke.TaskList;
import duke.Ui;

/**
 * Encapsulates a command to be executed.
 */
public abstract class Command {
    /**
     * Executes the command.
     *
     * @param tasks List of tasks kept tracked of by Duke.
     * @param ui Unit that manages user interface of Duke.
     * @param storage Unit that manages saved data of Duke.
     * @throws DukeException If unexpected behavior or input is encountered during execution.
     */
    public abstract void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException;

    /**
     * Returns whether a command is an ExitCommand.
     *
     * @return False for non-exit commands, true for exit commands.
     */
    public boolean isExit() {
        return false;
    }
}

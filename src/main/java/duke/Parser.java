package duke;

import duke.command.AddDeadlineCommand;
import duke.command.AddEventCommand;
import duke.command.AddToDoCommand;
import duke.command.Command;
import duke.command.DeleteCommand;
import duke.command.DoneCommand;
import duke.command.ExitCommand;
import duke.command.FindCommand;
import duke.command.ListCommand;

public class Parser {
    public static Command parse(String fullCommand) throws DukeException {
        String[] commandTokens = fullCommand.split(" ");
        if (fullCommand.equals("bye")) {
            return new ExitCommand();
        } else if (fullCommand.equals("list")) {
            return new ListCommand();
        } else {
            switch (commandTokens[0]) {
            case "done":
                return parseDone(commandTokens);
            case "delete":
                return parseDelete(commandTokens);
            case "find":
                return parseFind(commandTokens);
            case "todo":
                return parseToDo(commandTokens);
            case "deadline":
                return parseDeadline(commandTokens);
            case "event":
                return parseEvent(commandTokens);
            default:
                throw new DukeException("Unrecognised command.");
            }
        }
    }

    public static Command parseFind(String[] commandTokens) throws DukeException {
        if (commandTokens.length != 2) {
            throw new DukeException("'done' command must be followed by a single keyword.");
        }

        return new FindCommand(commandTokens[1]);
    }

    public static Command parseDone(String[] commandTokens) throws DukeException {
        if (commandTokens.length != 2) {
            throw new DukeException("'done' command must be followed by an integer.");
        }
        try {
            int itemNo = Integer.parseInt(commandTokens[1]);
            return new DoneCommand(itemNo);
        } catch (NumberFormatException e) {
            throw new DukeException("'done' must be followed by an integer.");
        }
    }

    public static Command parseDelete(String[] commandTokens) throws DukeException {
        if (commandTokens.length != 2) {
            throw new DukeException("'delete' command must be followed by an integer.");
        }
        try {
            int itemNo = Integer.parseInt(commandTokens[1]);
            return new DeleteCommand(itemNo);
        } catch (NumberFormatException e) {
            throw new DukeException("'delete' must be followed by an integer.");
        }
    }

    public static Command parseDeadline(String[] commandTokens) throws DukeException {
        if (commandTokens.length == 1 || commandTokens[1].equals("/by")) {
            throw new DukeException("Description for deadline must not be empty.");
        }

        String description = "";
        int i;
        for (i = 1; i < commandTokens.length; i++) {
            if (commandTokens[i].equals("/by")) {
                break;
            }
            description += commandTokens[i] + " ";
        }
        description = description.substring(0, description.length() - 1);

        if (i == commandTokens.length) {
            throw new DukeException("Indicate date/time for deadline with '/by'.");
        } else if (commandTokens.length != i + 3) {
            throw new DukeException("Date must be of format dd/MM/yyyy HHmm.");
        }
        String by = commandTokens[i + 1] + " " + commandTokens[i + 2];

        return new AddDeadlineCommand(description, by);
    }

    public static Command parseEvent(String[] commandTokens) throws DukeException {
        if (commandTokens.length == 1 || commandTokens[1].equals("/at")) {
            throw new DukeException("Description for deadline must not be empty.");
        }

        String description = "";
        int i;
        for (i = 1; i < commandTokens.length; i++) {
            if (commandTokens[i].equals("/at")) {
                break;
            }
            description += commandTokens[i] + " ";
        }
        description = description.substring(0, description.length() - 1);

        if (i == commandTokens.length) {
            throw new DukeException("Indicate date/time for event with '/at'.");
        } else if (commandTokens.length != i + 3) {
            throw new DukeException("Date must be of format dd/MM/yyyy HHmm.");
        }
        String at = commandTokens[i + 1] + " " + commandTokens[i + 2];

        return new AddEventCommand(description, at);
    }

    public static Command parseToDo(String[] commandTokens) throws DukeException {
        if (commandTokens.length == 1) {
            throw new DukeException("Description for todo must not be empty.");
        }

        String description = "";
        for (int i = 1; i < commandTokens.length; i++) {
            description += commandTokens[i] + " ";
        }
        description = description.substring(0, description.length() - 1);
        return new AddToDoCommand(description);
    }
}

public class Parser {
    public static Command parse(String fullCommand) throws DukeException {
        String command = input.nextLine();
        String[] commandTokens = command.split(" ");
        if (command.equals("bye")) {
            return new ExitCommand();
        } else if (command.equals("list")) {
            return new ListCommand();
        } else {
            switch (commandTokens[0]) {
            case "done":
                if (commandTokens.length != 2) {
                    throw new DukeException("'done' command must be followed by an integer.")
                }
                try {
                    int itemNo = Integer.parseInt(commandTokens[1]);
                    return new DoneCommand(itemNo);
                } catch (NumberFormatException e) {
                    throw new DukeException("'done' must be followed by an integer.");
                }
                break;
            case "delete":
                if (commandTokens.length != 2) {
                    throw new DukeException("'delete' command must be followed by an integer.")
                }
                try {
                    int itemNo = Integer.parseInt(commandTokens[1]);
                    return new DeleteCommand(itemNo);
                } catch (NumberFormatException e) {
                    throw new DukeException("'delete' must be followed by an integer.");
                }
                break;
            case "todo":
                addToDo(commandTokens);
                save();
                break;
            case "deadline":
                addDeadline(commandTokens);
                save();
                break;
            case "event":
                addEvent(commandTokens);
                save();
                break;
            default:
                throw new DukeException("OOPS!! Sorry, I do not know what that means :(");
            }
        }
    }
}

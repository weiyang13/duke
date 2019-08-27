package duke.task;

/**
 * Encapsulates the concrete type of a Task.
 */
public enum TaskType {
    /** TaskType for ToDo Tasks. */
    TO_DO('T'),
    /** TaskType for Deadline Tasks. */
    DEADLINE('D'),
    /** TaskType for Event Tasks. */
    EVENT('E');

    /** Symbol associated with a particular TaskType */
    private char typeSymbol;

    /**
     * Constructor for TaskType objects
     *
     * @param typeSymbol Symbol associated with the TaskType.
     */
    TaskType(char typeSymbol) {
        this.typeSymbol = typeSymbol;
    }

    @Override
    public String toString() {
        return "[" + typeSymbol + "]";
    }
}
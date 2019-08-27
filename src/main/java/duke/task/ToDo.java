package duke.task;

/**
 * Encapsulates a Task to be done.
 */
public class ToDo extends Task {
    /**
     * Initializes a ToDo object.
     *
     * @param description Description of the task.
     */
    public ToDo (String description) {
        super(description);
        this.taskType = TaskType.TO_DO;
    }
}

package duke.task;

import java.text.SimpleDateFormat;

/**
 * Encapsulates a task that is kept tracked of by Duke.
 */

public abstract class Task {
    /** Description of the task. */
    protected String description;
    /** Whether a task is complete or not.*/
    protected boolean isDone;
    /** Whether a task is associated with a date. */
    protected boolean hasDate;
    /** The type of the task. */
    protected TaskType taskType;

    /**
     * Initializes a Task object.
     *
     * @param description Description of the task.
     */
    public Task(String description) {
        this.description = description;
        isDone = false;
        hasDate = false;
    }

    /**
     * Returns whether the task is associated with a date.
     *
     * @return True if task is associated with a date, false otherwise.
     */
    public boolean getHasDate() { return hasDate; }

    /**
     * Returns whether the task is done.
     *
     * @return True if task is done, false otherwise.
     */
    public boolean getIsDone() {
        return isDone;
    }

    /**
     * Sets whether the task is done.
     *
     * @param isDone Boolean variable for whether a task is done.
     */
    public void setIsDone(boolean isDone) {
        this.isDone = isDone;
    }

    /**
     * Returns description of task.
     *
     * @return Description of task.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Returns date associated with task.
     *
     * @return String representing date associated with task.
     */
    public String getDate() {
        return "";
    }

    /**
     * Returns status icon representing whether the task is done.
     *
     * @return Status icon representing whether the task is done.
     */
    public String getStatusIcon() {
        if (isDone) {
            return "+";
        } else {
            return "-";
        }
    }

    /**
     * Returns the type of the task.
     *
     * @return TaskType object representing type of the task.
     */
    public TaskType getTaskType() {
        return taskType;
    }

    @Override
    public String toString() {
        return taskType + "[" + getStatusIcon() + "] " + description;
    }
}
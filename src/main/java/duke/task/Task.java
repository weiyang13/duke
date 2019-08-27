package duke.task;

import java.text.SimpleDateFormat;

public abstract class Task {
    protected String description;
    protected boolean isDone;
    protected boolean hasDate;
    protected TaskType taskType;


    public Task(String description) {
        this.description = description;
        isDone = false;
        hasDate = false;
    }

    public boolean getHasDate() { return hasDate; }

    public boolean getIsDone() {
        return isDone;
    }

    public void setIsDone(boolean isDone) {
        this.isDone = isDone;
    }

    public String getDescription() {
        return description;
    }

    public String getDate() {
        return "";
    }

    public String getStatusIcon() {
        if (isDone) {
            return "+";
        } else {
            return "-";
        }
    }

    public TaskType getTaskType() {
        return taskType;
    }

    /**
     * Returns true if description of task contains a keyword.
     *
     * @param keyword Keyword to be searched.
     * @return True if description of task contains keyword, false otherwise.
     */
    public boolean containsKeyword(String keyword) {
        String[] tokens = description.split(" ");
        for (String token : tokens) {
            if (token.equals(keyword)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return taskType + "[" + getStatusIcon() + "] " + description;
    }
}
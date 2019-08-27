package duke.task;

public class ToDo extends Task {
    public ToDo (String description) {
        super(description);
        this.taskType = TaskType.TO_DO;
    }
}

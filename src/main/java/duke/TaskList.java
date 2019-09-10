package duke;

import duke.task.Task;

import java.util.ArrayList;

/**
 * Encapsulates unit that manages list of tasks tracked by Duke.
 */
public class TaskList {
    /** List of tasks tracked by Duke. */
    private ArrayList<Task> tasks;

    /**
     * Initializes TaskList object.
     */
    public TaskList() {
        tasks = new ArrayList<>();
    }

    /**
     * Initializes TaskList object from a loaded list of tasks.
     * To be used only when loading from saved data.
     *
     * @param tasks List of tasks loaded from memory
     */
    public TaskList(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    /**
     * Adds a task to the list of tasks.
     *
     * @param task Task to be added.
     */
    public void addTask(Task task) {
        tasks.add(task);
    }

    /**
     * Deletes a task (based on index) from list of tasks.
     *
     * @param taskNumber Index of task to be deleted.
     */
    public void deleteTask(int taskNumber) {
        assert taskNumber <= getNumTasks() && taskNumber > 0 : "Task number should be valid";
        tasks.remove(taskNumber - 1);
    }

    /**
     * Retrieves a task (based on index) from list of tasks.
     *
     * @param taskNumber Index of task to be retrieved.
     * @return Task retrieved with corresponding index.
     */
    public Task getTask(int taskNumber) {
        assert taskNumber <= getNumTasks() && taskNumber > 0 : "Task number should be valid";
        return tasks.get(taskNumber - 1);
    }

    /**
     * Returns the number of tasks in the list.
     *
     * @return Number of tasks in the list.
     */
    public int getNumTasks() {
        return tasks.size();
    }
}

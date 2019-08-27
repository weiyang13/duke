import java.util.ArrayList;

public class TaskList {
    private ArrayList<Task> tasks;

    public TaskList() {
        tasks = new ArrayList<>();
    }

    public TaskList(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public void deleteTask(int taskNumber) {
        tasks.remove(taskNumber - 1);
    }

    public Task getTask(int taskNumber) {
        return tasks.get(taskNumber - 1);
    }

    public int getNumTasks() {
        return tasks.size();
    }
}

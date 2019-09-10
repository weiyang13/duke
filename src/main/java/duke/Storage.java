package duke;

import duke.task.Deadline;
import duke.task.Event;
import duke.task.Task;
import duke.task.ToDo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Encapsulates the unit that manages storage of data of the task list managed by Duke.
 */

public class Storage {
    /** File to which data of the list of tasks is saved and loaded from. */
    private File file;
    /** Object used to read save file. */
    private Scanner fileReader;

    /**
     * Initializes a storage object.
     *
     * @param filePath Pathname of the file used for storing data.
     */
    public Storage(String filePath) {
        file = new File(filePath);
    }

    /**
     * Loads data from file into an ArrayList containing tasks.
     *
     * @return An ArrayList of tasks represented by data in the file.
     * @throws DukeException If error in loading occurs.
     */
    public ArrayList<Task> load() throws DukeException {
        ArrayList<Task> tasks = new ArrayList<>();
        initialize();
        while (fileReader.hasNextLine()) {
            addTaskToTaskList(tasks);
        }
        fileReader.close();
        return tasks;
    }

    /**
     * Add a task from the save file to the list of tasks loaded.
     *
     * @param tasks List of tasks kept tracked of by Duke.
     * @throws DukeException If there is error in loading the file.
     */
    private void addTaskToTaskList(ArrayList<Task> tasks) throws DukeException {
        String[] taskTokens = fileReader
                    .nextLine()
                    .split("::");
        Task task = createTask(taskTokens);
        if (taskTokens[1].equals("1")) {
            task.setIsDone(true);
        }
        tasks.add(task);
    }

    /**
     * Creates a task based on tokens from the loaded file.
     *
     * @param taskTokens Array of String tokens in loaded file.
     * @return Undone task represented by tokens.
     * @throws DukeException If there is an error in the data loaded from the file.
     */
    private Task createTask(String[] taskTokens) throws DukeException {
        switch (taskTokens[0]) {
        case "[T]":
            return new ToDo(taskTokens[2]);
        case "[D]":
            return new Deadline(taskTokens[2], taskTokens[3]);
        case "[E]":
            return new Event(taskTokens[2], taskTokens[3]);
        default :
            throw new DukeException("");
        }
    }


    /**
     * Creates Scanner to read the file to be loaded.
     *
     * @throws DukeException If file is not found, or there is error in creating the file.
     */
    private void initialize() throws DukeException {
        try {
            fileReader = new Scanner(file);
        } catch (FileNotFoundException e) {
            try {
                file.createNewFile();
                throw new DukeException("");
            } catch (IOException ex) {
                throw new DukeException("");
            }
        }
    }

    /**
     * Saves data managed by taskList into the file.
     *
     * @param taskList TaskList object managing list of tasks.
     * @throws DukeException If there is an error in saving.
     */
    public void save(TaskList taskList) throws DukeException {
        try {
            FileWriter fileWriter = new FileWriter(file);
            for (int i = 1; i <= taskList.getNumTasks(); i++) {
                Task task = taskList.getTask(i);
                writeTask(task, fileWriter);
            }
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            throw new DukeException(e.getMessage());
        }

    }

    /**
     * Saves data of a single task into the file.
     *
     * @param task Task to be recorded in target file.
     * @param fileWriter FileWriter object for target file.
     * @throws IOException If there is error in writing to file.
     */
    private void writeTask(Task task, FileWriter fileWriter) throws IOException {
        fileWriter.write(task.getTaskType().toString());
        fileWriter.write("::");
        if (task.getIsDone()) {
            fileWriter.write("1::");
        } else {
            fileWriter.write("0::");
        }
        fileWriter.write(task.getDescription());
        if (task.getHasDate()) {
            fileWriter.write("::");
            fileWriter.write(task.getDate());
        }
        fileWriter.write("\n");
    }
}

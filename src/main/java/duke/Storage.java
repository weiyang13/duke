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
        try {
            Scanner fileReader = new Scanner(file);
            while (fileReader.hasNextLine()) {
                String taskLine = fileReader.nextLine();
                String[] taskTokens = taskLine.split("::");

                switch (taskTokens[0]) {
                case "[T]":
                    Task task = new ToDo(taskTokens[2]);
                    if (taskTokens[1].equals("1")) {
                        task.setIsDone(true);
                    }
                    tasks.add(task);
                    break;
                case "[D]":
                    Task task = new Deadline(taskTokens[2], taskTokens[3]);
                    if (taskTokens[1].equals("1")) {
                        task.setIsDone(true);
                    }
                    tasks.add(task);
                    break;
                case "[E]":
                    Task task = new Event(taskTokens[2], taskTokens[3]);
                    if (taskTokens[1].equals("1")) {
                        task.setIsDone(true);
                    }
                    tasks.add(task);
                    break;
                }

            }
        } catch (FileNotFoundException e) {
            try {
                file.createNewFile();
                throw new DukeException("");
            } catch (IOException ex) {
                throw new DukeException("");
            }
        }

        return tasks;
    }

    /**
     * Saves data managed by taskList into the file
     *
     * @param taskList TaskList object managing list of tasks.
     * @throws DukeException If there is an error in saving.
     */
    public void save(TaskList taskList) throws DukeException {
        try {
            FileWriter fileWriter = new FileWriter(file);
            for (int i = 1; i <= taskList.getNumTasks(); i++) {
                Task task = taskList.getTask(i);
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
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            throw new DukeException(e.getMessage());
        }

    }
}

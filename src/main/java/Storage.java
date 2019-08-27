import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Storage {
    private String filePath;
    private File file;

    public Storage(String filePath) {
        this.filePath = filePath;
        file = new File(filePath);
    }

    public ArrayList<Task> load() {
        ArrayList<Task> tasks = new ArrayList<>();
        try {
            Scanner fileReader = new Scanner(file);
            while (fileReader.hasNextLine()) {
                String taskLine = fileReader.nextLine();
                String[] taskTokens = taskLine.split("::");
                Task task;
                switch (taskTokens[0]) {
                case "[T]":
                    task = new ToDo(taskTokens[2]);
                    if (taskTokens[1].equals("1")) {
                        task.setIsDone(true);
                    }
                    tasks.add(task);
                    break;
                case "[D]":
                    task = new Deadline(taskTokens[2], taskTokens[3]);
                    if (taskTokens[1].equals("1")) {
                        task.setIsDone(true);
                    }
                    tasks.add(task);
                    break;
                case "[E]":
                    task = new Event(taskTokens[2], taskTokens[3]);
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
            } catch (IOException ex) {

            }
        } catch (DukeException e) {
        }
    }

    public void save(ArrayList<Task> tasks) {
        try {
            FileWriter fileWriter = new FileWriter(file);
            for (Task task : tasks) {
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
            System.out.print(e);
        }

    }
}

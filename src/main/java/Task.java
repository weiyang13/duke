import java.text.SimpleDateFormat;

abstract class Task {
    protected String description;
    protected boolean isDone;
    protected SimpleDateFormat dateFormat;

    public Task(String description) {
        this.description = description;
        isDone = false;
        dateFormat = new SimpleDateFormat("dd/MM/yyyy HHmm");
    }

    public boolean getIsDone() {
        return isDone;
    }

    public void setIsDone(boolean isDone) {
        this.isDone = isDone;
    }

    public String getStatusIcon() {
        if (isDone) {
            return "+";
        } else {
            return "-";
        }
    }

    @Override
    public String toString() {
        return "[" + getStatusIcon() + "] " + description;
    }
}
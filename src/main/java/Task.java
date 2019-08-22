abstract class Task {
    protected String description;
    protected boolean isDone;

    public Task(String description) {
        this.description = description;
        isDone = false;
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
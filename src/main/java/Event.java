class Event extends Task {
    protected String at;

    public Event (String description, String at) {
        super(description);
        this.at = at;
        taskType = TaskType.EVENT;
    }

    public String getAt() {
        return at;
    }

    @Override
    public String toString() {
        return super.toString() + " (at: " + at + ")";
    }
}

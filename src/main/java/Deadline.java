class Deadline extends Task {
    protected String by;

    public Deadline (String description, String by) {
        super(description);
        this.by = by;
        taskType = TaskType.DEADLINE;
    }

    @Override
    public String toString() {
        return super.toString() + " (by: " + by + ")";
    }
}

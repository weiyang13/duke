package duke.task;

public enum TaskType {
    TO_DO('T'),
    DEADLINE('D'),
    EVENT('E');

    private char typeSymbol;

    TaskType(char typeSymbol) {
        this.typeSymbol = typeSymbol;
    }

    @Override
    public String toString() {
        return "[" + typeSymbol + "]";
    }
}
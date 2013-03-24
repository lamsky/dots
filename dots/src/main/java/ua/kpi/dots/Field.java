package ua.kpi.dots;

public class Field {
    private int size;

    public Field(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException();
        }
        this.size = size;
    }

    public int getSize() {
        return size;
    }
}

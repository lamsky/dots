package ua.kpi.dots;

public class Field {
    public Field(int size) {
        if (size < 0) {
            throw new IllegalArgumentException();
        }
    }

    public int getSize() {
        return 0;
    }
}

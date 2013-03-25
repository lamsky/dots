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

    public void putDot(int x, int y, Dot dot) {
        if((x > size) || (x < 0) || (y > size) || (y < 0)) {
            throw new IllegalArgumentException();
        }
        //To change body of created methods use File | Settings | File Templates.
    }
}

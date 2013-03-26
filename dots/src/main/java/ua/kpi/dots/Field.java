package ua.kpi.dots;

public class Field {
    // ∙◯◉─│╱╲

    private int size;
    Dot[] dots;

    public Field(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException();
        }
        this.size = size;
        dots = new Dot[size * size];
    }

    public int getSize() {
        return size;
    }

    public void placeDot(int x, int y, Dot dot) {
        if((x >= size) || (x < 0) || (y >= size) || (y < 0)) {
            throw new IllegalArgumentException();
        }
        if( dots[xyToIndex(x, y)] != null) {
            throw new IllegalArgumentException();
        }
        dots[xyToIndex(x, y)] = dot;
    }

    public boolean isFree(int x, int y) {
        return (dots[xyToIndex(x, y)] == null);
    }

    private int xyToIndex(int x, int y) {
        return (y*size + x);
    }

    @Override
    public String toString() {
        String result = "";
        for (int index = 0; index < size * size; index ++) {
            result += "∙";
            if (index%size == size -1) {
                result += "\n";
            }
        }
        return result;
    }
}

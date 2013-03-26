package ua.kpi.dots;

public class Field {
    // ∙◯◉─│╱╲

    private int size;
    Dot[][] dots;

    public Field(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException();
        }
        this.size = size;
        dots = new Dot[size][size];
    }

    public int getSize() {
        return size;
    }

    public void placeDot(int x, int y, Dot dot) {
        if ((x >= size) || (x < 0) || (y >= size) || (y < 0)) {
            throw new IllegalArgumentException();
        }
        if (dots[x][y] != null) {
            throw new IllegalArgumentException();
        }
        dots[x][y] = dot;
    }

    public boolean isFree(int x, int y) {
        return (dots[x][y] == null);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                if (dots[x][y] == null) {
                    builder.append("∙");
                } else {
                    builder.append(dots[x][y].toString());
                }
            }
            builder.append("\n");
        }
        return builder.toString();
    }
}

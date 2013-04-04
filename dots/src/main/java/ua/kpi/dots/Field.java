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
        if (isValidPosition(x, y)) {
            dots[x][y] = dot;
        } else {
            throw new IllegalArgumentException();
        }

    }

    private boolean isValidPosition(int x, int y) {
        return (x < size) && (x >= 0) && (y < size) && (y >= 0) && isFree(x, y);
    }

    public boolean isFree(int x, int y) {
        return (dots[x][y] == null);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int j = 0; j < size*2 - 1; j++) {
            for (int i = 0; i < size*2 - 1; i++) {
                if(i%2 == 0 && j%2 == 0) {
                    int x = i/2;
                    int y = j/2;
                    if (dots[x][y] == null) {
                        builder.append('∙');
                    } else {
                        builder.append(dots[x][y].toString());
                    }
                } else {
                    builder.append(' ');
                }
            }
            builder.append("\n");
        }
        /*
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
        //*/
        return builder.toString();
    }
}

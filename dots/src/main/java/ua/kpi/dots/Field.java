package ua.kpi.dots;

import java.util.ArrayList;
import java.util.List;

public class Field {

    public static char EMPTY_CELL = '∙';
    public static char EMPTY_LINE_PLACE = ' ';

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

    public Surround placeDot(int x, int y, Dot dot) {
        if (isValidPosition(x, y)) {
            dots[x][y] = dot;
        } else {
            throw new IllegalArgumentException();
        }
        //TODO write code for checking issue Surround
        return null;
    }

    private boolean isValidPosition(int x, int y) {
        return (x < size) && (x >= 0) && (y < size) && (y >= 0) && isFree(x, y);
    }

    public boolean isFree(int x, int y) {
        return (dots[x][y] == null);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int row = 0; row < size*2 - 1; row++) {
            stringBuilder.append(buildLine(row));
        }
        return stringBuilder.toString();
    }

    private String buildLine(int row) {
        StringBuilder line = new StringBuilder();
        for (int column = 0; column < size*2 - 1; column++) {
            line.append(selectDotsSymbol(column, row));
        }
        line.append("\n");
        return line.toString();
    }

    private String selectDotsSymbol(int column, int row) {
        if(column%2 == 0 && row%2 == 0) {
            int x = column/2;
            int y = row/2;
            if (dots[x][y] == null) {
                return String.valueOf(EMPTY_CELL);
            } else {
                return dots[x][y].toString();
            }
        }
        return String.valueOf(EMPTY_LINE_PLACE); //TODO Place code for displaying lines
    }

    public boolean isAvailableMove() {
        for (Dot[] dotRow : dots) {
            for (Dot dot : dotRow) {
                if (dot == null) {
                    return true;
                }
            }
        }
        return false;
    }


    public ArrayList<Surround> findAllSurrounds(Dot dot) {
        ArrayList<Surround> result = new ArrayList<Surround>();

        Surround surround = new Surround();


        findSurrounds(dot, result, surround);
        //TODO write body of function
        return result;
    }

    private void findSurrounds(Dot dot, ArrayList<Surround> result, Surround surround) {
        List<Dot> availableDots = findAvailableDots(dot);
        for(Dot currentDot : availableDots) {
            Barrier line = new Barrier(dot, currentDot);
            if (surround.isOriginal(line)) {
                switch (surround.addBarrier(line)) {
                    case 1: result.add(surround.clone());
                        surround.removeLastBarrier();
                        break;
                    case -1: break;
                    default: findSurrounds(currentDot, result, surround); // запустити саму себе
                }
            }
        }
    }

    public List<Dot> findAvailableDots(Dot dot) {
        ArrayList<Dot> result = new ArrayList<Dot>();
        int x = dot.getX() + 1;
        int y = dot.getY() - 1;
        for(int i = 0; i < 8; i++){
            x += delta(i + 6);
            y += delta(i);if ((x < size) && (x >= 0) && (y < size) && (y >= 0) && dots[x][y] != null) {
                if (dot.isSamePlayerDots(dots[x][y]) && availableLine(dot, dots[x][y])) {
                    result.add(dots[x][y]);
                }
            }
        }
        return result;
    }

    /*
     *  Функція, що перетворює 0, 1, 2, 3, 4 ...
     *                       в 0, 0, 1, 1, 0, 0, -1, -1, 0, 0, 1, 1 ...
     */
    private int delta(int index) {
        return ((index / 2) % 2) * (1 - ((index / 4) % 2) * 2);
    }

    private boolean availableLine(Dot dotA, Dot dotB) {
        if ((dotA.getX() == dotB.getX()) || (dotA.getY() == dotB.getY())) {
            return true;
        }
        //TODO write code for checking the enemy diagonal lines
        return true;
    }
}

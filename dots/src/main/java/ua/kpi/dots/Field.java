package ua.kpi.dots;

import java.util.ArrayList;

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

    public Capture placeDot(int x, int y, Dot dot) {
        if (isValidPosition(x, y)) {
            dots[x][y] = dot;
        } else {
            throw new IllegalArgumentException();
        }
        return null;
    }

    private boolean isValidPosition(int x, int y) {
        //TODO write code for check come in enemy capture
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
        //TODO Replace "EMPTY_LINE_PLACE" with code for displaying lines of captures
        return String.valueOf(EMPTY_LINE_PLACE);
    }

    public boolean isAvailableMove() {

        //TODO
        for (Dot[] dotRow : dots) {
            for (Dot dot : dotRow) {
                if (dot == null) {
                    return true;
                }
            }
        }
        return false;
    }


    public ArrayList<Capture> findAllCaptures(Dot dot) {
        ArrayList<Capture> result = new ArrayList<Capture>();
        Capture capture = new Capture();
        findCapturesRecursively(dot, result, capture);
        deleteSameCaptures(result);

        //TODO Place function for removing empty captures
        //TODO Place function for removing biggest captures with same imprisoned dots
        return result;
    }

    private void findCapturesRecursively(Dot dot, ArrayList<Capture> result,
                                         Capture capture) {
        ArrayList<Dot> availableDots = findAvailableDots(dot, capture);
        for(Dot currentDot : availableDots) {
            Barrier line = new Barrier(dot, currentDot);
            if (capture.isAvailable(line)) {
                switch (capture.addBarrier(line)) {
                    case 1:
                        if (capture.size() > 3) {
                            result.add(capture.clone());
                        }
                        capture.removeLastLine();
                        break;
                    case -1:
                        break;
                    default:
                        findCapturesRecursively(currentDot, result, capture);
                }
            }
        }
        if(capture.size() > 0) {
            capture.removeLastLine();
        }
    }

    private void deleteSameCaptures(ArrayList<Capture> captures) {
        if(captures.size() < 2) {
            return;
        }
        for (int index = 0; index < captures.size(); index++) {
            for (int nextIndex = index + 1; nextIndex < captures.size(); nextIndex++) {
                if( captures.get(index).isSame(captures.get(nextIndex))) {
                    captures.remove(nextIndex);
                    nextIndex--;
                }
            }
        }
    }

    private ArrayList<Dot> findAvailableDots(Dot dot, Capture capture) {
        ArrayList<Dot> result = new ArrayList<Dot>();
        // converts "i" into dots coordinates, starting from from the top dot,
        // counterclockwise
        int x = dot.getX() + 1;
        int y = dot.getY() - 1;
        for(int i = 0; i < 8; i++){
            x += delta(i + 6);
            y += delta(i);
            if ((x < size) && (x >= 0) && (y < size) && (y >= 0) && (dots[x][y] != null)) {
                if (dot.isSamePlayerDots(dots[x][y]) && availableLine(dot, dots[x][y]) && !capture.isUsedWithoutStartDot(dots[x][y])) {
                    result.add(dots[x][y]);
                }
            }
        }
        return result;
    }

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

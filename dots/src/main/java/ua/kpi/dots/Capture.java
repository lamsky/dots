package ua.kpi.dots;

import java.util.ArrayList;

/**
 * @author Myhaylo Kotsyuruba
 * @version v.   08.04.13
 */
public class Capture {
    private ArrayList<Barrier> lines;

    /*
    public Capture(Barrier line) {
        lines = new ArrayList<Barrier>();
        lines.add(line);
    }
    */
    public Capture() {
        lines = new ArrayList<Barrier>();
    }

    public int addBarrier(Barrier line) {
        if(lines.size() == 0) {
            lines.add(line);
            return 0;
        }

        Barrier lastLine = lines.get(lines.size() - 1);
        if (!line.continuesLine(lastLine) ) {
            throw new IllegalArgumentException();
        }

        if (endIsStart(line)) {
            lines.add(line);
            return 1;
        }

        if(contain(line.getDotB())) {
            return -1;
        }
        lines.add(line);
        return 0;
    }

    private boolean endIsStart(Barrier line) {
        Dot startDot = lines.get(0).getDotA();
        Dot endDot = line.getDotB();
        return startDot.equals(endDot);
    }

    private boolean contain(Dot dot) {
        for (Barrier currentLine : lines) {
            if (currentLine.contain(dot)) {
                return true;
            }
        }
        return false;
    }

    public boolean isOriginal(Barrier line) {
        for (Barrier currentLine : lines) {
            if (line.isSame(currentLine)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public Capture clone()  {
        Capture result = new Capture();
        for (Barrier currentLine : lines) {
            result.lines.add(currentLine.clone());
        }
        return result;
    }

    public void removeLastLine() {
        lines.remove(lines.size() - 1);
    }

    public int size() {
        return lines.size();
    }

    public boolean isUsedWithoutStartDot(Dot dot) {
        if (lines.size() == 0) return false;
        Dot startDot = lines.get(0).getDotA();
        if (dot.equals(startDot)) return false;
        for(Barrier line : lines) {
            if(line.contain(dot)) {
                return true;
            }
        }
        return false;
    }

    public boolean isCrossing(Barrier line) {
        if (lines.size() == 0) {
            return false;
        }
        int xA = line.getDotA().getX();
        int yA = line.getDotA().getY();
        int xB = line.getDotB().getX();
        int yB = line.getDotB().getY();

        if ((xA == xB) || (yA == yB)) {
            return false;
        }

        char label = line.getDotA().toString().charAt(0);
        Barrier diagonalLine = new Barrier(new Dot(xA, yB, label),
                                           new Dot(xB, yA, label));
        return !isOriginal(diagonalLine);
    }

    public boolean isAvailable(Barrier line) {
        return isOriginal(line) && (!isCrossing(line));
    }

    public boolean isSame(Capture that) {
        if (that == null) {
            throw new IllegalArgumentException();
        }
        if (this.size() != that.size()) {
            return false;
        }

        if(isSameForwardOrder(that) || isSameReverseOrder(that)) {
            return true;
        }
        return false;
    }

    private boolean isSameReverseOrder(Capture that) {
        for (int index = 0; index < size(); index++ ) {
            Barrier thisLine = this.lines.get(index);
            Barrier thatLine = that.lines.get(size() - index - 1);
            if (!thisLine.isSame(thatLine)) {
                return false;
            }
        }
        return true;
    }

    private boolean isSameForwardOrder(Capture that) {
        for (int index = 0; index < size(); index++ ) {
            Barrier thisLine = this.lines.get(index);
            Barrier thatLine = that.lines.get(index);
            if (!thisLine.isSame(thatLine)) {
                return false;
            }
        }
        return true;
    }
}

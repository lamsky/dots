package ua.kpi.dots;

import java.util.ArrayList;

/**
 * @author Myhaylo Kotsyuruba
 * @version v.   08.04.13
 */
public class Surround {
    private ArrayList<Barrier> lines;

    public Surround(Barrier line) {
        this();
        addBarrier(line);
        //lines.add(line);
    }

    public Surround() {
        lines = new ArrayList<Barrier>();
    }

    public int addBarrier(Barrier line) {
        if (line == null) {
            throw new IllegalArgumentException();
        }

        if(lines.size() == 0) {
            lines.add(line);
            return 0;
        }

        Barrier lastLine = lines.get(lines.size() - 1);
        if (!line.continuesLine(lastLine) || !isOriginal(line)) {
            throw new IllegalArgumentException();
        }
        if (endIsStart(line)) {
            lines.add(line);
            return 1;
        }
        if(contain(line.getDotB())) {
            return -1;
        } else {
            lines.add(line);
        }
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
    public Surround clone()  {
        Surround result = new Surround(lines.get(0).clone());
        for (int index = 1; index < lines.size(); index++) {
            result.lines.add(this.lines.get(index).clone());
        }
        return result;
    }

    public void removeLastBarrier() {
        lines.remove(lines.size() - 1);
    }
}

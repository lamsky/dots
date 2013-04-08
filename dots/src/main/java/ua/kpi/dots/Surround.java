package ua.kpi.dots;

import java.util.ArrayList;

/**
 * @author Myhaylo Kotsyuruba
 * @version v.   08.04.13
 */
public class Surround {
    ArrayList<Barrier> lines;

    public Surround(Barrier line) {
        lines = new ArrayList<Barrier>();
        lines.add(line);
    }

    public int addBarrier(Barrier line) {
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
}

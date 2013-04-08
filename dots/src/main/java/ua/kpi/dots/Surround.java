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

    public void addBarrier(Barrier line) {
        Barrier lastLine = lines.get(lines.size() - 1);
        if (!line.continuesLine(lastLine) || !isOriginal(line)) {
            throw new IllegalArgumentException();
        }
        lines.add(line);
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

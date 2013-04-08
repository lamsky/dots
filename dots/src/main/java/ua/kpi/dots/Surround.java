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
}

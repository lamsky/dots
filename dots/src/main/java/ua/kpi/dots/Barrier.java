package ua.kpi.dots;

/**
 * @author Myhaylo Kotsyuruba
 * @version v.   08.04.13
 */
public class Barrier {
    private Dot dotA;
    private Dot dotB;
    public Barrier(Dot dotA, Dot dotB) {
        if ((Math.abs(dotA.getX() - dotB.getX()) > 1)
                || (Math.abs(dotA.getY() - dotB.getY()) > 1)
                || (dotA.equals(dotB))) {
            throw new IllegalArgumentException();
        }

        this.dotA = dotA;
        this.dotB = dotB;
    }
}

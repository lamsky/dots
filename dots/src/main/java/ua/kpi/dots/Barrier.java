package ua.kpi.dots;

/**
 * @author Myhaylo Kotsyuruba
 * @version v.   08.04.13
 */
public class Barrier {
    private Dot dotA;
    private Dot dotB;
    public Barrier(Dot dotA, Dot dotB) {
        if (!isCorrectDistance(dotA, dotB)
                || !dotA.isSamePlayerDots(dotB)
                || !dotA.isDifferentCoordinates(dotB)){
            throw new IllegalArgumentException();
        }
        this.dotA = dotA;
        this.dotB = dotB;
    }

    public Dot getDotA() {
        return dotA.clone();
    }

    public Dot getDotB() {
        return dotB.clone();
    }


    private boolean isCorrectDistance(Dot dotA, Dot dotB) {
        return (Math.abs(dotA.getX() - dotB.getX()) < 2)
                && (Math.abs(dotA.getY() - dotB.getY()) < 2);
    }

    public boolean continuesLine(Barrier previousLine) {
        return previousLine.dotB.equals(this.dotA);
    }

    public boolean isSame(Barrier line) {
        return (this.dotA.equals(line.dotA) && this.dotB.equals(line.dotB))
                || (this.dotA.equals(line.dotB) && this.dotB.equals(line.dotA));
    }

    public boolean contain(Dot dot) {
        return (dotA.equals(dot) || dotB.equals(dot));
    }

    @Override
    public Barrier clone() {
        return new Barrier(dotA.clone(), dotB.clone());
    }
}

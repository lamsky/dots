package ua.kpi.dots;

/**
 * @author Myhaylo Kotsyuruba
 * @version v.   25.03.13
 */
public class Dot {
    private char label;
    private int x;
    private int y;

    public Dot(int x, int y, char label) {
        this.label = label;
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return String.valueOf(label);
    }


    @Override
    public int hashCode() {
        return x + y + label;
    }

    @Override
    public boolean equals(Object obj) {
        if((obj == null) || (obj.getClass() != this.getClass())) {
            return false;
        }

        Dot currentDot = (Dot) obj;
        return (   (this.x == currentDot.x)
                && (this.y == currentDot.y)
                && (this.label == currentDot.label));
    }

    @Override
    public Dot clone() {
        return new Dot(x, y, label);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isSamePlayer(Dot dot) {
        return this.label == dot.label;
    }

    public boolean isDifferentCoordinates(Dot dot) {
        return !((this.x == dot.x) && (this.y == dot.y));
    }
}

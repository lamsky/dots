package ua.kpi.dots;

/**
 * @author Myhaylo Kotsyuruba
 * @version v.   25.03.13
 */
public class Dot {
    private char label;

    public Dot(char label) {
        this.label = label;
    }

    public Dot() {
        this('@');
    }

    @Override
    public String toString() {
        return String.valueOf(label);
    }
}

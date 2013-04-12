package ua.kpi.dots;

public class Player {

    private char[] charSet;

    public Player(char[] charSet) {
        this.charSet = charSet;
    }

    public Dot placeDot(String field) {
        return new Dot(0, 0, charSet[0]);
    }

    public Dot getDot(int x, int y) {
        return new Dot(x, y, charSet[0]);
    }
}

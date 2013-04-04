package ua.kpi.dots;

public class Game {
    private Field field;

    private Player red;
    private Player blue;

    public Game(Field field, Player red, Player blue) {
        this.field = field;
        this.red = red;
        this.blue = blue;
    }

    public Player getRedPlayer() {
        return red;
    }

    public Player getBluePlayer() {
        return blue;
    }

    public Field getField() {
        return field;
    }
}

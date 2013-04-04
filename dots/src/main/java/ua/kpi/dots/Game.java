package ua.kpi.dots;

import java.awt.*;

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

    public void doMove(Player player) {
        Point p = player.placeDot(field.toString());
        field.placeDot(p.x, p.y, player.getDot());
    }

    public void run() {
        while (field.isEvailableMove()) {
            Point p = red.placeDot(field.toString());
            field.placeDot(p.x, p.y, red.getDot());
            p = blue.placeDot(field.toString());
            field.placeDot(p.x, p.y, blue.getDot());
        }
    }

    public static void main(String[] args) {

    }

}

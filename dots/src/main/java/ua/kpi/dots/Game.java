package ua.kpi.dots;

public class Game {
    Player red;
    Player blue;

    public Game(Player red, Player blue) {
        this.red = red;
        this.blue = blue;
    }

    public Player getRedPlayer() {
        return red;
    }

    public Player getBluePlayer() {
        return blue;
    }
}

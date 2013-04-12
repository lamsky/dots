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

    public String getField() {
        return field.toString();
    }

    public void placeDot(Player player) {
        Dot dot = player.placeDot(field.toString());
        field.placeDot(dot.getX(), dot.getY(), dot);
    }

    public void run() {
        while (true) {
            if (!field.isAvailableMove()) {
                return;
            }
            placeDot(red);
            if (!field.isAvailableMove()) {
                return;
            }
            placeDot(blue);
        }
    }

    public static void main(String[] args) {
        Field field = new Field(10);
        Player player1 = new RandomPlayer(DisplaySymbols.PLAYER_SET_0);
        Player player2 = new RandomPlayer(DisplaySymbols.PLAYER_SET_1);
        Game game = new Game(field, player1, player2);
        game.run();

    }

}

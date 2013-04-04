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

    public void doMove(Player player) {
        PlayerMessage message = player.placeDot(field.toString());
        field.placeDot(message.getX(), message.getY(), player.getDot());
    }

    public void run() {
        while (true) {
            if (!field.isAvailableMove()) {
                return;
            }
            doMove(red);
            if (!field.isAvailableMove()) {
                return;
            }
            doMove(blue);
        }
    }

    public static void main(String[] args) {

    }

}

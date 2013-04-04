package ua.kpi.dots;

public class Player {
    public static char[] PLAYER_SET_0 = {'◯', '─', '│', '╲', '╱'};
    public static char[] PLAYER_SET_1 = {'●', '━', '┃', '▚', '▞'};

    private char[] charSet;

    public Player(char[] charSet) {
        this.charSet = charSet;
    }

    public PlayerMessage placeDot(String field) {
        return new PlayerMessage(0, 0);
    }

    public Dot getDot() {
        return new Dot(charSet[0]);
    }
}

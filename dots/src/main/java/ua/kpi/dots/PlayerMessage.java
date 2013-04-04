package ua.kpi.dots;

/**
 * @author Myhaylo Kotsyuruba
 * @version v.   04.04.13
 */
public class PlayerMessage {
    int x;
    int y;
    public PlayerMessage(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

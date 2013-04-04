package ua.kpi.dots;



/**
 * @author Myhaylo Kotsyuruba
 * @version v.   04.04.13
 */
public class RandomPlayer extends Player {
    public RandomPlayer(char[] charSet) {
        super(charSet);
    }

    @Override
    public PlayerMessage placeDot(String field) {
        int size = (((int) Math.sqrt(field.length())) + 1) / 2;
        int x;
        int y;
        do {
            x = (int) (Math.random() * size);
            y = (int) (Math.random() * size);
        } while (field.charAt(x * 2 + y * 2 * size * 2) != '∙');
        return new PlayerMessage(x, y);
    }
}

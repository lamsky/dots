package ua.kpi.dots;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * @author Myhaylo Kotsyuruba
 * @version v.   04.04.13
 */
public class RandomPlayerTest {

    @Test
    public void shouldRandomPlayerCorrectPlaceDot_WhenIsAvailableOnePlace() {
        RandomPlayer randomPlayer = new RandomPlayer(Player.PLAYER_SET_0);
        String field = "◯ ◯ ◯\n"
                     + "     \n"
                     + "◯ ◯ ∙\n"
                     + "     \n"
                     + "◯ ◯ ◯\n";
        PlayerMessage message = randomPlayer.placeDot(field);
        assertTrue(message.x == 2 && message.y == 1);
    }
}

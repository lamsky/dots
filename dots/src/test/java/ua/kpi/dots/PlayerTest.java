package ua.kpi.dots;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class PlayerTest {
    private Field field;

    @Before
    public void init() {
        field = new Field(1);
    }

    @Test
    public void shouldPlayerPlaceDot() {
        Player player = new Player(DisplaySymbols.PLAYER_SET_0);
        assertNotNull(player.placeDot(field.toString()));
    }

    @Test
    public void shouldPlayerReturnDot() {
        Player player = new Player(DisplaySymbols.PLAYER_SET_0);
        assertNotNull(player.getDot(0, 0));
    }
}

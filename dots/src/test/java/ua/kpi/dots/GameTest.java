package ua.kpi.dots;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class GameTest {
    private Game game;

    @Before
    public void init() {
        game = new Game(new Field(10), new Player(), new Player());
    }

    // We have a field
    @Test
    public void shouldExistField_WhenGameCreated() {
        assertNotNull(game.getField());
    }

    // We have 2 players
    @Test
    public void shouldExistRedPlayer_WhenGameCreates() {
        assertNotNull(game.getRedPlayer());
    }

    @Test
    public void shouldExistBluePlayer_WhenGameCreates() {
        assertNotNull(game.getBluePlayer());
    }

    // Players take turns
    // Dots can be 2 types = from 2 players
    // When there is a loop, which consists of same type dots,
    //   it's become closed
    // All enemy dots in closed loop are captured
    // Loops can't be intersected
    // Game is over when there is no place to put dot outside loops

}

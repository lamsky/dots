package ua.kpi.dots;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GameTest {
    private Game game;
    private Field field;
    private Player red;
    private Player blue;


    @Before
    public void init() {
        red = new Player(Player.PLAYER_SET_0);
        blue = new Player(Player.PLAYER_SET_1);
        field = new Field(10);
        game = new Game(field, red, blue);
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

    @Test
    public void shouldPlayerDoMove_WhenGameCreates() {
        game = new Game(new Field(1), red, blue);
        game.doMove(red);
        assertEquals(game.getField().toString(),
                Player.PLAYER_SET_0[0] + "\n");
    }

    @Test
    public void shouldPlacePointInAllAvailableCell_WhenTwoRandomPlayers() {
        Player randomRed = new RandomPlayer(Player.PLAYER_SET_0);
        Player randomBlue = new RandomPlayer(Player.PLAYER_SET_1);
        Game game = new Game(field, randomRed, randomBlue);
        game.run();
        String field = game.getField().toString();
        assertEquals(-1, field.indexOf(Field.EMPTY_CELL));
    }

    // Players take turns
    // Dots can be 2 types = from 2 players
    // When there is a loop, which consists of same type dots,
    //   it's become closed
    // All enemy dots in closed loop are captured
    // Loops can't be intersected
    // Game is over when there is no place to put dot outside loops

}

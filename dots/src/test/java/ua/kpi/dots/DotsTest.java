package ua.kpi.dots;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class DotsTest {
    private Game game;
    private Field field;

    @Before
    public void init() {
        game = new Game(new Player(), new Player());
        field = new Field(10);
    }

    // We have a field
    @Test
    public void shouldExistField_WhenGameCreated() {
        new Field(1);
    }

    // Field has some size
    @Test
    public void shouldFieldHasSize_WhenCreated() {
        Field field = new Field(1);

        assertEquals(1, field.getSize());
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowException_WhenSizeIsNegative() {
        new Field(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowException_WhenSizeIsZero() {
        new Field(0);
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
    public void shouldCreateDot() {
        assertNotNull(new Dot());
    }

    @Test
    public void shouldPutDotOnField() {
        field.putDot(1, 1, new Dot());
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowException_WhenXLargerThanSize() {
        int x = field.getSize() + 1;
        field.putDot(x, 1, new Dot());

    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowException_WhenXNegative() {
        int x = -1;
        field.putDot(x, 1, new Dot());

    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowException_WhenYLargerThanSize() {
        int y = field.getSize() + 1;
        field.putDot(1, y, new Dot());

    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowException_WhenYNegative() {
        int y = -1;
        field.putDot(1, y, new Dot());

    }

    @Test
    public void shouldBusyCell_WhenDotPutInCell() {
        field.putDot(1, 1, new Dot());
        assertEquals(false, field.isFree(1, 1));

    }



    // Players take turns
    // Dots can be 2 types = from 2 players
    // Dots can be placed on the field
    // When there is a loop, which consists of same type dots,
    //   it's become closed
    // All enemy dots in closed loop are captured
    // Loops can't be intersected
    // Game is over when there is no place to put dot outside loops

}

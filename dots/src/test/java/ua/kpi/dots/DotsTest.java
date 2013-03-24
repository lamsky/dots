package ua.kpi.dots;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class DotsTest {

    // We have a field
    @Test
    public void shouldExistFieldWhenGameCreated() {
        new Field(1);
    }

    // Field has some size
    @Test
    public void shouldFieldHasSizeWhenCreated() {
        Field field = new Field(1);

        assertEquals(1, field.getSize());
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenSizeIsNegative() {
        new Field(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenSizeIsZero() {
        new Field(0);
    }

    // We have 2 players
    @Test
    public void shouldExistRedPlayerWhenGameCreates() {
        Game dots = new Game(new Player(), new Player());
        assertNotNull(dots.getRedPlayer());
    }

    // Players take turns
    // Dots can be 2 types = from 2 players
    // Dots can be placed on the field
    // When there is a loop, which consists of same type dots, it's become closed
    // All enemy dots in closed loop are captured
    // Loops can't be intersected
    // Game is over when there is no place to put dot outside loops

}

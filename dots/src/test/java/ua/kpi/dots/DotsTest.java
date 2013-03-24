package ua.kpi.dots;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DotsTest {

    // We have a field
    @Test
    public void shouldExistFieldWhenGameCreated() {
        new Field(0);
    }

    // Field has some size
    @Test
    public void shouldFieldHasSizeWhenCreated() {
        Field field = new Field(0);

        assertEquals(0, field.getSize());
    }

    // We have 2 players
    // Players take turns
    // Dots can be 2 types = from 2 players
    // Dots can be placed on the field
    // When there is a loop, which consists of same type dots, it's become closed
    // All enemy dots in closed loop are captured
    // Loops can't be intersected
    // Game is over when there is no place to put dot outside loops

}

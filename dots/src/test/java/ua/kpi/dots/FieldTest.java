package ua.kpi.dots;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FieldTest {
    private Field field;

    @Before
    public void init() {
        field = new Field(10);
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

    @Test
    public void shouldFieldBeEmpty_WhenCreated() {
        assertFreeField(field);
    }

    private void assertFreeField(Field field) {
        for (int x = 0; x < field.getSize(); x++) {
            for (int y = 0; y < field.getSize(); y++) {
                assertTrue(field.isFree(x, y));
            }
        }
    }

    // Dots can be placed on the field
    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowException_WhenXLargerThanSize() {
        int x = field.getSize();
        field.placeDot(x, 1, new Dot());
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowException_WhenXNegative() {
        int x = -1;
        field.placeDot(x, 1, new Dot());
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowException_WhenYLargerThanSize() {
        int y = field.getSize();
        field.placeDot(1, y, new Dot());
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowException_WhenYNegative() {
        int y = -1;
        field.placeDot(1, y, new Dot());
    }

    @Test
    public void shouldBusyCell_WhenDotPlacedInCell() {
        field.placeDot(1, 1, new Dot());
        assertFalse(field.isFree(1, 1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowException_WhenPlacedDotInBusyCell() {
        field.placeDot(0, 0, new Dot());
        field.placeDot(0, 0, new Dot());
    }

    @Test
    public void shouldFieldBeString_WhenSizeIs2() {
        Field field = new Field(2);
        assertEquals(field.toString(),
                "∙ ∙\n"
              + "   \n"
              + "∙ ∙\n");
    }

    @Test
    public void shouldFieldBeString_WhenSizeIs3() {
        Field field = new Field(3);
        assertEquals(field.toString(),
                "∙ ∙ ∙\n"
              + "     \n"
              + "∙ ∙ ∙\n"
              + "     \n"
              + "∙ ∙ ∙\n");
    }

    @Test
    public void shouldFieldBeString_WhenSizeIs4() {
        Field field = new Field(4);
        assertEquals(field.toString(),
                "∙ ∙ ∙ ∙\n"
              + "       \n"
              + "∙ ∙ ∙ ∙\n"
              + "       \n"
              + "∙ ∙ ∙ ∙\n"
              + "       \n"
              + "∙ ∙ ∙ ∙\n");
    }

    @Test
    public void shouldBeDisplayedDots_whenPlacedOnField4() {
        Field field = new Field(4);
        Dot dotB = new Dot('◯');
        Dot dotR = new Dot('●');
        field.placeDot(1, 1, dotB);
        field.placeDot(2, 2, dotR);
        assertEquals(field.toString(),
                "∙ ∙ ∙ ∙\n"
              + "       \n"
              + "∙ ◯ ∙ ∙\n"
              + "       \n"
              + "∙ ∙ ● ∙\n"
              + "       \n"
              + "∙ ∙ ∙ ∙\n");
    }

    @Test
    public void shouldBeDisplayedDots_whenPlacedOnField5() {
        Field field = new Field(5);
        Dot dotB = new Dot('◯');
        Dot dotR = new Dot('●');
        field.placeDot(1, 1, dotB);
        field.placeDot(3, 3, dotR);
        assertEquals(field.toString(),
                "∙ ∙ ∙ ∙ ∙\n"
              + "         \n"
              + "∙ ◯ ∙ ∙ ∙\n"
              + "         \n"
              + "∙ ∙ ∙ ∙ ∙\n"
              + "         \n"
              + "∙ ∙ ∙ ● ∙\n"
              + "         \n"
              + "∙ ∙ ∙ ∙ ∙\n");
    }

}

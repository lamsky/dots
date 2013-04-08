package ua.kpi.dots;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class FieldTest {
    private Field field;
    private Dot testDot;

    @Before
    public void init() {
        field = new Field(10);
        testDot = new Dot(0, 0, Player.PLAYER_SET_0[0]);
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
        Dot dot = new Dot(x, 1, 'x');

        field.placeDot(dot.getX(), dot.getY(), dot);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowException_WhenXNegative() {
        int x = -1;
        Dot dot = new Dot(x, 1, 'x');
        field.placeDot(dot.getX(), dot.getY(), dot);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowException_WhenYLargerThanSize() {
        int y = field.getSize();
        Dot dot = new Dot(1, y, 'x');
        field.placeDot(dot.getX(), dot.getY(), dot);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowException_WhenYNegative() {
        int y = -1;
        Dot dot = new Dot(1, y, 'x');
        field.placeDot(dot.getX(), dot.getY(), dot);
    }

    @Test
    public void shouldBusyCell_WhenDotPlacedInCell() {
        Dot dot = new Dot(1, 1, 'x');
        field.placeDot(dot.getX(), dot.getY(), dot);
        assertFalse(field.isFree(1, 1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowException_WhenPlacedDotInBusyCell() {
        Dot dot = new Dot(1, 1, 'x');
        field.placeDot(dot.getX(), dot.getY(), dot);
        field.placeDot(dot.getX(), dot.getY(), dot);
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
        Field field1 = new Field(4);
        Dot dotB = new Dot(1, 1, Player.PLAYER_SET_0[0]);
        Dot dotR = new Dot(2, 2, Player.PLAYER_SET_1[0]);
        field1.placeDot(dotB.getX(), dotB.getY(), dotB);
        field1.placeDot(dotR.getX(), dotR.getY(), dotR);
        assertEquals(field1.toString(),
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
        Dot dotB = new Dot(1, 2, Player.PLAYER_SET_0[0]);
        Dot dotR = new Dot(2, 3, Player.PLAYER_SET_1[0]);
        field.placeDot(dotB.getX(), dotB.getY(), dotB);
        field.placeDot(dotR.getX(), dotR.getY(), dotR);

        assertEquals(field.toString(),
                "∙ ∙ ∙ ∙ ∙\n"
              + "         \n"
              + "∙ ∙ ∙ ∙ ∙\n"
              + "         \n"
              + "∙ ◯ ∙ ∙ ∙\n"
              + "         \n"
              + "∙ ∙ ● ∙ ∙\n"
              + "         \n"
              + "∙ ∙ ∙ ∙ ∙\n");
    }

    @Test
    public void shouldCheckerAvailableMoves_WhenFieldCreated() {
        assertTrue(field.isAvailableMove());
    }

    @Test
    public void shouldAvailableMoves_WhenAllDotsPlaced() {
        Field field = new Field(1);
        Dot dot = new Dot(0, 0, 'x');
        field.placeDot(dot.getX(), dot.getY(), dot);
        assertFalse(field.isAvailableMove());
    }

    @Test
    public void shouldFindAllSurrounds_WhenDotPlaced() {
        List<Surround> surrounds = field.findAllSurrounds(testDot);
    }

}

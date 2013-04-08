package ua.kpi.dots;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FieldTest {
    private Field field;
    private Dot testDot;

    @Before
    public void init() {
        field = new Field(10);
        testDot = new Dot(0, 0, Player.PLAYER_SET_0[0]);
    }

    private void placeDotOnField(int x, int y, char label) {
        Dot dot = new Dot(x, y, label);
        field.placeDot(dot.getX(), dot.getY(), dot);
    }

    private void placeDotOnFieldFirstPlayer(int x, int y) {
        placeDotOnField(x, y, Player.PLAYER_SET_0[0]);
    }

    private void placeDotOnFieldSecondPlayer(int x, int y) {
        placeDotOnField(x, y, Player.PLAYER_SET_1[0]);
    }


    private void assertField(int size, String image) {
        Field field = new Field(size);
        assertEquals(field.toString(), image);
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
        for (int x = 0; x < field.getSize(); x++) {
            for (int y = 0; y < field.getSize(); y++) {
                assertTrue(field.isFree(x, y));
            }
        }
    }

    // Dots can be placed on the field
    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowException_WhenXEqualOrLargerThanSize() {
        placeDotOnFieldFirstPlayer(field.getSize(), 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowException_WhenXNegative() {
        placeDotOnFieldFirstPlayer(-1, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowException_WhenYEqualOrLargerThanSize() {
        placeDotOnFieldFirstPlayer(0, field.getSize());
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowException_WhenYNegative() {
        placeDotOnFieldFirstPlayer(0, -1);
    }

    @Test
    public void shouldBusyCell_WhenDotPlacedInCell() {
        placeDotOnFieldFirstPlayer(1, 1);
        assertFalse(field.isFree(1, 1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowException_WhenPlacedDotInBusyCell() {
        placeDotOnFieldFirstPlayer(0, 0);
        placeDotOnFieldFirstPlayer(0, 0);
    }

    @Test
    public void shouldFieldBeString_WhenSizeIs2() {
        assertField(2,
                "∙ ∙\n"
              + "   \n"
              + "∙ ∙\n");
    }


    @Test
    public void shouldFieldBeString_WhenSizeIs3() {
        assertField(3,
                "∙ ∙ ∙\n"
              + "     \n"
              + "∙ ∙ ∙\n"
              + "     \n"
              + "∙ ∙ ∙\n");
    }

    @Test
    public void shouldFieldBeString_WhenSizeIs4() {
        assertField(4,
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
        field = new Field(4);
        placeDotOnFieldFirstPlayer(1, 1);
        placeDotOnFieldSecondPlayer(2, 2);
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
        field = new Field(5);
        placeDotOnFieldFirstPlayer(1, 2);
        placeDotOnFieldSecondPlayer(2, 3);
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
        field = new Field(1);
        placeDotOnFieldFirstPlayer(0,0);
        assertFalse(field.isAvailableMove());
    }

    @Test
    public void shouldFindAllSurrounds_WhenDotPlaced() {
        field.findAllSurrounds(testDot);
    }

    //TODO Write test for checking findAllSurrounds

}

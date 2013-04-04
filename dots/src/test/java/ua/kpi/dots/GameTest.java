package ua.kpi.dots;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

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
        assertFreeField(game.getField());
    }

    private void assertFreeField(Field field) {
        for (int x = 0; x < field.getSize(); x++) {
            for (int y = 0; y < field.getSize(); y++) {
                assertTrue(field.isFree(x, y));
            }
        }
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

    // Dots can be placed on the field
    @Test
    public void shouldPutDotInFreeCellWhenPrompted() {
        assertPlacingDotInFreeCell(1, 1, new Dot());
    }

    private void assertPlacingDotInFreeCell(int x, int y, Dot dot) {
        Field field = game.getField();
        assertTrue("cell must be free", field.isFree(x, y));
        field.placeDot(x, y, dot);
        assertFalse("cell mustn't be free after dot's been placed", field.isFree(x, y));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowException_WhenXLargerThanSize() {
        Field field = game.getField();
        int x = field.getSize();
        field.placeDot(x, 1, new Dot());
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowException_WhenXNegative() {
        Field field = game.getField();
        int x = -1;
        field.placeDot(x, 1, new Dot());
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowException_WhenYLargerThanSize() {
        Field field = game.getField();
        int y = field.getSize();
        field.placeDot(1, y, new Dot());
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowException_WhenYNegative() {
        Field field = game.getField();
        int y = -1;
        field.placeDot(1, y, new Dot());
    }

    @Test
    public void shouldBusyCell_WhenDotPlacedInCell() {
        Field field = game.getField();
        field.placeDot(1, 1, new Dot());
        assertEquals(false, field.isFree(1, 1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowException_WhenPlacedDotInBusyCell() {
        Field field = game.getField();
        field.placeDot(0, 0, new Dot());
        field.placeDot(0, 0, new Dot());
    }

    @Test
    public void shouldPlayerPlaceDot() {
        Player player = new Player();
        player.placeDot();
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
    public void shouldDotBeString() {
        Dot dot = new Dot();
        assertEquals(dot.toString(), "@");
    }

    @Test
    public void shouldSetDotLabelSymbol1() {
        Dot dot = new Dot('◯');
        assertEquals(dot.toString(), "◯");
    }

    @Test
    public void shouldSetDotLabelSymbol2() {
        Dot dot = new Dot('●');
        assertEquals(dot.toString(), "●");
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


    // Players take turns
    // Dots can be 2 types = from 2 players
    // When there is a loop, which consists of same type dots,
    //   it's become closed
    // All enemy dots in closed loop are captured
    // Loops can't be intersected
    // Game is over when there is no place to put dot outside loops

}

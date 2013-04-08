package ua.kpi.dots;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DotTest {
    @Test
    public void shouldSetDotLabelSymbol1() {
        Dot dot = new Dot(0, 0, '◯');
        assertEquals(dot.toString(), "◯");
    }

    @Test
    public void shouldSetDotLabelSymbol2() {
        Dot dot = new Dot(0, 0, '●');
        assertEquals(dot.toString(), "●");
    }

    @Test
    public void shouldEquals() {
        Dot dotA = new Dot(0, 0, '●');
        Dot dotB = new Dot(0, 0, '●');
        assertTrue(dotA.equals(dotB));

    }
}

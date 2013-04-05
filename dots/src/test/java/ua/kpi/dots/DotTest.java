package ua.kpi.dots;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

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
}

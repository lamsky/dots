package ua.kpi.dots;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Myhaylo Kotsyuruba
 * @version v.   08.04.13
 */
public class SurroundTest {
    private Dot dotA;
    private Dot dotB;
    private Dot dotC;
    private Dot dotD;
    Barrier lineAB;
    Surround surround;

    @Before
    public void init() {
        dotA = new Dot(0, 0, 'x');
        dotB = new Dot(1, 0, 'x');
        dotC = new Dot(0, 1, 'x');
        dotD = new Dot(1, 1, 'x');
        lineAB = new Barrier(dotA, dotB);
        surround = new Surround(lineAB);
    }

    @Test
    public void shouldAddLinesToSurround_whenSurroundCreated() {
        surround.addBarrier(new Barrier(dotB, dotC));
    }

    @Test (expected = IllegalArgumentException.class)
    public void shouldThrowException_WhenAddBadLine() {
        surround.addBarrier(new Barrier(dotC, dotD));
    }

    @Test (expected = IllegalArgumentException.class)
    public void shouldThrowException_WhenAddSameLine() {
        surround.addBarrier(new Barrier(dotB, dotA));
    }
}

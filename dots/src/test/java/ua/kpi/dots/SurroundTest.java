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

    @Before
    public void init() {
        dotA = new Dot(0, 0, 'x');
        dotB = new Dot(1, 1, 'x');
    }

    @Test
    public void shouldCreateSurroundFromLines() {
        Barrier line = new Barrier(dotA, dotB);
        Surround surround = new Surround(line);
    }
}

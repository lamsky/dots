package ua.kpi.dots;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Myhaylo Kotsyuruba
 * @version v.   08.04.13
 */
public class SurroundTest {
    private Barrier lineAB;
    private Barrier lineBD;
    private Barrier lineDC;
    private Barrier lineCA;
    private Barrier lineBA;
    private Barrier lineCB;
    private Surround surround;

    @Before
    public void init() {
        Dot dotA = new Dot(0, 0, 'x');
        Dot dotB = new Dot(1, 0, 'x');
        Dot dotC = new Dot(0, 1, 'x');
        Dot dotD = new Dot(1, 1, 'x');
        lineAB = new Barrier(dotA, dotB);
        lineBD = new Barrier(dotB, dotD);
        lineDC = new Barrier(dotD, dotC);
        lineCA = new Barrier(dotC, dotA);
        lineBA = new Barrier(dotB, dotA);
        lineCB = new Barrier(dotC, dotB);

        surround = new Surround(lineAB);
    }

    @Test
    public void shouldAddLinesToSurround_whenSurroundCreated() {
        surround.addBarrier(lineBD);
    }

    @Test (expected = IllegalArgumentException.class)
    public void shouldThrowException_WhenAddBadLine() {
        surround.addBarrier(lineDC);
    }

    @Test (expected = IllegalArgumentException.class)
    public void shouldThrowException_WhenAddSameLine() {
        surround.addBarrier(lineBA);
    }

    @Test
    public void shouldSurroundDetectedChicle_whenAddLine(){
        surround.addBarrier(lineBD);
        surround.addBarrier(lineDC);
        assertEquals(-1, surround.addBarrier(lineCB));
    }

    @Test
    public void shouldSurroundDetectedChicleFromStart_whenAddLine(){
        surround.addBarrier(lineBD);
        surround.addBarrier(lineDC);
        assertEquals(1, surround.addBarrier(lineCA));
    }


}

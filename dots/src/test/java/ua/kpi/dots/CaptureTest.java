package ua.kpi.dots;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Myhaylo Kotsyuruba
 * @version v.   08.04.13
 */
public class CaptureTest {
    private Dot dotA;
    private Dot dotB;
    private Dot dotC;
    private Dot dotD;

    private Barrier lineAB;
    private Barrier lineBD;
    private Barrier lineDC;
    private Barrier lineCA;
    private Barrier lineBA;
    private Barrier lineCB;
    private Barrier lineBC;
    private Barrier lineAD;
    private Capture capture;

    @Before
    public void init() {
        dotA = new Dot(0, 0, 'x');
        dotB = new Dot(1, 0, 'x');
        dotC = new Dot(0, 1, 'x');
        dotD = new Dot(1, 1, 'x');
        lineAB = new Barrier(dotA, dotB);
        lineBD = new Barrier(dotB, dotD);
        lineDC = new Barrier(dotD, dotC);
        lineCA = new Barrier(dotC, dotA);
        lineBA = new Barrier(dotB, dotA);
        lineCB = new Barrier(dotC, dotB);
        lineBC = new Barrier(dotB, dotC);
        lineAD = new Barrier(dotA, dotD);

        capture = new Capture(lineAB);
    }

    @Test
    public void shouldAddLinesToSurround_whenSurroundCreated() {
        capture.addBarrier(lineBD);
    }

    @Test (expected = IllegalArgumentException.class)
    public void shouldThrowException_WhenAddBadLine() {
        capture.addBarrier(lineDC);
    }

    @Test (expected = IllegalArgumentException.class)
    public void shouldThrowException_WhenAddSameLine() {
        capture.addBarrier(lineBA);
    }

    @Test
    public void shouldSurroundDetectedCycle_whenAddLine(){
        capture.addBarrier(lineBD);
        capture.addBarrier(lineDC);
        assertEquals(-1, capture.addBarrier(lineCB));
    }

    @Test
    public void shouldSurroundDetectedCycleFromStart_whenAddLine(){
        capture.addBarrier(lineBD);
        capture.addBarrier(lineDC);
        assertEquals(1, capture.addBarrier(lineCA));
    }

    @Test
    public void shouldCheckUsingDots() {
        assertFalse(capture.isUsedWithoutStartDot(dotA));
        assertFalse(capture.isUsedWithoutStartDot(dotC));
        assertTrue(capture.isUsedWithoutStartDot(dotB));
    }

    @Test
    public void shouldCheckCrossingLines() {
        capture = new Capture();
        capture.addBarrier(lineBC);
        assertFalse(capture.isCrossing(lineCB));
        assertTrue(capture.isCrossing(lineAD));
    }

    @Test
    public void shouldCheckForSameSurrond() {
        Capture capture1 = new Capture(lineAB);
        capture1.addBarrier(lineBC);

        Capture capture2 = new Capture(lineCB);
        capture2.addBarrier(lineBA);

        Capture capture3 = new Capture(lineAB);
        capture3.addBarrier(lineBD);


        assertTrue(capture1.isSame(capture1));
        assertTrue(capture1.isSame(capture2));
        assertFalse(capture1.isSame(capture3));
    }
}

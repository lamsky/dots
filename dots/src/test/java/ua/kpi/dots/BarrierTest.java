package ua.kpi.dots;

import org.junit.Test;

/**
 * @author Myhaylo Kotsyuruba
 * @version v.   08.04.13
 */
public class BarrierTest {
    @Test
    public void shouldCreateBarrierFromTwoDots() {
        Dot dotA = new Dot(0, 0, 'x');
        Dot dotB = new Dot(1, 1, 'x');
        new Barrier(dotA, dotB);
    }

    @Test (expected = IllegalArgumentException.class)
    public void shouldThrowException_WhenCreateBarrierFromNoNeighboringDots() {
        Dot dotA = new Dot(0, 0, 'x');
        Dot dotB = new Dot(2, 1, 'x');
        new Barrier(dotA, dotB);
    }

    @Test (expected = IllegalArgumentException.class)
    public void shouldThrowException_WhenCreateBarrierFromSameDots() {
        Dot dotA = new Dot(0, 0, 'x');
        Dot dotB = new Dot(0, 0, 'x');
        new Barrier(dotA, dotB);
    }


}

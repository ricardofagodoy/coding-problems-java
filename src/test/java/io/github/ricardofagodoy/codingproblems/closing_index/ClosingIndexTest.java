package io.github.ricardofagodoy.codingproblems.closing_index;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ClosingIndexTest {

    @Test
    public void testFindClosingIndex() {
        assertEquals(10, ClosingIndex.solve("((1)23(45))(aB)", 0));
        assertEquals(3, ClosingIndex.solve("((1)23(45))(aB)", 1));
        assertEquals(-1, ClosingIndex.solve("((1)23(45))(aB)", 2));
        assertEquals(9, ClosingIndex.solve("((1)23(45))(aB)", 6));
        assertEquals(14, ClosingIndex.solve("((1)23(45))(aB)", 11));
        assertEquals(28, ClosingIndex.solve("(g(At)IO(f)(tM(qk)YF(n)Nr(E)))", 11));
        assertEquals(29, ClosingIndex.solve("(g(At)IO(f)(tM(qk)YF(n)Nr(E)))", 0));
        assertEquals(22, ClosingIndex.solve("(>_(va)`?(h)C(as)(x(hD)P|(fg)))", 19));
    }
}
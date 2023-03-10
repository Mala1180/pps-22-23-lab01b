package e2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LogicsTest {

    public static final int SIZE = 7;
    public static final int NUMBER_OF_MINES = 3;
    private Logics logics;

    @BeforeEach
    void setUp() {
        logics = new LogicsImpl(SIZE);
    }

    @Test
    void testPopulateBoardWithMines() {
        logics.addMine(0, 0);
        logics.addMine(1, 1);
        logics.addMine(5, 5);
        assertTrue(logics.hasMine(0, 0));
        assertTrue(logics.hasMine(1, 1));
        assertTrue(logics.hasMine(5, 5));
    }

    @Test
    void testHitMine() {
        testPopulateBoardWithMines();
        assertFalse(logics.hit(0, 0));
    }

    @Test
    void testHitEmptyCell() {
        testPopulateBoardWithMines();
        assertTrue(logics.hit(2, 2));
    }

}
package e2;

import e2.logics.Logics;
import e2.logics.LogicsImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class LogicsTest {

    public static final int SIZE = 7;
    public static final int NUMBER_OF_MINES = 3;
    private Logics logics;
    public Set<Pair<Integer, Integer>> minePositions;


    @BeforeEach
    void setUp() {
        minePositions = new HashSet<>(Set.of(
                new Pair<>(0, 0),
                new Pair<>(2, 2),
                new Pair<>(5, 5)
        ));
        logics = new LogicsImpl(SIZE, minePositions);
    }

    @Test
    void testGameLost() {
        logics.hit(0, 0);
        assertTrue(logics.isShown(0, 0));
        assertFalse(logics.isGameWon());
    }

    @Test
    void testHitEmptyCellWithAdjacentMines() {
        assertFalse(logics.hit(1, 1));
        assertEquals(2, logics.getAdjacentMinesNumber(1, 1));
        assertTrue(logics.isShown(1, 1));
        assertFalse(logics.hit(5, 4));
        assertEquals(1, logics.getAdjacentMinesNumber(5, 4));
        assertTrue(logics.isShown(5, 4));
    }

    @Test
    void testHitEmptyCellWithNoAdjacentMines() {
        assertFalse(logics.hit(3, 0));
        assertEquals(0, logics.getAdjacentMinesNumber(3, 0));
        assertTrue(logics.isShown(3, 0));
    }

    @Test
    void testGameWon() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (!minePositions.contains(new Pair<>(i, j))) {
                    logics.hit(i, j);
                }
            }
        }
        assertTrue(logics.isGameWon());
    }

    @Test
    void testToggleFlag() {
        assertTrue(logics.toggleFlag(0, 0));
        assertFalse(logics.toggleFlag(0, 0));
        assertTrue(logics.toggleFlag(1, 1));
    }

}
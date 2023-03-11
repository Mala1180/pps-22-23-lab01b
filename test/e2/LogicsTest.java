package e2;

import e2.logics.Logics;
import e2.logics.LogicsImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
    void testHitMine() {
        assertTrue(logics.hit(0, 0));
    }

    @Test
    void testHitEmptyCell() {
        assertFalse(logics.hit(1, 1));
        assertTrue(logics.isShown(1, 1));
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
    void testGameLost() {
        logics.hit(0, 0);
        assertFalse(logics.isGameWon());
    }


}
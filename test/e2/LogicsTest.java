package e2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;

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

    @Test
    void testGetNeighbours() {
        var neighbours = new HashSet<>(List.of(
                new Pair<>(0, 1),
                new Pair<>(1, 0),
                new Pair<>(1, 1)
        ));
        assertEquals(neighbours, logics.getNeighbours(0, 0));

        neighbours = new HashSet<>(List.of(
                new Pair<>(2, 2),
                new Pair<>(2, 3),
                new Pair<>(2, 4),
                new Pair<>(3, 2),
                new Pair<>(3, 4),
                new Pair<>(4, 2),
                new Pair<>(4, 3),
                new Pair<>(4, 4)
        ));

        assertEquals(neighbours, logics.getNeighbours(3, 3));

        neighbours = new HashSet<>(List.of(
                new Pair<>(SIZE - 2, SIZE - 2),
                new Pair<>(SIZE - 2, SIZE - 1),
                new Pair<>(SIZE - 1, SIZE - 2)
        ));
        assertEquals(neighbours, logics.getNeighbours(SIZE - 1, SIZE - 1));

    }

}
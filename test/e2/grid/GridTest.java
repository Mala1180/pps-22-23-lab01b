package e2.grid;

import e2.Pair;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class GridTest {

    public static final int SIZE = 7;
    public static final int NUMBER_OF_MINES = 3;
    private Grid grid;
    public Set<Pair<Integer, Integer>> minePositions;

    @BeforeEach
    void setUp() {
        minePositions = new HashSet<>(Set.of(
                new Pair<>(0, 0),
                new Pair<>(2, 2),
                new Pair<>(5, 5)
        ));
        this.grid = new GridImpl(SIZE, minePositions);
    }

    @Test
    void testPopulateBoardWithMines() {
        assertTrue(this.grid.isMine(0, 0));
        assertTrue(this.grid.isMine(2, 2));
        assertTrue(this.grid.isMine(5, 5));
    }

    @Test
    void testGetNotExistingCell() {
        assertThrows(IllegalArgumentException.class, () -> this.grid.getCell(SIZE, SIZE));
        assertThrows(IllegalArgumentException.class, () -> this.grid.getCell(-1, -1));
    }

    @Test
    void testShowCell() {
        this.grid.showCell(0, 0);
        this.grid.showCell(3, 3);
        assertTrue(this.grid.getCell(0, 0).isShown());
        assertTrue(this.grid.getCell(3, 3).isShown());
    }

    @Test
    void testShowNotExistingCell() {
        assertThrows(IllegalArgumentException.class, () -> this.grid.showCell(SIZE, SIZE));
        assertThrows(IllegalArgumentException.class, () -> this.grid.showCell(-1, -1));
    }

    @Test
    void testGetAdjacent() {
        var neighbours = Set.of(
                new Pair<>(0, 1),
                new Pair<>(1, 0),
                new Pair<>(1, 1)
        );
        assertEquals(neighbours, this.grid.getAdjacent(0, 0));

        neighbours = new HashSet<>(Set.of(
                new Pair<>(2, 2),
                new Pair<>(2, 3),
                new Pair<>(2, 4),
                new Pair<>(3, 2),
                new Pair<>(3, 4),
                new Pair<>(4, 2),
                new Pair<>(4, 3),
                new Pair<>(4, 4)
        ));

        assertEquals(neighbours, this.grid.getAdjacent(3, 3));

        neighbours = new HashSet<>(Set.of(
                new Pair<>(SIZE - 2, SIZE - 2),
                new Pair<>(SIZE - 2, SIZE - 1),
                new Pair<>(SIZE - 1, SIZE - 2)
        ));
        assertEquals(neighbours, this.grid.getAdjacent(SIZE - 1, SIZE - 1));

    }

    @Test
    void testGetAdjacentMines() {
        var adjacentMines = Set.of(
                new Pair<>(0, 0)
        );
        assertEquals(adjacentMines, this.grid.getAdjacentMines(1, 0));

        adjacentMines = Set.of(
                new Pair<>(0, 0),
                new Pair<>(2, 2)
        );
        assertEquals(adjacentMines, this.grid.getAdjacentMines(1, 1));
    }
}
package e2.board;

import e2.Pair;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    public static final int SIZE = 7;
    public static final int NUMBER_OF_MINES = 3;
    private Board board;
    public Set<Pair<Integer, Integer>> minePositions;

    @BeforeEach
    void setUp() {
        minePositions = new HashSet<>(Set.of(
                new Pair<>(0, 0),
                new Pair<>(2, 2),
                new Pair<>(5, 5)
        ));
        this.board = new BoardImpl(SIZE, minePositions);
    }

    @Test
    void testPopulateBoardWithMines() {
        this.board.addMine(0, 0);
        this.board.addMine(1, 1);
        this.board.addMine(5, 5);
        assertTrue(this.board.hasMine(0, 0));
        assertTrue(this.board.hasMine(1, 1));
        assertTrue(this.board.hasMine(5, 5));
    }

    @Test
    void testGetNotExistingCell() {
        assertThrows(IllegalArgumentException.class, () -> this.board.getCell(SIZE, SIZE));
        assertThrows(IllegalArgumentException.class, () -> this.board.getCell(-1, -1));
    }

    @Test
    void testShowCell() {
        this.board.showCell(0, 0);
        this.board.showCell(3, 3);
        assertTrue(this.board.getCell(0, 0).isShown());
        assertTrue(this.board.getCell(3, 3).isShown());
    }

    @Test
    void testShowNotExistingCell() {
        assertThrows(IllegalArgumentException.class, () -> this.board.showCell(SIZE, SIZE));
        assertThrows(IllegalArgumentException.class, () -> this.board.showCell(-1, -1));
    }

    @Test
    void testGetAdjacent() {
        var neighbours = Set.of(
                new Pair<>(0, 1),
                new Pair<>(1, 0),
                new Pair<>(1, 1)
        );
        assertEquals(neighbours, this.board.getAdjacent(0, 0));

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

        assertEquals(neighbours, this.board.getAdjacent(3, 3));

        neighbours = new HashSet<>(Set.of(
                new Pair<>(SIZE - 2, SIZE - 2),
                new Pair<>(SIZE - 2, SIZE - 1),
                new Pair<>(SIZE - 1, SIZE - 2)
        ));
        assertEquals(neighbours, this.board.getAdjacent(SIZE - 1, SIZE - 1));

    }

    @Test
    void testGetAdjacentMines() {
        var adjacentMines = Set.of(
                new Pair<>(0, 0)
        );
        assertEquals(adjacentMines, this.board.getAdjacentMines(1, 0));

        adjacentMines = Set.of(
                new Pair<>(0, 0),
                new Pair<>(2, 2)
        );
        assertEquals(adjacentMines, this.board.getAdjacentMines(1, 1));
    }
}
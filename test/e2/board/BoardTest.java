package e2.board;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    public static final int SIZE = 7;
    public static final int NUMBER_OF_MINES = 3;
    private Board board;
    @BeforeEach
    void setUp() {
        this.board = new BoardImpl(SIZE);
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
    void testShowCell() {
        this.board.showCell(0, 0);
        assertTrue(this.board.getCells().stream()
                .filter(cell -> cell.getX() == 0 && cell.getY() == 0)
                .findFirst()
                .get()
                .isShown());
    }

    @Test
    void testGetNeighbours() {
        var neighbours = Set.of(
                new Cell(0, 1),
                new Cell(1, 0),
                new Cell(1, 1)
        );
        assertEquals(neighbours, this.board.getNeighboursOf(0, 0));

        neighbours = new HashSet<>(List.of(
                new Cell(2, 2),
                new Cell(2, 3),
                new Cell(2, 4),
                new Cell(3, 2),
                new Cell(3, 4),
                new Cell(4, 2),
                new Cell(4, 3),
                new Cell(4, 4)
        ));

        assertEquals(neighbours, this.board.getNeighboursOf(3, 3));

        neighbours = new HashSet<>(List.of(
                new Cell(SIZE- 2, SIZE - 2),
                new Cell(SIZE - 2, SIZE - 1),
                new Cell(SIZE - 1, SIZE - 2)
        ));
        assertEquals(neighbours, this.board.getNeighboursOf(SIZE - 1, SIZE - 1));

    }
}
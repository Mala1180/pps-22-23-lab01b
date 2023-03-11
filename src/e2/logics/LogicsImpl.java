package e2.logics;

import e2.Pair;
import e2.board.Board;
import e2.board.BoardImpl;
import e2.board.Cell;

import java.util.Set;

public class LogicsImpl implements Logics {

    private final Board board;

    public LogicsImpl(int size) {
        this.board = new BoardImpl(size);
    }

    public LogicsImpl(int size, Set<Pair<Integer, Integer>> minePositions) {
        this.board = new BoardImpl(size, minePositions);
    }

    public LogicsImpl(int size, int numberOfMines) {
        this.board = new BoardImpl(size, numberOfMines);
    }

    @Override
    public boolean hit(int x, int y) {
        this.board.showCell(x, y);
        if (!this.board.hasMine(x, y)) {
            if (this.getAdjacentMinesNumber(x, y) == 0) {
                this.board.getAdjacent(x, y).forEach(adjacent -> {
                    int adjacentX = adjacent.getX();
                    int adjacentY = adjacent.getY();
                    if (!this.isShown(adjacentX, adjacentY) &&
                            !this.isMine(adjacentX, adjacentY) &&
                            !this.isFlag(adjacentX, adjacentY)) {
                        this.hit(adjacentX, adjacentY);
                    }
                });
            }
            return false;
        }
        return true;
    }

    @Override
    public boolean isGameWon() {
        return this.board.getCells().stream()
                .filter(Cell::isMine)
                .anyMatch(cell -> !cell.isShown()) &&
                this.board.getCells().stream()
                        .filter(cell -> !cell.isMine())
                        .allMatch(Cell::isShown);
    }

    @Override
    public boolean isMine(int x, int y) {
        return this.board.hasMine(x, y);
    }

    @Override
    public boolean isShown(int x, int y) {
        return this.board.getCell(x, y).isShown();
    }

    @Override
    public int getAdjacentMinesNumber(int x, int y) {
        return this.board.getAdjacentMines(x, y).size();
    }

    @Override
    public boolean toggleFlag(int x, int y) {
        this.board.toggleFlag(x, y);
        return this.isFlag(x, y);
    }

    @Override
    public boolean isFlag(int x, int y) {
        return this.board.getCell(x, y).isFlag();
    }

}

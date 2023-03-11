package e2.logics;

import e2.Pair;
import e2.board.Board;
import e2.board.BoardImpl;
import e2.board.Cell;

import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

public class LogicsImpl implements Logics {

    private final Board board;

    public LogicsImpl(int size) {
        this.board = new BoardImpl(size);
    }

    public LogicsImpl(int size, int numberOfMines) {
        this.board = new BoardImpl(size);
        Random random = new Random();
        for (int i = 0; i < numberOfMines; i++) {
            int x = random.nextInt(size);
            int y = random.nextInt(size);
            this.board.addMine(x, y);
        }
    }

    public LogicsImpl(int size, Set<Pair<Integer, Integer>> minePositions) {
        this.board = new BoardImpl(size);
        for (var mine : minePositions) {
            this.board.addMine(mine.getX(), mine.getY());
        }
    }

    @Override
    public boolean hit(int x, int y) {
        this.board.showCell(x, y);
        if (!this.board.hasMine(x, y)) {
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
    public String getLabel(int x, int y) {
        return null;
    }

}

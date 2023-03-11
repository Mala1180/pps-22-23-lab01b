package e2.logics;

import e2.board.Board;
import e2.board.BoardImpl;
import e2.board.Cell;

import java.util.Random;

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

    @Override
    public boolean hit(int x, int y) {
        if (!this.board.hasMine(x, y)) {
            this.board.showCell(x, y);
            return false;
        }
        return true;
    }

    @Override
    public boolean isGameWon() {
        return this.board.getCells().stream()
                .filter(cell -> !cell.isMine())
                .allMatch(Cell::isShown);
    }

    @Override
    public boolean isMine(int x, int y) {
        return this.board.hasMine(x, y);
    }

}

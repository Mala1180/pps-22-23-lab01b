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
    public boolean hit(int i, int j) {
        if (!this.board.hasMine(i, j)) {
            this.board.showCell(i, j);
            return true;
        }
        return false;
    }

    @Override
    public boolean isGameWon() {
        return this.board.getCells().stream()
                .filter(cell -> !cell.isMine())
                .allMatch(Cell::isShown);
    }

}

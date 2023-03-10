package e2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LogicsImpl implements Logics {

    private final Set<Pair<Integer, Integer>> board = new HashSet<>();
    private final Set<Pair<Integer, Integer>> mines = new HashSet<>();

    public LogicsImpl(int size) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board.add(new Pair<>(i, j));
            }
        }
    }

    public LogicsImpl(int size, int numberOfMines) {
    }

    @Override
    public void addMine(int i, int j) {
        this.mines.add(new Pair<>(i, j));
    }

    @Override
    public boolean hasMine(int i, int j) {
        return this.mines.contains(new Pair<>(i, j));
    }
}

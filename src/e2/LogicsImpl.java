package e2;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

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

    @Override
    public boolean hit(int i, int j) {
        if (!this.hasMine(i, j)) {
            this.board.remove(new Pair<>(i, j));
            return true;
        }
        return false;
    }

    @Override
    public Set<Pair<Integer, Integer>> getNeighbours(int i, int j) {
        return this.board.stream().filter(pair -> {
            int x = pair.getX();
            int y = pair.getY();
            return !(x == i && y == j) &&
                    (x == i - 1 || x == i || x == i + 1) &&
                    (y == j - 1 || y == j || y == j + 1);
        }).collect(Collectors.toUnmodifiableSet());
    }
}

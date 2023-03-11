package e2.board;

import e1.Pair;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class BoardImpl implements Board {

    private final Map<Pair<Integer, Integer>, Cell> cells = new HashMap<>();

    public BoardImpl(int size) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                this.cells.put(new Pair<>(i, j), new Cell(false));
            }
        }
    }

    @Override
    public Set<Cell> getCells() {
        return new HashSet<>(this.cells.values());
    }

    @Override
    public Cell getCell(final int i, final int j) {
        if (this.cells.containsKey(new Pair<>(i, j))) {
            return this.cells.get(new Pair<>(i, j));
        } else {
            throw new IllegalArgumentException("Cell not found");
        }
    }

    @Override
    public void showCell(int i, int j) {
        if (this.cells.containsKey(new Pair<>(i, j))) {
            this.cells.get(new Pair<>(i, j)).show();
        } else {
            throw new IllegalArgumentException("Cell not found");
        }

    }

    @Override
    public void addMine(int i, int j) {
        this.cells.get(new Pair<>(i, j)).setMine(true);
    }

    @Override
    public boolean hasMine(int i, int j) {
        return this.cells.get(new Pair<>(i, j)).isMine();
    }

    @Override
    public Set<Pair<Integer, Integer>> getNeighboursOf(int i, int j) {
        return this.cells.keySet().stream().filter(cell -> {
                    int x = cell.getX();
                    int y = cell.getY();
                    return !(x == i && y == j) &&
                            (x == i - 1 || x == i || x == i + 1) &&
                            (y == j - 1 || y == j || y == j + 1);
                })
                .collect(Collectors.toUnmodifiableSet());
    }

}

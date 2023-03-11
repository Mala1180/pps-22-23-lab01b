package e2.board;

import e2.Pair;

import java.util.*;
import java.util.stream.Collectors;

public class BoardImpl implements Board {

    private final Map<Pair<Integer, Integer>, Cell> cells = new HashMap<>();

    private void populateCells(int size) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                this.cells.put(new Pair<>(i, j), new Cell(false));
            }
        }
    }

    public BoardImpl(int size, int numberOfMines) {
        populateCells(size);
        Random random = new Random();
        for (int i = 0; i < numberOfMines; i++) {
            int x = random.nextInt(size);
            int y = random.nextInt(size);
            this.addMine(x, y);
        }
    }

    public BoardImpl(int size) {
        populateCells(size);
    }

    public BoardImpl(int size, Set<e2.Pair<Integer, Integer>> minePositions) {
        populateCells(size);
        for (var mine : minePositions) {
            this.addMine(mine.getX(), mine.getY());
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
    public Set<Pair<Integer, Integer>> getAdjacentMines(int x, int y) {
        return this.cells.entrySet().stream()
                .filter(entry -> entry.getValue().isMine())
                .filter(entry -> {
                    int cellX = entry.getKey().getX();
                    int cellY = entry.getKey().getY();
                    return !(cellX == x && cellY == y) &&
                            (cellX == x - 1 || cellX == x || cellX == x + 1) &&
                            (cellY == y - 1 || cellY == y || cellY == y + 1);
                })
                .map(Map.Entry::getKey)
                .collect(Collectors.toUnmodifiableSet());
    }


}

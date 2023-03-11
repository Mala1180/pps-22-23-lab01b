package e2.board;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class BoardImpl implements Board {

    private final Set<Cell> cells = new HashSet<>();

    public BoardImpl(int size) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                this.cells.add(new Cell(i, j));
            }
        }
    }

    @Override
    public void addMine(int i, int j) {
        this.cells.stream()
                .filter(cell -> cell.getX() == i && cell.getY() == j)
                .findFirst()
                .ifPresent(cell -> cell.setMine(true));
    }

    @Override
    public boolean hasMine(int i, int j) {
        return this.cells.stream()
                .filter(cell -> cell.getX() == i && cell.getY() == j)
                .findFirst()
                .map(Cell::isMine)
                .orElse(false);
    }

    @Override
    public Set<Cell> getNeighboursOf(int i, int j) {
        return this.cells.stream().filter(pair -> {
            int x = pair.getX();
            int y = pair.getY();
            return !(x == i && y == j) &&
                    (x == i - 1 || x == i || x == i + 1) &&
                    (y == j - 1 || y == j || y == j + 1);
        }).collect(Collectors.toUnmodifiableSet());
    }

    @Override
    public void showCell(int i, int j) {
        this.cells.stream().filter(cell -> cell.getX() == i && cell.getY() == j)
                .findFirst()
                .ifPresent(cell -> cell.setShown(true));
    }

    @Override
    public Set<Cell> getCells() {
        return this.cells;
    }
}

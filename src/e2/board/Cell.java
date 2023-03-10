package e2.board;

import e1.Pair;

import java.util.Objects;

public class Cell {

    private final Pair<Integer, Integer> position;
    private boolean isMine;

    public Cell(int x, int y) {
        this.position = new Pair<>(x, y);
        this.isMine = false;
    }

    public boolean isMine() {
        return isMine;
    }

    public void setMine(boolean isMine) {
        this.isMine = isMine;
    }

    public int getX() {
        return this.position.getX();
    }

    public int getY() {
        return this.position.getY();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cell cell = (Cell) o;
        return Objects.equals(position, cell.position);
    }

}

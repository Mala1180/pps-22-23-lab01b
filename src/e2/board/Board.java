package e2.board;

import java.util.Set;

public interface Board {

    void addMine(int i, int j);

    boolean hasMine(int i, int j);

    Set<Cell> getNeighboursOf(int i, int j);

    void showCell(int i, int j);
}

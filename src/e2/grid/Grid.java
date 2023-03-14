package e2.grid;

import e2.Pair;
import e2.grid.cell.Cell;

import java.util.Set;

public interface Grid {

    Set<Cell> getCells();

    Cell getCell(int i, int j);

    void showCell(int i, int j);

    boolean isMine(int i, int j);

    Set<Pair<Integer, Integer>> getAdjacent(int x, int y);

    Set<Pair<Integer, Integer>> getAdjacentMines(int x, int y);

    void toggleFlag(int x, int y);
}

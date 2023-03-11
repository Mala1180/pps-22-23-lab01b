package e2.board;

import e2.Pair;
import e2.board.cell.CellImpl;

import java.util.Set;

public interface Grid {

    Set<CellImpl> getCells();

    CellImpl getCell(int i, int j);

    void showCell(int i, int j);

    boolean hasMine(int i, int j);

    Set<Pair<Integer, Integer>> getAdjacent(int x, int y);

    Set<Pair<Integer, Integer>> getAdjacentMines(int x, int y);

    void toggleFlag(int x, int y);
}

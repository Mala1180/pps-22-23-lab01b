package e2.board;

import e2.Pair;

import java.util.Set;

public interface Board {

    Set<Cell> getCells();

    Cell getCell(int i, int j);

    void showCell(int i, int j);

    void addMine(int i, int j);

    boolean hasMine(int i, int j);

    Set<Pair<Integer, Integer>> getAdjacent(int x, int y);

    Set<Pair<Integer, Integer>> getAdjacentMines(int x, int y);

    void toggleFlag(int x, int y);
}

package e2.board;

import e1.Pair;

import java.util.Set;

public interface Board {

    Set<Cell> getCells();

    Cell getCell(int i, int j);

    void showCell(int i, int j);

    void addMine(int i, int j);

    boolean hasMine(int i, int j);

    Set<Pair<Integer, Integer>> getNeighboursOf(int i, int j);

}

package e2;

import java.util.Set;

public interface Logics {

    void addMine(int i, int j);

    boolean hasMine(int i, int j);

    boolean hit(int i, int j);

    Set<Pair<Integer, Integer>> getNeighbours(int i, int j);
}

package e1.movement;

import e1.Pair;

public interface MovementStrategy {

    /**
     * attempt to move Knight on position row,col, if possible
     *
     * @param from
     * @param to
     * @return true if the movement is performed, false otherwise
     */
    boolean canMove(Pair<Integer, Integer> from, Pair<Integer, Integer> to) throws IndexOutOfBoundsException;

}

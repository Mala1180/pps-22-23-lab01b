package e1.movement;

import e1.Pair;

public interface MovementLogic {

    /**
     * attempt to move Knight on position row,col, if possible
     *
     * @param row
     * @param col
     * @return true if the movement is performed, false otherwise
     */
    void move(int row, int col);


    /**
     * Provides the knight position.
     * @return the knight position
     */
    Pair<Integer, Integer> getPosition();

}

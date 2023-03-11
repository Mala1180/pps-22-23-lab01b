package e2.logics;

public interface Logics {

    /**
     * @param x row
     * @param y column
     * @return false if the cell is empty, true if it is a mine
     */
    boolean hit(int x, int y);

    /**
     * @return true if all cells except mines are shown, false otherwise
     */
    boolean isGameWon();

    boolean isMine(int x, int y);
}

package e2;

public interface Logics {

    /**
     * @param i row
     * @param j column
     * @return false if the cell is empty, true if it is a mine
     */
    boolean hit(int i, int j);

    /**
     * @return true if all cells except mines are shown, false otherwise
     */
    boolean isGameWon();
}

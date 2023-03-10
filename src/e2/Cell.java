package e2;

public class Cell {

    private int i;
    private int j;
    private boolean isMine;

    public Cell(int i, int j, boolean isMine) {
        this.i = i;
        this.j = j;
        this.isMine = isMine;
    }

    public boolean isMine() {
        return isMine;
    }

}

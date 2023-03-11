package e2.board;

import e1.Pair;

public class Cell extends Pair<Integer, Integer> {

    private boolean isShown;
    private boolean isMine;

    public Cell(int x, int y) {
        super(x, y);
        this.isMine = false;
        this.isShown = false;
    }

    public boolean isMine() {
        return isMine;
    }

    public void setMine(final boolean isMine) {
        this.isMine = isMine;
    }

    public boolean isShown() {
        return isShown;
    }

    public void setShown(final boolean isShown) {
        this.isShown = isShown;
    }

}

package e2.board;

public class Cell {

    private boolean isShown;
    private boolean isMine;
    private String label;

    public Cell(final boolean isMine) {
        this.isMine = isMine;
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

    public void show() {
        this.isShown = true;
    }

    @Override
    public String toString() {
        return "Cell{" +
                "isShown=" + isShown +
                ", isMine=" + isMine +
                ", label='" + label + '\'' +
                '}';
    }
}

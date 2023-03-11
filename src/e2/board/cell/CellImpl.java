package e2.board.cell;

public class CellImpl implements Cell {

    private boolean isShown;
    private final boolean isMine;
    private boolean isFlag;

    public CellImpl(final boolean isMine) {
        this.isMine = isMine;
        this.isShown = false;
        this.isFlag = false;
    }

    @Override
    public boolean isMine() {
        return isMine;
    }

    @Override
    public boolean isShown() {
        return isShown;
    }

    @Override
    public void show() {
        this.isShown = true;
    }

    @Override
    public boolean isFlag() {
        return this.isFlag;
    }

    @Override
    public void setFlag(boolean isFlag) {
        this.isFlag = isFlag;
    }

    @Override
    public String toString() {
        return "Cell{" +
                "isShown=" + isShown +
                ", isMine=" + isMine +
                ", isFlag='" + isFlag + '\'' +
                '}';
    }
}

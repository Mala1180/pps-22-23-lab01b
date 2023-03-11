package e2.grid.cell;

public interface Cell {

    boolean isMine();

    boolean isShown();

    void show();

    boolean isFlag();

    void setFlag(boolean isFlag);
}

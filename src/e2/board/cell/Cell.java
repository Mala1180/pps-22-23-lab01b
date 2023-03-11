package e2.board.cell;

public interface Cell {

    boolean isMine();

    boolean isShown();

    void show();

    boolean isFlag();

    void setFlag(boolean isFlag);
}

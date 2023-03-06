package e1.movement;

import e1.Pair;

public class KnightMovementLogic implements MovementLogic {

    private final int size;

    public KnightMovementLogic(int size) {
        this.size = size;
    }

    @Override
    public boolean canMove(Pair<Integer, Integer> from, Pair<Integer, Integer> to) {
        int row = from.getX();
        int col = from.getY();
        if (row < 0 || col < 0 || row >= this.size || col >= this.size) {
            throw new IndexOutOfBoundsException();
        }
        int x = row - to.getX();
        int y = col - to.getY();
        return x != 0 && y != 0 && Math.abs(x) + Math.abs(y) == 3;
    }

}

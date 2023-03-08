package e1.movement;

import e1.Pair;

public class KnightMovementStrategy implements MovementStrategy {

    private final int size;

    public KnightMovementStrategy(int size) {
        this.size = size;
    }

    @Override
    public boolean canMove(Pair<Integer, Integer> from, Pair<Integer, Integer> to) {
        int row = to.getX();
        int col = to.getY();
        if (row < 0 || col < 0 || row >= this.size || col >= this.size) {
            throw new IndexOutOfBoundsException();
        }
        int x = row - from.getX();
        int y = col - from.getY();
        return x != 0 && y != 0 && Math.abs(x) + Math.abs(y) == 3;
    }

}

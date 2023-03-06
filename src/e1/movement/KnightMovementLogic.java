package e1.movement;

import e1.Pair;

public class KnightMovementLogic implements MovementLogic {

    private final int size;
    private Pair<Integer, Integer> knightPosition;


    public KnightMovementLogic(int size, Pair<Integer, Integer> knightStartingPosition) {
        this.size = size;
        this.knightPosition = knightStartingPosition;
    }

    @Override
    public boolean move(int row, int col) {
        if (row < 0 || col < 0 || row >= this.size || col >= this.size) {
            throw new IndexOutOfBoundsException();
        }
        int x = row - this.knightPosition.getX();
        int y = col - this.knightPosition.getY();
        System.out.println("x: " + x + " y:" + y);
        if (x != 0 && y != 0 && Math.abs(x) + Math.abs(y) == 3) {
            this.knightPosition = new Pair<>(row, col);
            return true;
        }
        return false;
    }

    @Override
    public Pair<Integer, Integer> getPosition() {
        return this.knightPosition;
    }
}

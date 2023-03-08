package e1;

import e1.movement.KnightMovementStrategy;
import e1.movement.MovementStrategy;

import java.util.*;

public class LogicsImpl implements Logics {

    private final Pair<Integer, Integer> pawn;
    private Pair<Integer, Integer> knight;

    private final Random random = new Random();
    private final MovementStrategy movementStrategy;
    private final int size;

    public LogicsImpl(int size) {
        this.size = size;
        this.pawn = this.randomEmptyPosition();
        this.knight = this.randomEmptyPosition();
        movementStrategy = new KnightMovementStrategy(size);
    }

    public LogicsImpl(int size, Pair<Integer, Integer> knightStartingPosition, Pair<Integer, Integer> pawnStartingPosition) {
        this.size = size;
        this.pawn = pawnStartingPosition;
        this.knight = knightStartingPosition;
        movementStrategy = new KnightMovementStrategy(size);
    }

    private final Pair<Integer, Integer> randomEmptyPosition() {
        Pair<Integer, Integer> pos = new Pair<>(this.random.nextInt(size), this.random.nextInt(size));
        // the recursive call below prevents clash with an existing pawn
        return this.pawn != null && this.pawn.equals(pos) ? randomEmptyPosition() : pos;
    }

    @Override
    public boolean hit(int row, int col) {
        if (this.movementStrategy.canMove(this.knight, new Pair<>(row, col))) {
            this.knight = new Pair<>(row, col);
            return this.pawn.equals(this.getKnightPosition());
        }
        return false;
    }

    @Override
    public boolean hasKnight(int row, int col) {
        return this.getKnightPosition().equals(new Pair<>(row, col));
    }

    @Override
    public boolean hasPawn(int row, int col) {
        return this.pawn.equals(new Pair<>(row, col));
    }

    @Override
    public Pair<Integer, Integer> getKnightPosition() {
        return this.knight;
    }
}

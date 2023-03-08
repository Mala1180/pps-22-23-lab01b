package test.e1;

import e1.Pair;
import e1.movement.KnightMovementStrategy;
import e1.movement.MovementStrategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MovementStrategyTest {

    public static final int SIZE = 5;
    public static final Pair<Integer, Integer> knightStartingPosition = new Pair<>(0, 0);

    protected MovementStrategy movementStrategy = (from, to) -> {
        throw new IndexOutOfBoundsException();
    };

    @Test
    void testOutOfBoundsMovement() {
        assertThrows(IndexOutOfBoundsException.class, () ->
                this.movementStrategy.canMove(knightStartingPosition, new Pair<>(-1, -1)));
        assertThrows(IndexOutOfBoundsException.class, () ->
                this.movementStrategy.canMove(knightStartingPosition, new Pair<>(-1, 4)));
        assertThrows(IndexOutOfBoundsException.class, () ->
                this.movementStrategy.canMove(knightStartingPosition, new Pair<>(-1, -2)));
        assertThrows(IndexOutOfBoundsException.class, () ->
                this.movementStrategy.canMove(knightStartingPosition, new Pair<>(SIZE + 1, SIZE + 1)));
    }

    static class KnightMovementStrategyTest extends MovementStrategyTest {

        @BeforeEach
        void setUp() {
            movementStrategy = new KnightMovementStrategy(SIZE);
        }

        @Test
        void testRightKnightMovement() {
            assertTrue(movementStrategy.canMove(knightStartingPosition, new Pair<>(1, 2)));
            assertTrue(movementStrategy.canMove(new Pair<>(1, 2), new Pair<>(2, 4)));
        }

        @Test
        void testWrongKnightMovement() {
            assertFalse(movementStrategy.canMove(knightStartingPosition, new Pair<>(1, 1)));
            assertFalse(movementStrategy.canMove(knightStartingPosition, new Pair<>(1, 4)));
            assertFalse(movementStrategy.canMove(knightStartingPosition, new Pair<>(3, 2)));
        }

    }
}
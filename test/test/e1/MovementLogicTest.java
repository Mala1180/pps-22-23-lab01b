package test.e1;

import e1.Pair;
import e1.movement.KnightMovementLogic;
import e1.movement.MovementLogic;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MovementLogicTest {

    public static final int SIZE = 5;
    public static final Pair<Integer, Integer> knightStartingPosition = new Pair<>(0, 0);

    protected MovementLogic movementLogic = (from, to) -> {
        throw new IndexOutOfBoundsException();
    };

    @Test
    void testOutOfBoundsMovement() {
        assertThrows(IndexOutOfBoundsException.class, () ->
                this.movementLogic.canMove(knightStartingPosition, new Pair<>(-1, -1)));
        assertThrows(IndexOutOfBoundsException.class, () ->
                this.movementLogic.canMove(knightStartingPosition, new Pair<>(-1, 4)));
        assertThrows(IndexOutOfBoundsException.class, () ->
                this.movementLogic.canMove(knightStartingPosition, new Pair<>(-1, -2)));
        assertThrows(IndexOutOfBoundsException.class, () ->
                this.movementLogic.canMove(knightStartingPosition, new Pair<>(SIZE + 1, SIZE + 1)));
    }

    static class KnightMovementLogicTest extends MovementLogicTest {

        @BeforeEach
        void setUp() {
            movementLogic = new KnightMovementLogic(SIZE);
        }

        @Test
        void testRightKnightMovement() {
            assertTrue(movementLogic.canMove(knightStartingPosition, new Pair<>(1, 2)));
            assertTrue(movementLogic.canMove(new Pair<>(1, 2), new Pair<>(2, 4)));
        }

        @Test
        void testWrongKnightMovement() {
            assertFalse(movementLogic.canMove(knightStartingPosition, new Pair<>(1, 1)));
            assertFalse(movementLogic.canMove(knightStartingPosition, new Pair<>(1, 4)));
            assertFalse(movementLogic.canMove(knightStartingPosition, new Pair<>(3, 2)));
        }

    }
}
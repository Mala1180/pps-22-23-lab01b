package test.e1;

import e1.Pair;
import e1.movement.KnightMovementLogic;
import e1.movement.MovementLogic;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MovementLogicTest {

    public static final int SIZE = 5;
    public static final Pair<Integer, Integer> knightStartingPosition = new Pair<>(0, 0);

    protected MovementLogic movementLogic = new MovementLogic() {
        @Override
        public boolean move(int row, int col) {
            throw new IndexOutOfBoundsException();
        }

        @Override
        public Pair<Integer, Integer> getPosition() {
            return new Pair<>(0, 0);
        }
    };

    @Test
    void testOutOfBoundsMovement() {
        assertThrows(IndexOutOfBoundsException.class, () -> this.movementLogic.move(-1, -1));
        assertEquals(new Pair<>(0, 0), this.movementLogic.getPosition());
        assertThrows(IndexOutOfBoundsException.class, () -> this.movementLogic.move(-1, 4));
        assertEquals(new Pair<>(0, 0), this.movementLogic.getPosition());
        assertThrows(IndexOutOfBoundsException.class, () -> this.movementLogic.move(-1, -2));
        assertEquals(new Pair<>(0, 0), this.movementLogic.getPosition());
        assertThrows(IndexOutOfBoundsException.class, () -> this.movementLogic.move(SIZE + 1, SIZE + 1));
        assertEquals(new Pair<>(0, 0), this.movementLogic.getPosition());
    }

    static class KnightMovementLogicTest extends MovementLogicTest {

        @BeforeEach
        void setUp() {
            movementLogic = new KnightMovementLogic(SIZE, knightStartingPosition);
        }

        @Test
        void testRightKnightMovement() {
            movementLogic.move(1, 2);
            assertEquals(new Pair<>(1, 2), movementLogic.getPosition());
            movementLogic.move(2, 4);
            assertEquals(new Pair<>(2, 4), movementLogic.getPosition());
        }

        @Test
        void testWrongKnightMovement() {
            movementLogic.move(1, 1);
            assertEquals(knightStartingPosition, movementLogic.getPosition());
            movementLogic.move(1, 4);
            assertEquals(knightStartingPosition, movementLogic.getPosition());
            movementLogic.move(3, 2);
            assertEquals(knightStartingPosition, movementLogic.getPosition());
        }

    }
}
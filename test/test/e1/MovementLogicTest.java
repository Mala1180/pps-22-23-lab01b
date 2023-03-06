package test.e1;

import e1.Pair;
import e1.movement.MovementLogic;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MovementLogicTest {

    public static final int SIZE = 5;

    private MovementLogic movementLogic;

    @Test
    void testOutOfBoundsMovement() {
        this.movementLogic.move(-1, -1);
        assertEquals(new Pair<>(0, 0), this.movementLogic.getPosition());
        this.movementLogic.move(-1, 4);
        assertEquals(new Pair<>(0, 0), this.movementLogic.getPosition());
        this.movementLogic.move(-1, -2);
        assertEquals(new Pair<>(0, 0), this.movementLogic.getPosition());
        this.movementLogic.move(SIZE + 1, SIZE + 1);
        assertEquals(new Pair<>(0, 0), this.movementLogic.getPosition());
    }


}
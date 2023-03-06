package test.e1;

import e1.Logics;
import e1.LogicsImpl;
import e1.Pair;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LogicsTest {

    public static final int SIZE = 5;
    public static final Pair<Integer, Integer> knightStartingPosition = new Pair<>(0, 0);
    public static final Pair<Integer, Integer> pawnStartingPosition = new Pair<>(3, 3);

    private Logics logics;

    @BeforeEach
    void setUp() {
        this.logics = new LogicsImpl(SIZE, knightStartingPosition, pawnStartingPosition);
    }

    @Test
    void testRightKnightMovement() {
        assertTrue(this.logics.hit(1,2));
        assertTrue(this.logics.hit(2,4));
    }

    @Test
    void testWrongKnightMovement() {
        assertFalse(this.logics.hit(1,1));
        assertFalse(this.logics.hit(1,4));
        assertFalse(this.logics.hit(3,2));
    }
}
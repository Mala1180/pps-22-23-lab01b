package test.e1;

import e1.Logics;
import e1.LogicsImpl;
import e1.Pair;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LogicsTest {

    public static final int SIZE = 5;
    public static final Pair<Integer, Integer> knightStartingPosition = new Pair<>(0, 0);
    public static final Pair<Integer, Integer> pawnStartingPosition = new Pair<>(2, 4);

    private Logics logics;

    @BeforeEach
    void setUp() {
        this.logics = new LogicsImpl(SIZE, knightStartingPosition, pawnStartingPosition);
    }

    @Test
    void testRightKnightMovement() {
        this.logics.hit(1, 2);
        assertEquals(new Pair<>(1, 2), this.logics.getKnightPosition());
        this.logics.hit(2, 4);
        assertEquals(new Pair<>(2, 4), this.logics.getKnightPosition());
    }

    @Test
    void testWrongKnightMovement() {
        this.logics.hit(1, 1);
        assertEquals(knightStartingPosition, this.logics.getKnightPosition());
        this.logics.hit(1, 4);
        assertEquals(knightStartingPosition, this.logics.getKnightPosition());
        this.logics.hit(3, 2);
        assertEquals(knightStartingPosition, this.logics.getKnightPosition());
        assertThrows(IndexOutOfBoundsException.class, () -> this.logics.hit(-1, -1));
    }

    @Test
    void testKnightTakesPawn() {
        assertFalse(this.logics.hit(1, 2));
        assertTrue(this.logics.hit(2, 4));
    }
}
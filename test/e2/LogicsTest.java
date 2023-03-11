package e2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LogicsTest {

    public static final int SIZE = 7;
    public static final int NUMBER_OF_MINES = 3;
    private Logics logics;

    @BeforeEach
    void setUp() {
        logics = new LogicsImpl(SIZE);
    }

    @Test
    void testGameWon() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.println(logics.hit(i, j));
            }
        }
        assertFalse(logics.isGameWon());
    }


//    @Test
//    void testHitMine() {
//        assertFalse(logics.hit(0, 0));
//    }
//
//    @Test
//    void testHitEmptyCell() {
//        assertTrue(logics.hit(2, 2));
//    }


}
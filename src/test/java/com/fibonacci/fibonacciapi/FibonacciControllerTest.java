package com.fibonacci.fibonacciapi;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FibonacciControllerTest {

    FibonacciController tested = new FibonacciController();

    @Test
    public void testNextTiming() {

        long current = System.currentTimeMillis();
        long timeTaken;

        for(int i = 0; i < 3000; i++){
            tested.next();
        }

        timeTaken = System.currentTimeMillis() - current;

        System.out.println("Time taken to compute it : " + timeTaken + " milliseconds");
    }

    @Test
    public void testPreviousTiming() {

        long current = System.currentTimeMillis();
        long timeTaken;

        for(int i = 0; i < 3000; i++){
            tested.previous();
        }

        timeTaken = System.currentTimeMillis() - current;

        System.out.println("Time taken to compute it : " + timeTaken + " milliseconds");

    }

    @Test
    void testFibonacci() {
        assertEquals(0, tested.fibonacci(0));
        assertEquals(1, tested.fibonacci(1));
        assertEquals(1, tested.fibonacci(2));
        assertEquals(2, tested.fibonacci(3));
        assertEquals(3, tested.fibonacci(4));
        assertEquals(5, tested.fibonacci(5));
        assertEquals(8, tested.fibonacci(6));
        assertEquals(13, tested.fibonacci(7));
        assertEquals(21, tested.fibonacci(8));
        assertEquals(34, tested.fibonacci(9));
        assertEquals(832040, tested.fibonacci(30));
        assertEquals(102_334_155, tested.fibonacci(40));
    }

}
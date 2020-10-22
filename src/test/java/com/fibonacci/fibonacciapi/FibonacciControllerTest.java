package com.fibonacci.fibonacciapi;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FibonacciControllerTest {

    FibonacciController tested = new FibonacciController();

    @Test
    void testCurrent() {

    }

    @Test
    void testNext() {

        long current;
        long timeTaken;

        current = System.currentTimeMillis();

        for(int i = 0; i < 10000; i++){
            long next = tested.next();
        }

        timeTaken = System.currentTimeMillis() - current;
        System.out.println("Time taken to compute it : " + timeTaken + " milliseconds");
    }

    @Test
    void testPrevious() {

    }
}
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

        long current = System.currentTimeMillis();
        long timeTaken;

        for(int i = 0; i < 3000; i++){
            tested.next();
        }

        timeTaken = System.currentTimeMillis() - current;

        System.out.println("Time taken to compute it : " + timeTaken + " milliseconds");
    }

    @Test
    void testPrevious() {

        long current = System.currentTimeMillis();
        long timeTaken;

        for(int i = 0; i < 3000; i++){
            tested.previous();
        }

        timeTaken = System.currentTimeMillis() - current;

        System.out.println("Time taken to compute it : " + timeTaken + " milliseconds");

    }
}
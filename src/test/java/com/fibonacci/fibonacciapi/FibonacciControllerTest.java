package com.fibonacci.fibonacciapi;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.*;

class FibonacciControllerTest {

    private static final Logger LOG = LoggerFactory.getLogger(FibonacciControllerTest.class);

    FibonacciController tested = new FibonacciController();

    @Test
    public void testNextTiming() {

        long current = System.currentTimeMillis();
        long timeTaken;
        long ops = 10000;

        for(int i = 0; i < ops; i++){
            tested.next();
        }

        timeTaken = System.currentTimeMillis() - current;

        LOG.info("Time taken to compute fibonanci {} NEXT ops | {} milliseconds", ops, timeTaken);
    }

    @Test
    public void testPreviousTiming() {

        long current = System.currentTimeMillis();
        long timeTaken;
        long ops = 10000;

        for(int i = 0; i < ops; i++){
            tested.previous();
        }

        timeTaken = System.currentTimeMillis() - current;

        LOG.info("Time taken to compute fibonanci {} PREVIOUS ops | {} milliseconds", ops, timeTaken);
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
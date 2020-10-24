package com.fibonacci.fibonacciapi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FibonacciController {

    private static final Logger LOG = LoggerFactory.getLogger(FibonacciController.class);

    public static final int MAX_FIB_COUNT = 92;

    private long counter = 0;

    private long currentFibSequence = 0;

    @GetMapping("/current")
    public long current(){
        return currentFibSequence;
    }

    @GetMapping("/next")
    public long next(){

        counter++;

        if(counter > MAX_FIB_COUNT){
            counter = 0;
            currentFibSequence = 0;
            return currentFibSequence;
        }

        //the fibonacci compute happens atomically via synchronized here
        synchronized (this){
            currentFibSequence = fibonacci(counter);
        }

        if(counter % 10 == 0){
            LOG.info("Fibonacci sequence increase to {} with counter {}", currentFibSequence, counter);
        }

        return currentFibSequence;
    }

    @GetMapping("/previous")
    public long previous(){

        counter--;

        if(counter < 0){
            counter = MAX_FIB_COUNT;
        }

        //the fibonacci compute happens atomically via synchronized here
        synchronized (this){
            currentFibSequence = fibonacci(counter);
        }

        if(counter % 10 == 0){
            LOG.info("Fibonacci sequence decreased to {} with counter {}", currentFibSequence, counter);
        }

        return currentFibSequence;
    }

    public long fibonacci(long n) {

        long a = 0, b = 1, c;

        if (n == 0){
            return a;
        }

        for (int i = 2; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }

        return b;
    }

}

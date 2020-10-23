package com.fibonacci.fibonacciapi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FibonacciController {

    public static final int MAX_COUNT = 92;

    private long counter = 0;

    private long currentFibSequence = 0;

    @GetMapping("/current")
    public long current(){
        return currentFibSequence;
    }

    @GetMapping("/next")
    public synchronized long next(){

        counter++;

        if(counter > MAX_COUNT){
            counter = 0;
            currentFibSequence = 0;
            System.out.println("Fibonacci started over. Now at " + currentFibSequence + " at counter " + counter);
            return currentFibSequence;
        }

        currentFibSequence = fibonacci(counter);

        //System.out.println("Next Fibonacci was " + currentFibSequence + " at counter " + counter);

        return currentFibSequence;
    }

    @GetMapping("/previous")
    public synchronized long previous(){

        counter--;

        if(counter < 0){
            counter = MAX_COUNT;
            System.out.println("Fibonacci went to the end.");
        }

        currentFibSequence = fibonacci(counter);

        //System.out.println("Previous Fibonacci was " + currentFibSequence + " at counter " + counter);

        return currentFibSequence;
    }

    public long fibonacci(long n) {

        //if(1 > 0){
            //return 5;
        //}

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

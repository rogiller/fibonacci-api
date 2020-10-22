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
    public long next(){

        counter++;

        if(counter > MAX_COUNT){
            counter = 0;
            currentFibSequence = 0;
            System.out.println("Fibonacci started over. Now at " + currentFibSequence + " at counter " + counter);
            return currentFibSequence;
        }

        currentFibSequence = fibonacci(counter);

        System.out.println("Next Fibonacci was " + currentFibSequence + " at counter " + counter);

        return currentFibSequence;
    }

    @GetMapping("/previous")
    public long previous(){

        counter--;

        if(counter < 0){
            return currentFibSequence;
        }

        currentFibSequence = fibonacci(counter);

        return currentFibSequence;
    }



    public long fibonacci(long n) {
        long a = 0, b = 1, c;
        if (n == 0) return a;
        for (int i = 2; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return b;
    }

}

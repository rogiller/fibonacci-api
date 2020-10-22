package com.fibonacci.fibonacciapi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FibonacciController {

    private long counter = 0;

    private long currentFibSequence = 0;

    @GetMapping("/current")
    public long current(){
        return currentFibSequence;
    }

    @GetMapping("/next")
    public long next(){

        counter++;

        if(counter > 92){
            return currentFibSequence;
        }

        currentFibSequence = fibonacciIterative(counter);

        System.out.println("Next Fib was " + currentFibSequence + " at counter " + counter);

        return currentFibSequence;
    }

    @GetMapping("/previous")
    public long previous(){

        counter--;

        if(counter < 0){
            return currentFibSequence;
        }

        currentFibSequence = fibonacciIterative(counter);

        return currentFibSequence;
    }



    public long fibonacciIterative(long n) {
        long a = 0, b = 1, c;
        if (n == 0) return a;
        for (int i = 2; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return b;
    }

    public static void main(String[] args) {

        FibonacciController controller = new FibonacciController();

        long current;
        long timeTaken;

        current = System.currentTimeMillis();

        for(int i = 0; i < 3000; i++){
            long next = controller.next();
        }

        timeTaken = System.currentTimeMillis() - current;
        System.out.println("Time taken to compute it : " + timeTaken + " milliseconds");

    }

}

package com.fibonacci.fibonacciapi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FibonacciController {

    private int counter = 0;

    private int currentFibSequence = 0;

    @GetMapping("/current")
    public int current(){
        return currentFibSequence;
    }

    @GetMapping("/next")
    public int next(){

        counter++;

        currentFibSequence = fibonacciRecursiveMem(counter);

        return currentFibSequence;
    }

    @GetMapping("/previous")
    public int previous(){

        counter--;

        if(counter < 0){
            return currentFibSequence;
        }

        currentFibSequence = fibonacciRecursiveMem(counter);

        return currentFibSequence;
    }

    public int fibonacciRecursiveMem(int n) {
        return fibonacciRecursiveMem(n, new int[n+1]);
    }

    public int fibonacciRecursiveMem(int i, int mem[]) {
        if (i==0 || i==1) return i;

        if (mem[i] == 0) {
            mem[i] = fibonacciRecursiveMem(i-1, mem) + fibonacciRecursiveMem(i-2, mem);
        }

        return mem[i];
    }

}

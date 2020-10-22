package com.fibonacci.fibonacciapi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FibonacciController {

    @GetMapping("/current")
    public long current(){
        return 0;
    }

    @GetMapping("/next")
    public long next(){
        return 1;
    }

    @GetMapping("/previous")
    public long previous(){
        return 0;
    }

}

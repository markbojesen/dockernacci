package com.mark.dockerfibonacci.controller;

import com.mark.dockerfibonacci.service.FibonacciService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fibonacci")
public class FibonacciController {

    private final FibonacciService service;

    @Autowired
    public FibonacciController(FibonacciService service) {
        this.service = service;
    }

    @GetMapping("/recursive")
    public String checkFibonacciRecursivelyController(@RequestParam int fibPosition) {
        return "Fibonacci number of the Nth position is: " + service.checkNthFibonacciNumberRecursively(fibPosition);
    }
}

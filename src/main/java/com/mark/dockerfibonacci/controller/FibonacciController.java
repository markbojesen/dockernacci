package com.mark.dockerfibonacci.controller;

import com.mark.dockerfibonacci.service.FibonacciService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/fibonacci")
public class FibonacciController {

    private final FibonacciService service;

    @Autowired
    public FibonacciController(FibonacciService service) {
        this.service = service;
    }

    @GetMapping("/recursive")
    public Map<String, Long> calculateFibonacci(@RequestParam long nthNumber) {
        Map<String, Long> response = new HashMap<>();
        response.put("nthNumber", nthNumber);
        response.put("fibonacciResult", service.calculateFibonacci(nthNumber));

        return response;
    }

    @GetMapping("/clear")
    public void clearCache(@RequestParam long nthNumber) {
        service.clearCache(nthNumber);
    }
}

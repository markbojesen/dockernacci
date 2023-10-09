package com.mark.dockerfibonacci.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import static java.lang.String.*;

@Service
public class FibonacciService {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    public int checkNthFibonacciNumberRecursively(int number) {
        if (number <= 1) {
            return number;
        } else if (number >= 45) {
            logger.error("Number provided is too large: {}", number);
            throw new IllegalArgumentException("Number provided is too large: " + number);
        }

        return checkNthFibonacciNumberRecursively(number - 1) + checkNthFibonacciNumberRecursively(number - 2);
    }
}

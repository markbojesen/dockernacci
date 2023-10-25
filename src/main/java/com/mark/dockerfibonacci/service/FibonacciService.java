package com.mark.dockerfibonacci.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class FibonacciService {

    private final Map<Long, Long> cachedFibonacciNumbers = new HashMap<>();
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Cacheable(value = "fibonacciCache", key = "#nthNumber")
    public long calculateFibonacci(long nthNumber) {
        if (cachedFibonacciNumbers.containsKey(nthNumber)) {
            logger.info("Key cached: {}", nthNumber);
            return cachedFibonacciNumbers.get(nthNumber);
        }

        long result;
        if (nthNumber <= 1) {
            result = nthNumber;
        } else {
            result = calculateFibonacci(nthNumber - 1) + calculateFibonacci(nthNumber - 2);
        }

        cachedFibonacciNumbers.put(nthNumber, result);
        return result;
    }

    @CacheEvict(value = "fibonacciCache", key = "#nthNumber")
    public void clearCache(long nthNumber) {
        cachedFibonacciNumbers.remove(nthNumber);
        logger.info("Cache cleared for key {}", nthNumber);
    }
}

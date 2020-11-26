package com.simplemobiletools.calculator;

import com.simplemobiletools.calculator.operation.PlusOperation;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestClass {

    @Test
    public void firstTest() {
        assertEquals("4.80", new PlusOperation(new BigDecimal("2.40"),new BigDecimal("2.40")).getResult().toString());
    }

    @Test
    public void secondTest() {
        assertEquals("126.439", new PlusOperation(new BigDecimal("125.44"),new BigDecimal("0.999")).getResult().toString());
    }
}

package com.simplemobiletools.calculator;

import com.ibm.icu.impl.Assert;
import com.simplemobiletools.calculator.activities.MainActivity;
import com.simplemobiletools.calculator.helpers.CalculatorImpl;
import com.simplemobiletools.calculator.operation.DivideOperation;
import com.simplemobiletools.calculator.operation.FactorialOperation;
import com.simplemobiletools.calculator.operation.MinusOperation;
import com.simplemobiletools.calculator.operation.MultiplyOperation;
import com.simplemobiletools.calculator.operation.PercentOperation;
import com.simplemobiletools.calculator.operation.PlusOperation;
import com.simplemobiletools.calculator.operation.PowerOperation;
import com.simplemobiletools.calculator.operation.RootOperation;

import org.junit.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

public class TestClass {
    MainActivity mainActivityMock = mock(MainActivity.class);
    CalculatorImpl calculatorMock = mock(CalculatorImpl.class);

    @Test
    public void mockTest() {
        mainActivityMock.setValueBigDecimal(new BigDecimal(-26.0));
        Mockito.verify(mainActivityMock, times(1)).setValueBigDecimal(new BigDecimal(-26.0));

        calculatorMock.setDisplayedFormula("1+5");
        Mockito.verify(calculatorMock, times(1)).setDisplayedFormula("1+5");
        when(calculatorMock.getDisplayedFormula()).thenReturn("1+5");
        String result = calculatorMock.getDisplayedFormula();
        assertEquals(result, "1+5");
    }

    @Test
    public void plusOp() {
        BigDecimal firstRes = new PlusOperation(new BigDecimal("2.458"),new BigDecimal("13.123")).getResult();
        BigDecimal secondRes = new PlusOperation(new BigDecimal("0.44"),new BigDecimal("159753.999")).getResult();
        BigDecimal lastRes = new PlusOperation(firstRes, secondRes).getResult();
        assertEquals("159770.020", lastRes.toString());
    }

    @Test
    public void minusOp() {
        BigDecimal firstRes = new MinusOperation(new BigDecimal("0.54268"),new BigDecimal("1456.25")).getResult();
        BigDecimal secondRes = new MinusOperation(new BigDecimal("-124.37"),new BigDecimal("-5556.25")).getResult();
        BigDecimal lastRes = new MinusOperation(firstRes, secondRes).getResult();
        assertEquals("-6887.58732", lastRes.toString());
    }

    @Test
    public void multiplyOp() {
        BigDecimal firstRes = new MultiplyOperation(new BigDecimal("0.123"), new BigDecimal("-5698.45")).getResult();
        BigDecimal secondRes = new MultiplyOperation(new BigDecimal("451"), new BigDecimal("-58.8")).getResult();
        BigDecimal lastRes = new MultiplyOperation(firstRes, secondRes).getResult();
        assertEquals("18587274.870780", lastRes.toString());
    }

    @Test
    public void divideOp() {
        BigDecimal firstRes = new DivideOperation(new BigDecimal("0.25"), new BigDecimal("-10")).getResult();
        BigDecimal secondRes = new DivideOperation(new BigDecimal("500"), new BigDecimal("25")).getResult();
        BigDecimal lastRes = new DivideOperation(firstRes, secondRes).getResult();
        assertEquals("-0.00125", lastRes.toString());
    }

    @Test
    public void powerOp() {
        BigDecimal firstRes = new PowerOperation(new BigDecimal("2"), new BigDecimal("-3")).getResult();
        BigDecimal secondRes = new PowerOperation(new BigDecimal("1"), new BigDecimal("22.5")).getResult();
        BigDecimal lastRes = new PowerOperation(firstRes, secondRes).getResult();
        assertEquals("0.125", lastRes.toString());
    }

    @Test
    public void rootOp() {
        assertEquals("9", new RootOperation(new BigDecimal("81")).getResult().toString());
        assertEquals("5478", new RootOperation(new BigDecimal("30008484")).getResult().toString());
        assertEquals("75", new RootOperation(new BigDecimal("5625")).getResult().toString());
    }

    @Test
    public void percentOp() {
        assertEquals("1357.68375", new PercentOperation(new BigDecimal("15.5"), new BigDecimal("8759.25")).getResult().toString());
        assertEquals("8899.9911", new PercentOperation(new BigDecimal("0.89"), new BigDecimal("999999")).getResult().toString());
        assertEquals("0.113664", new PercentOperation(new BigDecimal("44.4"), new BigDecimal("0.256")).getResult().toString());
    }

    @Test
    public void factorialOp() {
        assertEquals("3628800", new FactorialOperation(new BigDecimal("10")).getResult().toString());
        assertEquals("120", new FactorialOperation(new BigDecimal("5")).getResult().toString());
        assertEquals("479001600", new FactorialOperation(new BigDecimal("12")).getResult().toString());
    }

    @Test
    public void firstMix() {
        BigDecimal firstRes = new PlusOperation(new BigDecimal("-0.15973"),new BigDecimal("81288.456")).getResult();
        BigDecimal secondRes = new MultiplyOperation(new BigDecimal("2"),new BigDecimal("8.25")).getResult();
        BigDecimal lastRes = new MinusOperation(firstRes, secondRes).getResult();
        assertEquals("81271.79627", lastRes.toString());
    }

    @Test
    public void secondMix() {
        BigDecimal firstRes = new RootOperation(new BigDecimal("144")).getResult();
        BigDecimal secondRes = new DivideOperation(new BigDecimal("589"),new BigDecimal("2")).getResult();
        BigDecimal lastRes = new PercentOperation(firstRes, secondRes).getResult();
        assertEquals("35.340", lastRes.toString());
    }
}

package io.bw.spring.calculator.template;

import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Byungwook Lee on 9/2/2017
 * quddnr153@gmail.com
 * https://github.com/quddnr153
 */
public class CalculatorTest {
    private Calculator calculator;
    private String numFilePath;

    @Before
    public void init() {
        calculator = new Calculator();
        numFilePath = getClass().getResource("/numbers.txt").getPath();
    }

    @Test
    public void sumOfNumbers() throws IOException {
        assertThat(calculator.calculateSum(numFilePath), is(10));
    }

    @Test
    public void multiplyOfNumbers() throws IOException {
        assertThat(calculator.calculateMultiply(numFilePath), is(24));
    }

    @Test
    public void concatenateStrings() throws IOException {
        assertThat(calculator.concatenate(numFilePath), is("1234"));
    }
}
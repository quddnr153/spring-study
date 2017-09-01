package io.bw.spring.calculator.template;

/**
 * @author Byungwook Lee on 9/2/2017
 * quddnr153@gmail.com
 * https://github.com/quddnr153
 */
public interface LineCallback<T> {
    T doSomethingWithLine(String line, T value);
}

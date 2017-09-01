package io.bw.spring.calculator.template;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Byungwook Lee on 9/2/2017
 * quddnr153@gmail.com
 * https://github.com/quddnr153
 */
public class Calculator {
    public Integer calculateSum(String filePath) throws IOException {
        LineCallback<Integer> sumCallback = new LineCallback<Integer>() {
            @Override
            public Integer doSomethingWithLine(String line, Integer value) {
                return value + Integer.valueOf(line);
            }
        };

        return lineReadTemplate(filePath, sumCallback, 0);
    }

    public Integer calculateMultiply(String filePath) throws IOException {
        LineCallback<Integer> multiplyCallback = new LineCallback<Integer>() {
            @Override
            public Integer doSomethingWithLine(String line, Integer value) {
                return value * Integer.valueOf(line);
            }
        };

        return lineReadTemplate(filePath, multiplyCallback, 1);
    }

    public String concatenate(String filePath) throws IOException {
        LineCallback<String> concatenateCallback = new LineCallback<String>() {
            @Override
            public String doSomethingWithLine(String line, String value) {
                return value + line;
            }
        };

        return lineReadTemplate(filePath, concatenateCallback, "");
    }

    private <T> T lineReadTemplate(String filePath, LineCallback<T> callback, T initValue) throws IOException {
        T result = initValue;

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            String line = null;

            while ((line = bufferedReader.readLine()) != null) {
                result = callback.doSomethingWithLine(line, result);
            }

        } catch (IOException ioException) {
            throw new IllegalStateException("Fail to read line, filePath {" + filePath + "}, initValue {" + initValue + "}", ioException);
        }

        return result;
    }
}

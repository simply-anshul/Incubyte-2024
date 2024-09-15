package main.java.com.anshul;

import java.util.ArrayList;
import java.util.List;

public class StringCalculatorImpl implements StringCalculator {
    @Override
    public int add(String numbers) {
        String delimiters = ",|\n";
        int sumResult = 0;

        if (numbers.isEmpty()) {
            return 0;
        }
        if (numbers.startsWith("//")) {
            delimiters += "|" + numbers.charAt(2);
        }
        String[] numberArray = numbers.replace("//", "").split(delimiters);

        checkNegativeNumbers(numberArray);

        for (String number : numberArray) {
            sumResult += Integer.parseInt(number.isEmpty() ? "0" : number);
        }
        return sumResult;
    }

    private void checkNegativeNumbers(String[] numberArray) {
        List<String> negativeNumbers = new ArrayList();
        for (String number : numberArray) {
            if (!number.isEmpty() && Integer.parseInt(number) < 0) {
                negativeNumbers.add(number);
            }
        }
        if (!negativeNumbers.isEmpty()) {
            throw new IllegalArgumentException(
                    "negative numbers not allowed " + negativeNumbers.toString());
        }
    }
}
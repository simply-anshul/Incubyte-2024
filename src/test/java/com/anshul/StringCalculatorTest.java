package test.java.com.anshul;

import main.java.com.anshul.StringCalculator;
import main.java.com.anshul.StringCalculatorImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StringCalculatorTest {

    //  CASE 01 : Return 0 in case of empty String
    @Test
    public void testEmptyString() {
        StringCalculator calc = new StringCalculatorImpl();
        int result = calc.add("");
        assertEquals(0, result);
    }

    //   CASE 02 : If single number is passed, return that same number
    @Test
    public void testSingleNumberInput() {
        StringCalculator calc = new StringCalculatorImpl();
        assertEquals(1, calc.add("1"));
        assertEquals(20, calc.add("20"));
        assertEquals(536, calc.add("536"));
    }

    //  CASE 03 : Comma seperated numbers
    @Test
    public void testCommaSeperatedNumbers() {
        StringCalculator calc = new StringCalculatorImpl();
        assertEquals(6, calc.add("1,5"));
        assertEquals(3, calc.add("1,2"));
        assertEquals(6, calc.add("0,6"));
        assertEquals(706, calc.add("243,463"));
    }

    //  CASE 04 : Newline \n delimiter
    @Test
    public void testNewlineDelimiter() {
        StringCalculator calc = new StringCalculatorImpl();
        assertEquals(6, calc.add("1\n2,3"));
        assertEquals(10, calc.add("1\n2,3\n4"));
        assertEquals(15, calc.add("1\n2\n3\n4\n5"));
        assertEquals(21, calc.add("1,2\n3\n4\n5,6"));
    }

    //  CASE 05 : With Custom Delimiters
    @Test
    public void testCustomDelimiter() {
        StringCalculator calc = new StringCalculatorImpl();
        assertEquals(6, calc.add("//;\n1;2;3"));
        assertEquals(10, calc.add("//~1\n2~3,4"));
        assertEquals(15, calc.add("//-1-2-3-4-5"));
    }

    //  CASE 06 : Test Negative Numbers
    @Test
    public void testWithNegativeNumbers() {
        StringCalculator calc = new StringCalculatorImpl();
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            calc.add("1,-2,-3");
        });
        assertEquals("negative numbers not allowed [-2, -3]", exception.getMessage());
    }

}
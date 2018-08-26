package lesson2;

import org.junit.Assert;
import org.junit.Test;

public class JavaBasics {
    private Integer sum;

    @Test
    public void sumTwoDigits() {
        sumDigits(2, 3);
                Assert.assertEquals("Result is not equals with expected", 6, sum, 0);
    }

    @Test
    public void sumAndMultDigits() {
        Integer result;
        result = sumDigits(3, 5 );
        result = result * 2;
        System.out.println("The result is: " + result);

        }
        public Integer sumDigits(Integer a, Integer b) {
        sum = a + b;
        return sum;

    }

}

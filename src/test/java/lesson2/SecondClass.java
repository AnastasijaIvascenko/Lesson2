package lesson2;

import org.junit.Test;


public class SecondClass {
    @Test
    public void third() {
        JavaBasics javaBasics = new JavaBasics();

        Integer result;
        result = (javaBasics.sumDigits(2, 3)) * (javaBasics.sumDigits(6, 4));
        System.out.println(result);
    }
}

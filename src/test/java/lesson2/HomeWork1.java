package lesson2;

import org.junit.Test;

public class HomeWork1 {
    public Integer sum;

    @Test
    public void sumDigits(){
        Integer result;
        result = sumDigits(10, 20, 30);
        System.out.println("4.Price for three products is:" + result);


    }
    public Integer sumDigits(Integer a, Integer b, Integer c) {
        sum = a + b + c;
        return sum;
    }

}

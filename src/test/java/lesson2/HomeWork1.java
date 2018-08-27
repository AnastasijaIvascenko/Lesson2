package lesson2;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class HomeWork1 {
    private Integer sum;
    private double firstPrice = 90.00;
    private double secondPrice = 88.00;
    private double servicePrice = 5.00;
    private double finalResult = 250.00;


    @Test
    public void sumDigits() {
        //First price + 21%
        //double resultFirstPrice = firstPrice * 21 / 100;
        double resultFirstPrice = addPVN(firstPrice, 21);
        System.out.println("The result of first price + PVN is:" + resultFirstPrice);
        //Second price + 21%
        //double resultSecondPrice = secondPrice * 21 / 100;
        double resultSecondPrice = addPVN(secondPrice, 21);
        //Service price +5%
        //double resultServicePrice = servicePrice * 5 / 100;
        double resultServicePrice = addPVN(servicePrice, 5);
        //Sum of first price + second price + service price
        double result = resultFirstPrice + resultSecondPrice + resultServicePrice;
        //Checking sum of first price + second price + service price with final result
        Assert.assertEquals("The result is wrong", finalResult, result, 0);

    }

    private double addPVN(double price, double percentage) {
        return price * percentage / 100 + price;

    }


}



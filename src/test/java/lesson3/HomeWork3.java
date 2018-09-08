package lesson3;

import org.junit.Assert;
import org.junit.Test;

public class HomeWork3 {
    private float credit = 100000;
    private float creditTerm = 360;
    private float first120Months = 5;
    private float second120Months = 3;
    private float last120Months = 2;
    private float finalResult = 200000;

    @Test
    public void sumDigits() {

        //Calculate payment per month
        float paymentPerMonth = credit / creditTerm;
        System.out.println("The payment per month is:" + paymentPerMonth);

        //Percentage payments
        float resultFirstRate = (credit * first120Months * 30) / (100 * 365);
        System.out.println("Percentage payments per month for first 10 years is::" + resultFirstRate);

        //Percentage payments for first 10 years
        float percentageForFirst10Years = percentageFor10Years(resultFirstRate);
        System.out.println("Percentage payments for first 10 years is:" + percentageForFirst10Years);

        //Payment for first 10 years without percentage
        float paymentForFirst10YearsWithoutPercentage = paymentFor10Years(paymentPerMonth);
        System.out.println("The payment for first 10 years without percentage is:" + paymentForFirst10YearsWithoutPercentage);

        //Payment for month with percentage
        float paymentWithPercentage = paymentPerMonth + resultFirstRate;
        System.out.println("The payment for month with percentage is:" + paymentWithPercentage);

        //Payment for first 10 years with percentage
        float paymentForFirst10YearsWithPercentage = paymentWithPercentage * 120;
        System.out.println("Payment for first 10 years with percentage is :" + paymentForFirst10YearsWithPercentage);

        //Loan balance for next 20 years
        float loanBalance = credit - paymentForFirst10YearsWithoutPercentage;
        System.out.println("Loan Balance for next 20 years is:" + loanBalance);

        //Percentage payments for second 10 years
        float resultSecondRate = (loanBalance * second120Months * 30) / (100 * 365);
        System.out.println("Percentage payment per month for second 10 years is:" + resultSecondRate);

        //Percentage payments for second 10 years
        float percentageForSecond10Years = percentageFor10Years(resultSecondRate);
        System.out.println("Percentage payments for second 10 years is:" + percentageForSecond10Years);

        //Payment for second 10 years without percentage
        float paymentForSecond10YearsWithoutPercentage = paymentFor10Years(paymentPerMonth);
        System.out.println("The payment for second 10 years without percentage is:" + paymentForSecond10YearsWithoutPercentage);

        //Loan balance for last 10 years
        float lastLoanBalance = loanBalance - paymentForSecond10YearsWithoutPercentage;
        System.out.println("Loan balance for last 10 years is:" + lastLoanBalance);

        //Percentage payments for last 10 years
        float resultLastRate = (lastLoanBalance * last120Months * 30) / (100 * 365);
        System.out.println("Percentage payment per month for last 1o years is:" + resultLastRate);

        //Percentage payment for last 10 years
        float percentageForLast10Years = percentageFor10Years(resultLastRate);
        System.out.println("Percentage payments for last 10 years is:" + percentageForLast10Years);

        //General overpayment
        float overpayment = percentageForFirst10Years + percentageForSecond10Years + percentageForLast10Years;
        System.out.println("General overpayment is:" + overpayment);

        //Total payment for 30 years
        float totalPayment = credit + overpayment;
        System.out.println("Total payment for 30 years is:" + totalPayment);

        Assert.assertEquals("The total payment is wrong", finalResult, totalPayment, 0);

    }

    private float percentageFor10Years (float percentage) {
        return percentage * 120;
    }

    private float paymentFor10Years (float payment) {
        return payment * 120;
    }


}



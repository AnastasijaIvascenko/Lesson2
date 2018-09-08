package specialEdition;

import org.junit.Assert;
import org.junit.Test;
import org.omg.CORBA.FREE_MEM;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class HomeWorkDelfi {
    private final String HOME_PAGE = "http://rus.delfi.lv";
    private final By CLOSE_COOKIE = By.xpath(".//a[@class = 'close cookie']");
    private final By FIRST_TITLE = By.xpath(".//a[@class='top2012-title']");
    private final By COMMENT = By.xpath(".//a[@class='comment-count']");


    @Test
    public void delfiTest() {
        System.setProperty("webdriver.gecko.driver", "/Users/anastasija/Desktop/QA2/geckodriver");
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get(HOME_PAGE);

        driver.findElement(CLOSE_COOKIE).click();
        driver.findElement(FIRST_TITLE).click();
        Assert.assertEquals("Page Title", driver.getTitle(), FIRST_TITLE);
        driver.findElement(COMMENT).click();





    }
}

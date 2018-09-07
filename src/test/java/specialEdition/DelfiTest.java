package specialEdition;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DelfiTest {
    private final String HOME_PAGE = "http://rus.delfi.lv"; //String- строчное значение final - константа и название переменной капс локом
    private final By SEARCH_FILD =  By.name("q");
    private final By SEACH_BTN = By.xpath(".//a[@class = 'headerSearchInputBtn']");
    private final By CLOSE_COOKIE = By.xpath(".//a[@class = 'close cookie']");

    @Test
    public void delfiTest() {
        System.setProperty("webdriver.gecko.driver", "/Users/anastasija/Desktop/QA2/geckodriver");
        WebDriver driver = new FirefoxDriver(); //driver- переменная, то что я сама придумываю
        driver.manage().window().maximize(); //manage-управление window- окном maximize- чтобы распахнулось
        driver.get(HOME_PAGE); //get - перейти по ссылке

        driver.findElement(CLOSE_COOKIE).click();

        WebElement element = driver.findElement(SEARCH_FILD);
        element.sendKeys("Rīga");
        driver.findElement(SEACH_BTN).click();



    }
}

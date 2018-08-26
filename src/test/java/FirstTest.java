import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirstTest {
    @Test
    public void firstTest() {
        System.setProperty("webdriver.gecko.driver", "/User/anastasija/Downloads");
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("http://rus.delfi.lv");
    }
}

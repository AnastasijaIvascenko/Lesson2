package specialEdition;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class HomeWorkDelfi {
    private final String HOME_PAGE = "http://rus.delfi.lv";
    private final By CLOSE_COOKIE = By.xpath(".//a[@class = 'close cookie']");
    private final By FIRST_TITLE = By.xpath(".//a[@class='top2012-title']");
    private final By ARTICLE_PAGE_TITLE = By.xpath(".//span[@itemprop='headline name']");
    private final By COMMENT = By.xpath(".//a[@class='comment-count']");
    private final By ARTICLE_PAGE_COMMENT = By.xpath(".//div[@class='article-title']/a");




    @Test
    public void delfiTest() {
        System.setProperty("webdriver.gecko.driver", "/Users/anastasija/Desktop/QA2/geckodriver");
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get(HOME_PAGE);

        driver.findElement(CLOSE_COOKIE).click();
        String title = driver.findElement(FIRST_TITLE).getText(); //запоминает текст и гетТекс вынос ит в текст без хпаса
        String comment = driver.findElement(COMMENT).getText();
        //то что отбросит скобки
        comment = comment.substring(1, comment.length() - 1); //отбрасывает первый и последний символ


        driver.findElement(FIRST_TITLE).click();
        Assert.assertEquals("Wrong Title", title, driver.findElement(ARTICLE_PAGE_TITLE).getText());
        String articlePageComment = driver.findElement(ARTICLE_PAGE_COMMENT).getText();
        articlePageComment = articlePageComment.substring(1, articlePageComment.length() -1);
        Assert.assertEquals( "Wrong comment", comment, articlePageComment);


        driver.findElement(COMMENT).click();
        





    }

}

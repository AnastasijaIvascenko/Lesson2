package specialEdition;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class HomeWorkDelfi {
    private final String HOME_PAGE = "http://rus.delfi.lv";
    private final By CLOSE_COOKIE = By.xpath(".//a[@class = 'close cookie']");
    private final By FIRST_TITLE = By.xpath(".//a[@class='top2012-title']");
    private final By ARTICLE_PAGE_TITLE = By.xpath(".//span[@itemprop='headline name']");
    private final By LAST_PAGE_TITLE = By.xpath(".//a[@class='comment-main-title-link']");
    private final By COMMENT = By.xpath(".//a[@class='comment-count']");
    private final By ARTICLE_PAGE_COMMENT = By.xpath(".//div[@class='article-title']/a");
    private final By REG_COMMENTS = By.xpath(".//a[contains(@class, 'comment-thread-switcher-list-a-reg')]/span");
    private final By ANON_COMMENTS = By.xpath(".//a[contains(@class, 'comment-thread-switcher-list-a-anon')]/span");

    @Test
    public void delfiTest() {
        System.setProperty("webdriver.gecko.driver", "/Users/anastasija/Desktop/QA2/geckodriver");
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get(HOME_PAGE);

        //Первая страница
        driver.findElement(CLOSE_COOKIE).click();
        String title = driver.findElement(FIRST_TITLE).getText(); //запоминает текст и гетТекс вынос ит в текст без хпаса
        String comment = driver.findElement(COMMENT).getText();

        //то что отбросит скобки
        //comment = comment.substring(1, comment.length() - 1); //отбрасывает первый и последний символ
        //Integer com = Integer.valueOf(comment);
        Integer com = removeBrackets(comment);

        driver.findElement(FIRST_TITLE).click();

        //Вторая страница
        String articlePageTitle = driver.findElement(ARTICLE_PAGE_TITLE).getText();
        Assert.assertTrue("Wrong", articlePageTitle.contains(title));

        //Assert.assertEquals("Wrong Title", title, driver.findElement(ARTICLE_PAGE_TITLE).getText());
        String articlePageComment = driver.findElement(ARTICLE_PAGE_COMMENT).getText();
        //articlePageComment = articlePageComment.substring(1, articlePageComment.length() - 1);
        Integer articlePageCommentCount = removeBrackets(articlePageComment);
        Assert.assertEquals("Wrong comment", com, articlePageCommentCount, 0);

        driver.findElement(COMMENT).click();

        //Третья страница
        String partOfText = driver.findElement(LAST_PAGE_TITLE).getText();
        Assert.assertTrue("", partOfText.contains(title));

        List<WebElement> regComments = driver.findElements(REG_COMMENTS);
        Integer reg = 0;
        if(!regComments.isEmpty()) {
            reg = removeBrackets(regComments.get(0).getText());
        }
        List<WebElement> anonComments = driver.findElements(ANON_COMMENTS);
        Integer anon = 0;
        if(! anonComments.isEmpty()) {
            anon = removeBrackets(anonComments.get(0).getText());
        }

        //regComment = regComment.substring(1, regComment.length() - 1);
        //String anonComment = driver.findElement(ANON_COMMENTS).getText();
        //anonComment = anonComment.substring(1, anonComment.length() - 1);
        //Integer anon = removeBrackets(anonComment);

        Assert.assertEquals("", com, reg + anon, 0);

    }

    private Integer removeBrackets(String comment) {
        comment = comment.substring(1, comment.length() - 1);
        return Integer.valueOf(comment);
    }

}



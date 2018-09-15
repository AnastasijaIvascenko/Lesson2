package specialEdition;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.Assert.assertEquals;

public class HomeWorkDelfi {
    private final String HOME_PAGE = "http://rus.delfi.lv";
    private final By CLOSE_COOKIE = By.xpath(".//a[@class = 'close cookie']");
    private final By FIRST_TITLE = By.xpath(".//a[@class='top2012-title']");
    private final By ARTICLE_PAGE_TITLE = By.xpath(".//span[@itemprop='headline name']");
    private final By LAST_PAGE_TITLE = By.xpath(".//a[@class='comment-main-title-link']");
    private final By COMMENT = By.xpath(".//a[@class='comment-count']");
    private final By ARTICLE_PAGE_COMMENT = By.xpath(".//div[@class='article-title']/a");
    private final By REG_COMMENTS = By.xpath(".//*[@id='comments-listing']/div[3]/a[1]/span");
    private final By ANON_COMMENTS = By.xpath(".//*[@id='comments-listing']/div[3]/a[2]/span");

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
        comment = comment.substring(1, comment.length() - 1); //отбрасывает первый и последний символ
        String com = comment;
        Integer com1 = Integer.valueOf(com);
        driver.findElement(FIRST_TITLE).click();

        //Вторая страница
        String articlePageTitle = driver.findElement(ARTICLE_PAGE_TITLE).getText();
        Assert.assertTrue(articlePageTitle.contains(title));
        //Assert.assertEquals("Wrong Title", title, driver.findElement(ARTICLE_PAGE_TITLE).getText());
        String articlePageComment = driver.findElement(ARTICLE_PAGE_COMMENT).getText();
        articlePageComment = articlePageComment.substring(1, articlePageComment.length() - 1);
        Assert.assertEquals("Wrong comment", comment, articlePageComment);
        driver.findElement(COMMENT).click();

        //Третья страница
        String partOfText = driver.findElement(LAST_PAGE_TITLE).getText();
        Assert.assertTrue(partOfText.contains(title));
        String regComment = driver.findElement(REG_COMMENTS).getText();
        regComment = regComment.substring(1, regComment.length()-1);
        String anonComment = driver.findElement(ANON_COMMENTS).getText();
        anonComment = anonComment.substring(1, anonComment.length()-1);
        String reg = regComment;
        Integer reg1 = Integer.valueOf(reg);
        String anon = anonComment;
        Integer anon1 = Integer.valueOf(anon);
        Integer sum = (reg1 + anon1);
        Assert.assertEquals(com1, sum);

    }


}

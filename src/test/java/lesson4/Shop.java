package lesson4;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;


public class Shop {
    private WebDriver driver;
    private final String HOME_PAGE = "http://automationpractice.com/index.php";
    private final By MENU = By.xpath(".//ul[@class = 'sf-menu clearfix menu-content sf-js-enabled sf-arrows']");
    private final By MENU_ITEM = By.xpath(".//a[@class = 'sf-with-ul']");
    private final By MENU_SECTION = By.xpath(".//div[@id = 'categories_block_left']");
    private final By MENU_SECTION_ITEM = By.xpath(".//li[@class = 'last']");
    private final By DRESSES = By.xpath(".//div[@id = 'categories_block_left']");
    private final By DRESSES_LIST = By.xpath(".//ul[@class = 'tree dynamized']/li");
    private final By CATALOG = By.xpath(".//ul[@id = 'ul_layered_id_attribute_group_3']");
    private final By CATALOG_LIST = By.xpath(".//li[@class = 'nomargin hiddable col-lg-6']");
    private final By LOADING = By.xpath(".//ul[@class = 'product_list grid row']");
    private final By IMAGE = By.xpath(".//img[@itemprop = 'image']");
    private final By IMAGE_LOADING = By.xpath(".//img[@id = 'bigpic']");
    private final By BEIGE = By.xpath(".//a[@name = 'Beige']");
    private final By SIZE = By.xpath(".//div[@class = 'attribute_list']");
    private final By SIZE_LIST = By.xpath(".//select[@name = 'group_1']/option");




    @Test
    public void openShopPage() {
        System.setProperty("webdriver.gecko.driver", "/Users/anastasija/Desktop/QA2/geckodriver");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get(HOME_PAGE);

        //driver.findElement(MENU_ITEM).click();

        WebElement menuItem = getMenuItemByName("WOMEN");
        Assert.assertNotNull("Menu item not found", menuItem);
        menuItem.click();

        WebElement sectionMenu = getMenuSectionItemByName("Dresses");
        Assert.assertNotNull("section not found", sectionMenu);
        sectionMenu.click();

        WebElement dressesMenu = getMenuDressesList("Evening Dresses");
        Assert.assertNotNull("dresses not found", dressesMenu);
        dressesMenu.click();

        WebElement catalogMenu = getCatalogList("Beige (1)");
        Assert.assertNotNull("catalog not found", catalogMenu);
        catalogMenu.click();

        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfElementLocated(LOADING));

        driver.findElement(IMAGE).click();

        new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOfElementLocated(IMAGE_LOADING));

        driver.findElement(SIZE).click();

        WebElement sizeMenu = getSize("M");
        Assert.assertNotNull("Size not found", sizeMenu);
        sizeMenu.click();







    }

    private WebElement getMenuItemByName(String name) {
        WebElement menuItemList = driver.findElement(MENU);
        List<WebElement> itemList = menuItemList.findElements(MENU_ITEM);

        for (int i = 0; i < itemList.size(); i++) {
            String nameToCompare = itemList.get(i).getText();
            if (nameToCompare.equals(name)) {
                return itemList.get(i);
            }

        }
        return null;
    }

    private WebElement getMenuSectionItemByName(String sectionName) {
        WebElement menuSectionList = driver.findElement(MENU_SECTION);
        List<WebElement> sectionList = menuSectionList.findElements(MENU_SECTION_ITEM);

        for (int i = 0; i < sectionList.size(); i++) {
            String nameToCompareSection = sectionList.get(i).getText();
            if (nameToCompareSection.equals(sectionName)) {
                return sectionList.get(i);
            }
        }
        return null;
    }

    private WebElement getMenuDressesList(String dressesName) {
        WebElement dressesNameList = driver.findElement(DRESSES);
        List<WebElement> dressesList = dressesNameList.findElements(DRESSES_LIST);

        for (int i = 0; i < dressesList.size(); i++) {
            String nameToCompareDresses = dressesList.get(i).getText();
            if (nameToCompareDresses.equals(dressesName)) {
                return dressesList.get(i);
            }
        }
        return null;
    }

    private WebElement getCatalogList(String catalogName) {
        WebElement catalogNameList = driver.findElement(CATALOG);
        List<WebElement> catalogList = catalogNameList.findElements(CATALOG_LIST);

        for (int i = 0; i < catalogList.size(); i++) {
            String nameToCompareCatalog = catalogList.get(i).getText();
            if (nameToCompareCatalog.equals(catalogName)) {
                return catalogList.get(i);
            }
        }
        return null;
    }

    private WebElement getSize(String size) {
        WebElement sizeList = driver.findElement(SIZE);
        List<WebElement> sizeOption = sizeList.findElements(SIZE_LIST);

        for (int i = 0; i < sizeOption.size(); i++) {
            String nameToCompareSize = sizeOption.get(i).getText();
            if (nameToCompareSize.equals(size)) {
                return sizeOption.get(i);
            }
        }
        return null;
    }
}

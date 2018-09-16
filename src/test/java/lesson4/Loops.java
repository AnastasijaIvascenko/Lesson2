package lesson4;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class Loops {
    private WebDriver driver;
    private final By CLOSE_COOKIE = By.xpath(".//a[@class = 'close cookie']");
    private final By MENU = By.xpath(".//nav[@class = 'headerMainNavigation headerSeparatedNav']");
    private final By MENU_ITEM = By.xpath(".//a[@itemprop = 'url']");
    private final By MENU_ITEM_TEXT = By.xpath(".//span[@itemprop = 'name']");
    private final String HOME_PAGE = "http://rus.delfi.lv";
    private final By MENU_RECIPES = By.xpath(".//ul[@class = 'nav navbar-nav']");
    private final By MENU_ITEM_RECIPES = By.xpath(".//li[@class = 'nav-item dropdown']");
    private final By MENU_ITEM_TEXT_RECIPES = By.xpath(".//a[@class = 'nav-item-link']");
    private final By RECIPES_MENU = By.xpath(".//section[@class = 'row article-collection']");
    private final By RECIPES_MENU_ITEM = By.xpath(".//div[@class = 'col-xs-12 col-sm-4 headline']");
    private final By RECIPES_MENU_ITEM_TEXT = By.xpath(".//h1[@class = 'headline-title text-md']");


    @Test
    public void openFoodSectionTest () {
        System.setProperty("webdriver.gecko.driver", "/Users/anastasija/Desktop/QA2/geckodriver");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get(HOME_PAGE);

        driver.findElement(CLOSE_COOKIE).click();
        WebElement menuItem = getMenuItemByName("Еда");
        Assert.assertNotNull("Menu item not found", menuItem);
        menuItem.click();

        //кникнуть рецепты, через цикл
        driver.findElement(CLOSE_COOKIE).click();
        WebElement menuItemRecipes = getMenuItemByNameRecipes("РЕЦЕПТЫ");
        Assert.assertNotNull("Recipes item not found", menuItemRecipes);
        menuItemRecipes.click();

        //кликнуть на первый рецепт, тоже через цикл и by id выбрать
        WebElement recipesMenuItem = getRecipesMenuItemByName("Блины с яблоками и брусникой");
        Assert.assertNotNull("Recipe not found", recipesMenuItem);
        recipesMenuItem.click();

    }

    private WebElement getMenuItemByName(String name) {
        List<WebElement> menuItemList = driver.findElement(MENU).findElements(MENU_ITEM);

        for (int i = 0; i < menuItemList.size(); i++) {
            String nameToCompare = menuItemList.get(i).findElement(MENU_ITEM_TEXT).getText(); //из всего списка получаю необходимый по счету элемент
            if (nameToCompare.equals(name)) {
                return menuItemList.get(i);

            }
        }

        return null;

    }

    private WebElement getMenuItemByNameRecipes(String nameRecipes) {
        List<WebElement> menuItemListRecipes = driver.findElement(MENU_RECIPES).findElements(MENU_ITEM_RECIPES);

        for (int i = 0; i < menuItemListRecipes.size(); i++) {
            String nameToCompareRecipes = menuItemListRecipes.get(i).findElement(MENU_ITEM_TEXT_RECIPES).getText();
            if (nameToCompareRecipes.equals(nameRecipes)) {
                return menuItemListRecipes.get(i);
            }
        }
        return null;
    }

    private WebElement getRecipesMenuItemByName(String recipesName) {
        List<WebElement> recipesMenuItemList = driver.findElement(RECIPES_MENU).findElements(RECIPES_MENU_ITEM);

        for (int i = 0; i < recipesMenuItemList.size(); i++) {
            String recipesNameToCompare = recipesMenuItemList.get(i).findElement(RECIPES_MENU_ITEM_TEXT).getText();
            if (recipesNameToCompare.equals(recipesName)) {
                return recipesMenuItemList.get(i);
            }
        }
        return null;
    }

}

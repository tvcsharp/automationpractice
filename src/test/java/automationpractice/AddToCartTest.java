package automationpractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import org.testng.mustache.Value;
import pageObject.HomePage;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;

public class AddToCartTest {
    private WebDriver driver;
    private HomePage homePage;


    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        driver = new ChromeDriver();
        homePage = new HomePage(driver);

        String baseUrl = "http://automationpractice.com/index.php";
        //driver.manage().window().maximize();
        driver.get(baseUrl);
    }
    @Test
    public void addClothesToCart() throws InterruptedException {
        Assert.assertTrue(homePage.getDressesBtn().isDisplayed());
        homePage.getDressesBtn().click();
        homePage.getDressPageHeading().isDisplayed();

        List<WebElement> priceElement = driver.findElements(By.cssSelector("[class='price product-price']"));
        Map<WebElement, Integer> map = new HashMap<WebElement, Integer>();

        for (int i=0; i<priceElement.size(); i++){
            if (priceElement.get(i).getText() != "") {
                map.put(priceElement.get(i), Integer.parseInt(priceElement.get(i).getText().replaceAll("[$,.]", "")));
            }

        }
        List<Entry<WebElement, Integer>> le = new ArrayList <Map.Entry<WebElement, Integer>>(map.entrySet());

        le.sort(Entry.comparingByValue());

        for (Entry e : le) {
            System.out.println(e.getValue());
        }

        le.get(0).getKey().click();

        homePage.emptyCartElement().isDisplayed();
        homePage.addToCartElement().click();

   }

}

package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.Utils;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HomePage {
    WebDriver driver;
    private List<WebElement> dressPrices;


    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getDressesBtn() {
        return Utils.waitForElementPresence(driver, By.xpath("//*[@id=\"block_top_menu\"]/ul/li[2]"), Duration.ofSeconds(10));
    }

    public WebElement getDressPageHeading(){

        return Utils.waitForElementPresence(driver, By.xpath("//*[@id=\"center_column\"]/h1/span[1]"), Duration.ofSeconds(10));
    }

//    public WebElement getDressPrices() {
//
//      // List<WebElement> arrayOfElements = driver.findElement(By.xpath("//*[@class=\"product_list grid row\"]")).findElements(By.cssSelector("li"));
//      //  List<WebElement> arrayOfElements = driver.findElements(By.xpath("//*[@id=\"center_column\"]/ul/li[*]/div/div[2]/div[1]/span"));
//
//
//
//
//    }

    public WebElement emptyCartElement (){
        return Utils.waitForElementPresence(driver, By.cssSelector("[class='ajax_cart_no_product']"), Duration.ofSeconds(10));
    }

    public WebElement addToCartElement (){
        return Utils.waitForElementPresence(driver, By.id("add_to_cart"), Duration.ofSeconds(10));
    }

}


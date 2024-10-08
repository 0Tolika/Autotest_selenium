package common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public class AbsCommonObject<T> {

    protected WebDriver driver;
    protected Actions actions;

    public AbsCommonObject (WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this); //инициировать поиск элементов под статическими локаторами
        this.actions = new Actions(driver);
    }

    protected WebElement $(By locator)
    {
        return driver.findElement(locator);
    }

}

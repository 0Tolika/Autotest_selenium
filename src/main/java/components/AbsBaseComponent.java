package components;

import common.AbsCommonObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AbsBaseComponent<T> extends AbsCommonObject<T> {

    public AbsBaseComponent(WebDriver driver) {
        super(driver);
    }
}

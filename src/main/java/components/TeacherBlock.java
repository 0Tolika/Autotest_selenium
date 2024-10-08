package components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class TeacherBlock extends AbsBaseComponent<TeacherBlock>{
    public TeacherBlock(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//section[.//a[text()='Преподаватели']]//a[@href][.//div[not(text)]]")
    private List<WebElement> tichersTitles;
}

package pages;

import anotations.Path;
import anotations.PathTemplate;
import org.openqa.selenium.WebDriver;

//@PathTemplate("/lessons/$1")
@Path("/lessons/$1")
public class LessonCardPage extends AbsBasePage<LessonCardPage>
{
    public LessonCardPage(WebDriver driver) {
        super(driver);
    }
}

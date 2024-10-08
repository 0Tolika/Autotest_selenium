package mainpage;

import extensions.UIExtensions;
//import jakarta.inject.Inject;
import com.google.inject.Inject;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.MainPage;

@ExtendWith(UIExtensions.class)
public class MainPage_Test {

    @Inject
     WebDriver driver;

    @Inject
     MainPage mainPage;

    @Test
    public void mainPage_Test()
    {
       // driver == null
       // mainPage == null
       String lessonTitle = mainPage.open().getLessonTitleByIndex(1);
    }
}

















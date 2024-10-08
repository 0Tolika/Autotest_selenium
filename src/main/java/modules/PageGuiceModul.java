package modules;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LessonCardPage;
import pages.MainPage;

public class PageGuiceModul extends AbstractModule {

    private WebDriver driver = new ChromeDriver();

    @Provides
    public WebDriver getDriver()
    {
        return driver;
    }

    @Provides
    @Singleton
    public MainPage getMainPage()
    {
        return new MainPage(getDriver());
    }

    @Provides
    @Singleton
    public LessonCardPage getLessonCardPage()
    {
        return new LessonCardPage(getDriver());
    }
}

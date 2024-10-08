package pages;

import anotations.Template;
import anotations.UrlTemplats;
import org.openqa.selenium.WebDriver;

@UrlTemplats(
        template = {
                @Template(name="new_main", template="/{1}/{2}")
        }
)

public class NewsPage extends AbsBasePage<NewsPage>{

        public  NewsPage(WebDriver driver)
        {
                super(driver); // тут было super(driver);
        }
}

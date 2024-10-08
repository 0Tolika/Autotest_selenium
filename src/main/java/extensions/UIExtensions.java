package extensions;

import com.google.inject.Guice;
import com.google.inject.Injector;
import modules.PageGuiceModul;
import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.openqa.selenium.WebDriver;

public class UIExtensions implements BeforeEachCallback, AfterEachCallback {

    private Injector injector = null;

    @Override
    public void beforeEach(ExtensionContext extensionContext) throws Exception{
       this.injector = Guice.createInjector(new PageGuiceModul());
       this.injector.injectMembers(extensionContext.getTestInstance());
    }

    @Override
    public void afterEach(ExtensionContext extensionContext) throws Exception{
        WebDriver driver = this.injector.getProvider(WebDriver.class).get();
        if (driver != null)
        {
            driver.close();
            driver.quit();
        }
    }

}



























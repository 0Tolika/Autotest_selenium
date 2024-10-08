package pages;

import anotations.Path;
import anotations.Template;
import anotations.UrlTemplats;
import common.AbsCommonObject;
import exceptions.PathNotValidException;
import org.openqa.selenium.WebDriver;

import java.util.Arrays;

public abstract class AbsBasePage<T> extends AbsCommonObject<T> {

    //private String baseUrl = System.getProperty("base.url");
    private String baseUrl = !System.getProperty("base.url").endsWith("/") ?
            System.getProperty("base.url") :
            System.getProperty("base.url").substring(0, System.getProperty("base.url").length()-1);

    public AbsBasePage (WebDriver driver)
    {
        super(driver);
    }

    private String getPath()
    {
        Class clazz = getClass();
        if(clazz.isAnnotationPresent(Path.class)) //задача анотации в джаве хранить метаданные. Метаданные - конфигурационные доп данные о ресурсах
        {                                      //есть 2 типа анотация: маркеры - вешаем анотацию и ничего не передаем в нее (override)
            Path path = (Path)clazz.getDeclaredAnnotation(Path.class);  // не маркеры - несут функциональную нагрузку
            if (path.value().startsWith("/"))
            {
                return path.value();
            }
            else return "/" + path.value();
        }
        else throw new PathNotValidException();
    }

    private String getTemplatePath (String nameTemplate, String... data){
        Class clazz = getClass();
        if(clazz.isAnnotationPresent(UrlTemplats.class))
        {
            UrlTemplats urlTemplats = (UrlTemplats)clazz.getDeclaredAnnotation(UrlTemplats.class);
            Template[] templates = urlTemplats.template();
            String template = Arrays.stream(templates)
                    .filter((Template tem) -> tem.name().equals(nameTemplate))
                    .findFirst().get().template();
            for (int i = 0; i<data.length; i++)
            {
                int num = i+1;
                template = template.replace("$" + num, data[i]);
            }
            return template;
        }
        return "";
    }

    public T open()
    {
        if (baseUrl.endsWith("/")) {
            baseUrl = baseUrl.substring(0, baseUrl.length()-1);
        }
        driver.get(baseUrl + getPath());
        return (T)this;
    }

    public T open (String nameTemplate, String[] data)
    {
        if (baseUrl.endsWith("/")) {
            baseUrl = baseUrl.substring(0, baseUrl.length()-1);
        }
        driver.get(baseUrl + getTemplatePath(nameTemplate, data));
        return (T)this;
    }
}























package anotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME) //когда доступны данные для анотации. RUNTIME когда программа выполняется
@Target(ElementType.TYPE) //говорит на что вешаем анотацию type - class
public @interface Path {
    String value();
}






































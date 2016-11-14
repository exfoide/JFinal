import java.lang.annotation.*;

/**
 * Created by Jasper on 2016/9/29.
 *  定义作者信息，name,group
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
public @interface Author {
    String name();
    String group();
}

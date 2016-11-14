import java.lang.annotation.*;

/**
 * Created by Jasper on 2016/9/29.
 *  ����������Ϣ��name,group
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
public @interface Author {
    String name();
    String group();
}

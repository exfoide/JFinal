import java.lang.annotation.*;

/**
 * Created by Jasper on 2016/9/29.
 * ����������Ϣvalue
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
public @interface Description {
    String value();
}

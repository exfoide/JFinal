
package intercepter;


import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;
import com.jfinal.core.Controller;

/**
 * Created by Jasper on 2016/11/4.
 */
public class AuthIntercepter implements Interceptor {
    @Override
    public void intercept(Invocation invocation) {
        Controller controller = invocation.getController();
        boolean loginUser = (Boolean)controller.getSessionAttr("flag");
        if (loginUser == true) {
            invocation.invoke();
        } else {
            controller.redirect("/");
        }
    }
}

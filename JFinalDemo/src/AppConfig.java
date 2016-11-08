import com.jfinal.config.*;
import com.jfinal.kit.PropKit;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.druid.DruidPlugin;
import com.jfinal.render.ViewType;
import controller.IndexController;
import controller.UserController;
import model.User;

/**
 * Created by Jasper on 2016/11/4.
 */
public class AppConfig extends JFinalConfig {
    @Override
    public void configConstant(Constants constants) {
        constants.setEncoding("UTF-8");
        constants.setDevMode(true);
        constants.setViewType(ViewType.JSP);
    }

    @Override
    public void configRoute(Routes routes) {
        routes.add("/", IndexController.class);
        routes.add("/user", UserController.class);
    }

    @Override
    public void configPlugin(Plugins plugins) {
        //’‚¿Ô∆Ù”√JFinal plugin
        PropKit.use("jdbc.properties");
        final String URL = PropKit.get("url");
        final String USER = PropKit.get("user");
        final String PASSWORD = PropKit.get("password");
        final Integer INITIALSIZE = PropKit.getInt("initialSize");
        final Integer MINIDLE = PropKit.getInt("minIdle");
        final Integer MAXACTIVE = PropKit.getInt("maxActive");
        DruidPlugin druidPlugin = new DruidPlugin(URL, USER, PASSWORD);
        druidPlugin.set(INITIALSIZE, MINIDLE, MAXACTIVE);
        druidPlugin.setFilters("stat,wall");
        plugins.add(druidPlugin);
        ActiveRecordPlugin activeRecordPlugin = new ActiveRecordPlugin(druidPlugin);
        activeRecordPlugin.addMapping("user", "userid", User.class);
        plugins.add(activeRecordPlugin);
    }

    @Override
    public void configInterceptor(Interceptors interceptors) {

    }

    @Override
    public void configHandler(Handlers handlers) {

    }
}

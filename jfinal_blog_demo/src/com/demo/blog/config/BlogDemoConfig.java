package com.demo.blog.config;

import com.demo.blog.common._MappingKit;
import com.demo.blog.controller.BlogController;
import com.demo.blog.controller.IndexController;
import com.jfinal.config.*;
import com.jfinal.core.JFinal;
import com.jfinal.kit.PropKit;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.c3p0.C3p0Plugin;

/**
 * API引导式配置
 */
public class BlogDemoConfig extends JFinalConfig {
    /**
     * 配置常量
     */
    @Override
    public void configConstant(Constants constants) {
        // 加载少量必要配置，随后可用PropKit.get(...)获取值
        PropKit.use("jdbc.properties");
        constants.setDevMode(PropKit.getBoolean("devMode", false));
    }

    /**
     * 配置路由
     */
    @Override
    public void configRoute(Routes routes) {
        routes.add("/", IndexController.class, "/index");// 第三个参数为该Controller的视图存放路径
        routes.add("/blog", BlogController.class);       // 第三个参数省略时默认与第一个参数值相同，在此即为 "/blog"
    }

    public static C3p0Plugin createC3p0Plugin(){
        return new C3p0Plugin(PropKit.get("jdbcUrl"), PropKit.get("user"), PropKit.get("password").trim());
    }

    /**
     * 配置插件
     */
    @Override
    public void configPlugin(Plugins plugins) {
        // 配置C3p0数据库连接池插件
        C3p0Plugin c3p0Plugin = createC3p0Plugin();
        plugins.add(c3p0Plugin);

        // 配置ActiveRecord插件
        ActiveRecordPlugin activeRecordPlugin = new ActiveRecordPlugin(c3p0Plugin);
        plugins.add(activeRecordPlugin);

        // 所有配置在 MappingKit 中搞定
        _MappingKit.mapping(activeRecordPlugin);
    }

    /**
     * 配置全局拦截器
     */
    @Override
    public void configInterceptor(Interceptors me) {

    }

    /**
     * 配置处理器
     */
    @Override
    public void configHandler(Handlers me) {

    }

    /**
     * 建议使用 JFinal 手册推荐的方式启动项目
     * 运行此 main 方法可以启动项目，此main方法可以放置在任意的Class类定义中，不一定要放于此
    */

    public static void main(String[] args){
        JFinal.start("web", 80, "/", 5);
    }
}

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
 * API����ʽ����
 */
public class BlogDemoConfig extends JFinalConfig {
    /**
     * ���ó���
     */
    @Override
    public void configConstant(Constants constants) {
        // ����������Ҫ���ã�������PropKit.get(...)��ȡֵ
        PropKit.use("jdbc.properties");
        constants.setDevMode(PropKit.getBoolean("devMode", false));
    }

    /**
     * ����·��
     */
    @Override
    public void configRoute(Routes routes) {
        routes.add("/", IndexController.class, "/index");// ����������Ϊ��Controller����ͼ���·��
        routes.add("/blog", BlogController.class);       // ����������ʡ��ʱĬ�����һ������ֵ��ͬ���ڴ˼�Ϊ "/blog"
    }

    public static C3p0Plugin createC3p0Plugin(){
        return new C3p0Plugin(PropKit.get("jdbcUrl"), PropKit.get("user"), PropKit.get("password").trim());
    }

    /**
     * ���ò��
     */
    @Override
    public void configPlugin(Plugins plugins) {
        // ����C3p0���ݿ����ӳز��
        C3p0Plugin c3p0Plugin = createC3p0Plugin();
        plugins.add(c3p0Plugin);

        // ����ActiveRecord���
        ActiveRecordPlugin activeRecordPlugin = new ActiveRecordPlugin(c3p0Plugin);
        plugins.add(activeRecordPlugin);

        // ���������� MappingKit �и㶨
        _MappingKit.mapping(activeRecordPlugin);
    }

    /**
     * ����ȫ��������
     */
    @Override
    public void configInterceptor(Interceptors me) {

    }

    /**
     * ���ô�����
     */
    @Override
    public void configHandler(Handlers me) {

    }

    /**
     * ����ʹ�� JFinal �ֲ��Ƽ��ķ�ʽ������Ŀ
     * ���д� main ��������������Ŀ����main�������Է����������Class�ඨ���У���һ��Ҫ���ڴ�
    */

    public static void main(String[] args){
        JFinal.start("web", 80, "/", 5);
    }
}

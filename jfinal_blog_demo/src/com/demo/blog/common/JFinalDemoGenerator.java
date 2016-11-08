package com.demo.blog.common;

import com.demo.blog.config.BlogDemoConfig;
import com.jfinal.kit.PathKit;
import com.jfinal.kit.PropKit;
import com.jfinal.plugin.activerecord.generator.Generator;
import com.jfinal.plugin.c3p0.C3p0Plugin;

import javax.sql.DataSource;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * �����ݿ�����κα䶯ʱ������һ�� main ������������Ӧ�仯���д����ع�
 */
public class JFinalDemoGenerator {
    public static DataSource getDataSource(){
        PropKit.use("jdbc.properties");
        C3p0Plugin c3p0Plugin = BlogDemoConfig.createC3p0Plugin();
        c3p0Plugin.start();

        return c3p0Plugin.getDataSource();
    }


    public static void main(String[] args) {
        // base model ��ʹ�õİ���
        String baseModelPackageName = "com.demo.blog.model";
        // base model �ļ�����·��
        String baseModelOutputDir = PathKit.getWebRootPath() + "/../src/com/demo/common/model/base";

        // model ��ʹ�õİ��� (MappingKit Ĭ��ʹ�õİ���)
        String modelPackageName = "com.demo.common.model";
        // model �ļ�����·�� (MappingKit �� DataDictionary �ļ�Ĭ�ϱ���·��)
        String modelOutputDir = baseModelOutputDir + "/..";

        // ����������
        Generator gernerator = new Generator(getDataSource(), baseModelPackageName, baseModelOutputDir, modelPackageName, modelOutputDir);
        // ��Ӳ���Ҫ���ɵı���
        gernerator.addExcludedTable("adv");
        // �����Ƿ��� Model ������ dao ����
        gernerator.setGenerateDaoInModel(true);
        // �����Ƿ������ֵ��ļ�
        gernerator.setGenerateDataDictionary(false);
        // ������Ҫ���Ƴ��ı���ǰ׺��������modelName��������� "osc_user"���Ƴ�ǰ׺ "osc_"�����ɵ�model��Ϊ "User"���� OscUser
        gernerator.setRemovedTableNamePrefixes("t_");
        // ����
        gernerator.generate();
    }
}

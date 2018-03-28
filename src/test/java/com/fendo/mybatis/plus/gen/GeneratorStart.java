/**
 * projectName: xxxx
 * fileName: GeneratorStart.java
 * packageName: com.fendo.shiro.generator
 * date: 2018-01-15 19:59
 * copyright(c) 2017-2020 xxx公司
 */
package com.fendo.mybatis.plus.gen;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.builder.ConfigBuilder;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @version: V1.0
 * @author: fendo
 * @className: GeneratorStart
 * @packageName: com.xx.modules.gen
 * @description: 代码生成器
 * @data: 2018-01-15 19:59
 **/
public class GeneratorStart {

    public static void main(String[] args) {
        String packageName = "com.gzsys.modules.yun";
        boolean serviceNameStartWithI = false;//user -> UserService, 设置成true: user -> IUserService
        generateByTables(serviceNameStartWithI, packageName, "USER_LOGIN");
    }

    private static void generateByTables(boolean serviceNameStartWithI, String packageName, String... tableNames) {
        // 全局配置
        GlobalConfig config = new GlobalConfig();
        AutoGenerator mpg = new AutoGenerator();
        String dbUrl = "jdbc:oracle:thin:@//106.14.160.67:1521/test";
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setDbType(DbType.ORACLE)
                .setUrl(dbUrl)
                .setUsername("test")
                .setPassword("Eru43wPo")
                .setDriverName("oracle.jdbc.driver.OracleDriver");
        // 策略配置
        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig
                .setCapitalMode(true) // 全局大写命名 ORACLE 注意
                .setEntityLombokModel(false) //实体 是否为lombok模型（默认 false）
                .setDbColumnUnderline(true) //表名、字段名、是否使用下划线命名
                .setNaming(NamingStrategy.underline_to_camel) //表名生成策略
                .setInclude(tableNames);//修改替换成你需要的表名，多个表名传数组
        // strategyConfig.setExclude(new String[]{"test"}); // 排除生成的表
        // 自定义实体父类
        strategyConfig.setSuperEntityClass("com.gzsys.common.persistence.BaseEntity");
        // 自定义实体，公共字段
        strategyConfig.setSuperEntityColumns(new String[] { "ID", "CREATE_TIME", "CREATE_NAME" , "UPDATE_TIME", "UPDATE_NAME", "STATE"});
        // 自定义 mapper 父类
        // strategyConfig.setSuperMapperClass("com.baomidou.demo.TestMapper");
        // 自定义 service 父类
        //strategyConfig.setSuperServiceClass("com.baomidou.demo.TestService");
        // 自定义 service 实现类父类
        //strategyConfig.setSuperServiceImplClass("com.baomidou.demo.TestServiceImpl");
        // 自定义 controller 父类
        strategyConfig.setSuperControllerClass("com.gzsys.common.base.controller.BaseController");
        // 【实体】是否生成字段常量（默认 false）
        // public static final String ID = "test_id";
        // strategyConfig.setEntityColumnConstant(true);
        // 【实体】是否为构建者模型（默认 false）
        // public User setName(String name) {this.name = name; return this;}
        // strategyConfig.setEntityBuliderModel(true);


        config.setActiveRecord(true) //是否 开启 ActiveRecord 模式
                .setAuthor("fendo")
                .setOutputDir("d:\\codeGen")
                .setFileOverride(true)
                .setActiveRecord(true)
                .setEnableCache(false)// XML 二级缓存
                .setBaseResultMap(true)// XML ResultMap
                .setBaseColumnList(false);// XML columList

        if (!serviceNameStartWithI) {
            config.setServiceName("%sService"); //自定义Service后戳,注意 %s 会自动填充表实体属性！
        }

        // 注入自定义配置，可以在 VM 中使用 cfg.abc 【可无】
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("abc", this.getConfig().getGlobalConfig().getAuthor() + "-mp");
                this.setMap(map);
            }
        };


        // 自定义 xxList.jsp 生成
        List<FileOutConfig> focList = new ArrayList<FileOutConfig>();
        //focList.add(new FileOutConfig("/template/list.jsp.vm") {
        //    @Override
        //    public String outputFile(TableInfo tableInfo) {
        //        // 自定义输入文件名称
        //        return "D://my_" + tableInfo.getEntityName() + ".jsp";
        //    }
        //});
        //cfg.setFileOutConfigList(focList);
        //mpg.setCfg(cfg);

        // 调整 xml 生成目录演示
        focList.add(new FileOutConfig("/templates/mapper.xml.vm") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return "d:\\codeGen/resources/mapping/modules/yun/" + tableInfo.getEntityName() + ".xml";
            }
        });
        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);

        // 关闭默认 xml 生成，调整生成 至 根目录
        TemplateConfig tc = new TemplateConfig();
        tc.setXml(null);
        mpg.setTemplate(tc);

        // 自定义模板配置，可以 copy 源码 mybatis-plus/src/main/resources/templates 下面内容修改，
        // 放置自己项目的 src/main/resources/templates 目录下, 默认名称一下可以不配置，也可以自定义模板名称
        // TemplateConfig tc = new TemplateConfig();
        // tc.setController("...");
        // tc.setEntity("...");
        // tc.setMapper("...");
        // tc.setXml("...");
        // tc.setService("...");
        // tc.setServiceImpl("...");
        // 如上任何一个模块如果设置 空 OR Null 将不生成该模块。
        // mpg.setTemplate(tc);

        //生成文件 配置
        mpg.setGlobalConfig(config)  //全局 相关配置
                .setDataSource(dataSourceConfig) //数据源配置
                .setStrategy(strategyConfig) //数据库表配置
                .setPackageInfo( //包 相关配置
                        new PackageConfig()  //跟包相关的配置项
                                .setParent(packageName)  //父包名。如果为空，将下面子包名必须写全部， 否则就只需写子包名
                                .setController("controller") //Controller包名
                                .setEntity("entity") //entity包名
                                //.setXml("/")
                )
                .execute();
    }

    private void generateByTables(String packageName, String... tableNames) {
        generateByTables(true, packageName, tableNames);
    }

}

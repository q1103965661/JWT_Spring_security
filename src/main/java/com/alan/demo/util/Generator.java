package com.alan.demo.util;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

/**
 * @author alan wang
 * @version 1.0
 * @date 2019/9/3 8:40
 */
public class Generator {
    public static void main(String[] args) {
        String packageName = "com.alan.demo";
        boolean serviceNameStartWithI = false;
        generateByTables(serviceNameStartWithI, packageName, "Alan wang", "test", "user");
    }

    /**
     *
     * @param serviceNameStartWithI
     * @param packageName 包名
     * @param author  作者
     * @param database 数据库名称
     * @param tableNames 表名
     */
    private static void generateByTables(boolean serviceNameStartWithI, String packageName, String author, String database, String tableNames) {
        GlobalConfig config = new GlobalConfig();
        String dbUrl = "jdbc:mysql://127.0.0.1:3306/" + database + "?useUnicode=true&characterEncoding=utf8&autoReconnect=true&useSSL=false";
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setDbType(DbType.MYSQL)
                .setUrl(dbUrl)
                .setUsername("root")
                .setPassword("root")
                .setDriverName("com.mysql.jdbc.Driver");
        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig
                .setCapitalMode(true)
                .setEntityBuilderModel(false)
                .setDbColumnUnderline(true)
                .setNaming(NamingStrategy.underline_to_camel)
                .setSuperMapperClass("com.alan.demo.mapper.BaseMapper")
                .setInclude(tableNames);

        config.setActiveRecord(false)
                .setAuthor(author)
                .setOutputDir("D:\\codeGen")
                .setFileOverride(true)
                .setEnableCache(false);
        if (!serviceNameStartWithI){
            config.setServiceName("%sService");
        }
        new AutoGenerator().setGlobalConfig(config)
                .setDataSource(dataSourceConfig)
                .setStrategy(strategyConfig)
                .setPackageInfo(
                        new PackageConfig()
                        .setParent(packageName)
                        .setController("web")
                        .setEntity("domain")
                        .setMapper("mapper")
                        .setService("service")
                        .setServiceImpl("service.impl")
                        .setXml("mybatis.mappers")
                ).execute();
    }
}

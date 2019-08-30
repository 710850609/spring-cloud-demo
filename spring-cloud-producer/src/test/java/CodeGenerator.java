//import com.baomidou.mybatisplus.annotation.DbType;
//import com.baomidou.mybatisplus.core.toolkit.StringPool;
//import com.baomidou.mybatisplus.generator.AutoGenerator;
//import com.baomidou.mybatisplus.generator.InjectionConfig;
//import com.baomidou.mybatisplus.generator.config.*;
//import com.baomidou.mybatisplus.generator.config.po.TableInfo;
//import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
//import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
//
//import java.io.IOException;
//import java.io.InputStream;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Properties;
//
///**
// * @author LinBo
// */
//public class CodeGenerator {
//
//    private static String url = "";
//    private static String driver = "";
//    private static String user = "";
//    private static String password = "";
//    private static String outputDir = "";
//    private static String basePackageName = "";
//    private static String packageName = "";
//    private static String tableName = "user";
//    private static String schemaName = "";
//
//    private static void loadConfig() throws IOException {
//        Properties properties = new Properties();
//        InputStream in = CodeGenerator.class.getClassLoader().getResourceAsStream("config.properties");
//        properties.load(in);
//        url = properties.getProperty("url");
//        driver = properties.getProperty("driver");
//        user = properties.getProperty("user");
//        password = properties.getProperty("password");
//        outputDir = properties.getProperty("outputDir");
//        basePackageName = properties.getProperty("basePackageName");
//        packageName = properties.getProperty("packageName");
//        schemaName = properties.getProperty("schemaName");
//    }
//
//    public static void main(String[] args) throws IOException {
//        loadConfig();
//        // 代码生成器
//        AutoGenerator mpg = new AutoGenerator();
//
//        // 全局配置
//        GlobalConfig gc = new GlobalConfig();
//        gc.setOutputDir(outputDir + "/src/main/java");
//        gc.setAuthor("林勃");
//        gc.setOpen(false);
//        gc.setFileOverride(true);
//        gc.setBaseResultMap(true);
//        gc.setBaseColumnList(true);
//        mpg.setGlobalConfig(gc);
//
//        // 数据源配置
//        DataSourceConfig dsc = new DataSourceConfig();
//        dsc.setUrl(url);
//        dsc.setDriverName(driver);
//        dsc.setUsername(user);
//        dsc.setPassword(password);
//        dsc.setDbType(DbType.H2);
//        dsc.setSchemaName(schemaName);
//        mpg.setDataSource(dsc);
//
//        // 包配置
//        PackageConfig pc = new PackageConfig();
//        pc.setModuleName(packageName);
//        pc.setParent(basePackageName);
//        mpg.setPackageInfo(pc);
//
//        // 自定义配置
//        InjectionConfig cfg = new InjectionConfig() {
//            @Override
//            public void initMap() {
//                // to do nothing
//            }
//        };
//        List<FileOutConfig> focList = new ArrayList<>();
//        focList.add(new FileOutConfig("/templates/mapper.xml.ftl") {
//            @Override
//            public String outputFile(TableInfo tableInfo) {
//                // 自定义输入文件名称
//                return outputDir + "/src/main/resources/mapper/" + pc.getModuleName()
//                        + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
//            }
//        });
//        cfg.setFileOutConfigList(focList);
//        mpg.setCfg(cfg);
//        mpg.setTemplate(new TemplateConfig().setXml(null));
//
//        // 策略配置
//        StrategyConfig strategy = new StrategyConfig();
//        strategy.setNaming(NamingStrategy.underline_to_camel);
//        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
////        strategy.setSuperEntityClass("com.baomidou.ant.common.BaseEntity");
//        strategy.setEntityLombokModel(true);
//        strategy.setRestControllerStyle(true);
////        strategy.setSuperControllerClass("com.baomidou.ant.common.BaseController");
//        strategy.setInclude(tableName);
//        strategy.setSuperEntityColumns("id");
//        strategy.setControllerMappingHyphenStyle(true);
//        strategy.setTablePrefix(pc.getModuleName() + "_");
//        mpg.setStrategy(strategy);
//        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
//        mpg.execute();
//    }
//}

/**
 * projectName: fendo-plus-boot
 * fileName: SwaggerConfig.java
 * packageName: com.gzsys.common.config
 * date: 2018-02-01 1:14
 * copyright(c) 2017-2020 xxx公司
 */
package com.fendo.mybatis.plus.config;

//import springfox.documentation.service.Contact;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.annotations.ApiIgnore;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @version: V1.0
 * @author: fendo
 * @className: SwaggerConfig
 * @packageName: com.fendo.mybatis.plus.config
 * @description: Swagger配置文件
 * @data: 2018-02-01 1:14
 **/
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    public static final String VERSION = "1.0.0";
    public static final String AUTHOR = "fendo";

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .groupName("基础模块")
                .select()
                //加了ApiOperation注解的方法，生成接口文档
                .apis(RequestHandlerSelectors.basePackage("com.fendo.mybatis.plus"))
                //可以根据url路径设置哪些请求加入文档，忽略哪些请求
                .paths(PathSelectors.any())
                .build();
                //.ignoredParameterTypes(ApiIgnore.class)
                //.enableUrlTemplating(true);
    }

    @Bean
    public Docket createMonitorRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .groupName("权限模块")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.fendo.mybatis.plus"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                //设置文档的标题
                .title("API文档")
                //设置文档的描述
                .description("mybatis-plus项目API文档")
                .termsOfServiceUrl("http://blog.csdn.net/u011781521?viewmode=contents")
                //设置文档的版本信息
                .version(VERSION)
                //作者信息
                //.contact(new Contact(AUTHOR, "http://blog.csdn.net/u011781521", "2312892206@qq.com"))
                .contact(AUTHOR)
                //设置文档的License信息
                .termsOfServiceUrl("http://blog.csdn.net/u011781521?viewmode=contents")
                .license("The Apache License, Version 2.0")
                .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
                .build();
    }

}

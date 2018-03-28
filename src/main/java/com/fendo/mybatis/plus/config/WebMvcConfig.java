/**
 * projectName: mybatis-plus
 * fileName: WebMvcConfig.java
 * packageName: com.fendo.mybatis.plus.config
 * date: 2018-03-26 16:09
 * copyright(c) 2017-2020 xxx公司
 */
package com.fendo.mybatis.plus.config;

import com.fendo.mybatis.plus.common.converter.UniversalEnumConverterFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @version: V1.0
 * @author: fendo
 * @className: WebMvcConfig
 * @packageName: com.fendo.mybatis.plus.config
 * @description: MVC配置
 * @data: 2018-03-26 16:09
 **/
@Configuration
class WebMvcConfig extends WebMvcConfigurerAdapter {

    /**
     * 开启方法上校验
     * @return
     */
    @Bean
    public MethodValidationPostProcessor methodValidationPostProcessor() {
        return new MethodValidationPostProcessor();
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");

    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverterFactory(new UniversalEnumConverterFactory());
    }
}
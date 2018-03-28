/**
 * projectName: mybatis-plus
 * fileName: Swagger2MarkupTest.java
 * packageName: com.fendo.mybatis.plus.swagger
 * date: 2018-03-27 14:56
 * copyright(c) 2017-2020 xxx公司
 */
package com.fendo.mybatis.plus.swagger;


import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.alibaba.fastjson.JSONObject;
import com.fendo.mybatis.plus.MybatisPlusApplication;
import com.fendo.mybatis.plus.crud.base.TestBase;
import io.github.swagger2markup.GroupBy;
import io.github.swagger2markup.Language;
import io.github.swagger2markup.Swagger2MarkupConfig;
import io.github.swagger2markup.Swagger2MarkupConverter;
import io.github.swagger2markup.builder.Swagger2MarkupConfigBuilder;
import io.github.swagger2markup.markup.builder.MarkupLanguage;
import io.swagger.models.Swagger;
import io.swagger.parser.Swagger20Parser;
import org.junit.runner.RunWith;
import com.fendo.mybatis.plus.config.SwaggerConfig;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.io.BufferedWriter;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @version: V1.0
 * @author: fendo
 * @className: Swagger2MarkupTest
 * @packageName: com.fendo.mybatis.plus.swagger
 * @description: Swagger2Markup测试
 * @data: 2018-03-27 14:56
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@AutoConfigureRestDocs(outputDir = "target/generated-snippets")
@SpringBootTest(classes = MybatisPlusApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class Swagger2MarkupTest extends TestBase {

    private String snippetDir = "target/generated-snippets";
    private String outputDir = "target/asciidoc";

    private static final Logger LOG = LoggerFactory.getLogger(Swagger2MarkupTest.class);


    @Test
    public void createSpringFoxSwaggerJson() throws Exception {
        //String designFirstSwaggerLocation = Swagger2MarkupTest.class.getResource("/swagger.yaml").getPath();

//        String outputDir = System.getProperty("io.springfox.staticdocs.outputDir"); // mvn test
        String outputDir = "D:\\fendo_project_work\\mybatis-plus\\target\\swagger"; // run as

        LOG.info("--------------------outputDir: {}--------------------", outputDir);

        JSONObject result = httpGet("/v2/api-docs");
        Files.createDirectories(Paths.get(outputDir));
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(outputDir, "swagger.json"), StandardCharsets.UTF_8)){
            writer.write(result.toJSONString());
        }
        LOG.info("--------------------swaggerJson create --------------------");
    }

    @Test
    public void generateAsciiDocs() throws Exception {
        //    输出Ascii格式
        //Swagger2MarkupConfig config = new Swagger2MarkupConfigBuilder()
        //        .withMarkupLanguage(MarkupLanguage.ASCIIDOC)
        //        .build();

        Path outputFile = Paths.get("/src/docs/asciidoc/generated");
        Swagger2MarkupConfig config = new Swagger2MarkupConfigBuilder()
                .withMarkupLanguage(MarkupLanguage.MARKDOWN)
                .withOutputLanguage(Language.ZH)
                .withPathsGroupedBy(GroupBy.TAGS)
                .build();

        JSONObject result = httpGet("/v2/api-docs?group=实时监测");

        //Swagger2MarkupConverter converter = Swagger2MarkupConverter.from(new URL("http://localhost:8080/v2/api-docs?group=实时监测")).withConfig(config).build();
        //converter.toFile(outputFile);

        Swagger20Parser parser = new Swagger20Parser();
        Swagger swagger = parser.parse(result.toJSONString());
        Swagger2MarkupConverter.from(swagger)
                .withConfig(config)
                .build()
                .toFolder(Paths.get("src/docs/asciidoc/generated"));

    }

}

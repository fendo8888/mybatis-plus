/**
 * projectName: mybatis-plus
 * fileName: UserCtrlTest.java
 * packageName: com.fendo.mybatis.plus.crud.base
 * date: 2018-03-24 19:44
 * copyright(c) 2017-2020 xxx公司
 */
package com.fendo.mybatis.plus.crud.base;

import com.alibaba.fastjson.JSONObject;
import com.fendo.mybatis.plus.MybatisPlusApplication;
import com.fendo.mybatis.plus.config.SwaggerConfig;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @version: V1.0
 * @author: fendo
 * @className: UserCtrlTest
 * @packageName: com.fendo.mybatis.plus.crud.base
 * @description: 使用rest-assured框架，测试controller
 * @data: 2018-03-24 19:44
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {MybatisPlusApplication.class, SwaggerConfig.class}, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserCtrlTest extends TestBase{

    @Test
    public void testCrud() {
        JSONObject result = httpGet("/user/crud");
    }

    @Test
    public void testUserListPage() {
        JSONObject result = httpGet("/user/page");
        Integer total = result.getInteger("total");
        System.out.println(result);
        Assert.assertTrue(0 != total);
        Assert.assertNotNull(result.get("records"));
    }

}

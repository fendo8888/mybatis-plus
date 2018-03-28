/**
 * projectName: mybatis-plus
 * fileName: TestBase.java
 * packageName: com.fendo.mybatis.plus.crud.base
 * date: 2018-03-24 19:33
 * copyright(c) 2017-2020 xxx公司
 */
package com.fendo.mybatis.plus.crud.base;

import static com.jayway.restassured.RestAssured.given;

import java.util.UUID;

import org.hamcrest.Matcher;
import org.junit.Before;
import org.mockito.internal.matchers.Equals;
import org.springframework.beans.factory.annotation.Value;

import com.alibaba.fastjson.JSONObject;
import com.jayway.restassured.RestAssured;

/**
 * @version: V1.0
 * @author: fendo
 * @className: TestBase
 * @packageName: com.fendo.mybatis.plus.crud.base
 * @description: 测试基类
 * @data: 2018-03-24 19:33
 **/
public abstract class TestBase {

    @Value("${local.server.port}")
    int port;

    @Before
    public void doBefore() {
        RestAssured.port = port;//4: 告诉restAssured使用哪个端口来访问
    }



    protected String generateUUID(){
        return UUID.randomUUID().toString().replace("-", "");
    }

    public static JSONObject httpGet(String httpUrl) {
        return
                JSONObject.parseObject(
                        given().request()
                                .when().get(httpUrl)
                                .then()
                                .extract().asString()
                );
    }

    public static JSONObject httpGet(String httpUrl, Matcher matcher) {
        return
                JSONObject.parseObject(
                        given().request()
                                .when().get(httpUrl)
                                .then()
                                .statusCode(matcher)
                                .extract().asString()
                );
    }

    public static JSONObject httpPost(String httpUrl, JSONObject parm) {
        return
                JSONObject.parseObject(
                        given().contentType("application/json")
                                .request().body(parm == null ? null : parm.toJSONString())
                                .when().post(httpUrl)
                                .then()
                                .extract().asString()
                );
    }

    public static JSONObject httpPost(String httpUrl, JSONObject parm, Matcher matcher) {
        return
                JSONObject.parseObject(
                        given().contentType("application/json")
                                .request().body(parm == null ? null : parm.toJSONString())
                                .when().post(httpUrl)
                                .then()
                                .statusCode(matcher)
                                .extract().asString()
                );
    }

    public static JSONObject httpPut(String httpUrl, JSONObject parm) {
        return
                JSONObject.parseObject(
                        given().contentType("application/json")
                                .request().body(parm == null ? null : parm.toJSONString())
                                .when().put(httpUrl)
                                .then()
                                .extract().asString()
                );
    }

    public static JSONObject httpDelete(String httpUrl, JSONObject parm) {
        return
                JSONObject.parseObject(
                        given().contentType("application/json")
                                .request().body(parm == null ? null : parm.toJSONString())
                                .when().delete(httpUrl)
                                .then()
                                .extract().asString()
                );
    }
}

/**
 * projectName: mybatis-plus
 * fileName: UserRequest.java
 * packageName: com.fendo.mybatis.plus.request
 * date: 2018-03-27 9:40
 * copyright(c) 2017-2020 xxx公司
 */
package com.fendo.mybatis.plus.request;

import com.fendo.mybatis.plus.common.validation.annotation.GenderAnnotation;
import com.fendo.mybatis.plus.entity.enums.AgeEnum;
import com.fendo.mybatis.plus.entity.enums.GenderEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @version: V1.0
 * @author: fendo
 * @className: UserRequest
 * @packageName: com.fendo.mybatis.plus.request
 * @description: 用户请求数据
 * @data: 2018-03-27 9:40
 **/
@ApiModel(value="User对象",description="用户信息")
public class UserRequest implements Serializable{

    private static final long serialVersionUID = 1L;

    /**
     * 名称
     */
    @NotEmpty(message="用户姓名不能为空！")
    @ApiModelProperty(value = "用户姓名",name="name",example="Fendo")
    private String name;
    /**
     * 年龄
     */
    @NotNull(message="用户年龄不能为空！")
    //@ApiModelProperty(value = "用户年龄",name="age",example="2")
    private AgeEnum age;

    /**
     * 性别
     */
    @GenderAnnotation(message = "必须是男人")
    //@ApiModelProperty(value = "用户性别",name="sex",example="1")
    private GenderEnum sex;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AgeEnum getAge() {
        return age;
    }

    public void setAge(AgeEnum age) {
        this.age = age;
    }

    public GenderEnum getSex() {
        return sex;
    }

    public void setSex(GenderEnum sex) {
        this.sex = sex;
    }
}

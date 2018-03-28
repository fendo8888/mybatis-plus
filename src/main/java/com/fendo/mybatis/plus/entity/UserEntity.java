/**
 * projectName: mybatis-plus
 * fileName: UserEntity.java
 * packageName: com.fendo.mybatis.plus.entity.enums
 * date: 2018-03-24 18:11
 * copyright(c) 2017-2020 xxx公司
 */
package com.fendo.mybatis.plus.entity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fendo.mybatis.plus.common.persistent.BaseEntity;
import com.fendo.mybatis.plus.entity.enums.AgeEnum;
import com.fendo.mybatis.plus.entity.enums.GenderEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

/**
 * @version: V1.0
 * @author: fendo
 * @className: UserEntity
 * @packageName: com.fendo.mybatis.plus.entity.enums
 * @description: 用户类
 * @data: 2018-03-24 18:11
 **/
@TableName("user")
@ApiModel(value="User对象",description="用户信息")
public class UserEntity extends BaseEntity<UserEntity> {

    /**
     * 名称
     */
    @ApiModelProperty(value = "用户姓名",name="name",example="fendo")
    private String name;
    /**
     * 年龄
     */
    @ApiModelProperty(value = "用户年龄",name="age",example="2")
    @Max(150)
    @Min(1)
    private AgeEnum age;

    /**
     * 性别
     */
    @ApiModelProperty(value = "用户性别",name="sex",example="1")
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

    public UserEntity() {
    }

    public UserEntity(String name, AgeEnum age, GenderEnum sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public UserEntity(String id, String name, AgeEnum age, GenderEnum sex) {
        this.setId(id);
        this.name = name;
        this.age = age;
        this.sex = sex;
    }


}

/**
 * projectName: mybatis-plus
 * fileName: GenderEnum.java
 * packageName: com.fendo.mybatis.plus.entity.enums
 * date: 2018-03-24 18:07
 * copyright(c) 2017-2020 xxx公司
 */
package com.fendo.mybatis.plus.entity.enums;

import com.baomidou.mybatisplus.enums.IEnum;
import com.fasterxml.jackson.annotation.JsonValue;

import java.io.Serializable;

/**
 * @version: V1.0
 * @author: fendo
 * @className: GenderEnum
 * @packageName: com.fendo.mybatis.plus.entity.enums
 * @description: 性别
 * @data: 2018-03-24 18:07
 **/
public enum GenderEnum implements IEnum{

    MALE(1,"男"),
    FEMALE(2,"女");

    private int value;
    private String desc;

    GenderEnum(int value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    @Override
    public Serializable getValue() {
        return this.desc;
    }

    @JsonValue
    public String getDesc(){
        return this.desc;
    }

}

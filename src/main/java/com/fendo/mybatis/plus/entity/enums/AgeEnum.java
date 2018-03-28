/**
 * projectName: mybatis-plus
 * fileName: AgeEnum.java
 * packageName: com.fendo.mybatis.plus.entity.enums
 * date: 2018-03-24 18:16
 * copyright(c) 2017-2020 xxx公司
 */
package com.fendo.mybatis.plus.entity.enums;

import com.baomidou.mybatisplus.enums.IEnum;
import com.fasterxml.jackson.annotation.JsonValue;

import java.io.Serializable;

/**
 * @version: V1.0
 * @author: fendo
 * @className: AgeEnum
 * @packageName: com.fendo.mybatis.plus.entity.enums
 * @description: 年龄
 * @data: 2018-03-24 18:16
 **/
public enum AgeEnum implements IEnum {

    ONE(1, "一岁"),
    TWO(2, "二岁");

    private int value;
    private String desc;

    AgeEnum(final int value, final String desc) {
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

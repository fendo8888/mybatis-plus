/**
 * projectName: mybatis-plus
 * fileName: EnumUtil.java
 * packageName: com.fendo.mybatis.plus.common.utils
 * date: 2018-03-27 9:23
 * copyright(c) 2017-2020 xxx公司
 */
package com.fendo.mybatis.plus.common.utils;

import com.baomidou.mybatisplus.enums.IEnum;
import com.fendo.mybatis.plus.common.constant.Constant;

/**
 * @version: V1.0
 * @author: fendo
 * @className: EnumUtil
 * @packageName: com.fendo.mybatis.plus.common.utils
 * @description: 枚举工具类
 * @data: 2018-03-27 9:23
 **/
public class EnumUtil {

    /**
     * 获取value返回枚举对象
     * @param value
     * @param clazz
     * */
    public static <T extends IEnum>  T getEnumObject(Object value, Class<T> clazz){
        return (T) Constant.ENUM_MAP.get(clazz).get(value);
    }
}

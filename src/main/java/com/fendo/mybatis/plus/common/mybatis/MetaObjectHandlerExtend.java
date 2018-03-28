/**
 * projectName: mybatis-plus
 * fileName: MetaObjectHandlerExtend.java
 * packageName: com.fendo.mybatis.plus.common.mybatis
 * date: 2018-03-27 11:21
 * copyright(c) 2017-2020 xxx公司
 */
package com.fendo.mybatis.plus.common.mybatis;

import com.baomidou.mybatisplus.mapper.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;

import java.util.Date;

/**
 * @version: V1.0
 * @author: fendo
 * @className: MetaObjectHandlerExtend
 * @packageName: com.fendo.mybatis.plus.common.mybatis
 * @description: MetaObjectHandler扩展，自定义填充公共字段 ,即没有传的字段自动填充
 * @data: 2018-03-27 11:21
 **/
public class MetaObjectHandlerExtend extends MetaObjectHandler {

    /**
     * 新增填充
     * @param metaObject
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        Object createDate = metaObject.getValue("createDate");
        if (null == createDate) {
            metaObject.setValue("delFlag", "0");
            metaObject.setValue("createDate", new Date());
            metaObject.setValue("updateDate", new Date());
        }

    }

    /**
     * 更新填充
     * @param metaObject
     */
    @Override
    public void updateFill(MetaObject metaObject) {
        Object createDate = metaObject.getValue("updateDate");
        if (null == createDate) {
            metaObject.setValue("updateDate", new Date());
        }
    }
}

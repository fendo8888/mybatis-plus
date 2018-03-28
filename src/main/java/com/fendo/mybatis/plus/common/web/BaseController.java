/**
 * projectName: mybatis-plus
 * fileName: BaseController.java
 * packageName: com.fendo.mybatis.plus.common.web
 * date: 2018-03-27 10:27
 * copyright(c) 2017-2020 xxx公司
 */
package com.fendo.mybatis.plus.common.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

/**
 * @version: V1.0
 * @author: fendo
 * @className: BaseController
 * @packageName: com.fendo.mybatis.plus.common.web
 * @description: Controller基类
 * @data: 2018-03-27 10:27
 **/
public abstract class BaseController{

    @Autowired
    public Validator validator;

    protected Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 服务端参数有效性验证
     * @param object 验证的实体对象
     * @param groups 验证组
     * @return 验证成功：返回true；验证失败：将错误信息返回
     */
    @SuppressWarnings("rawtypes")
    public static  String validates(Validator validator, Object object, Class<?>... groups) {
        Set<ConstraintViolation<Object>> constraintViolations = validator.validate(object, groups);
        if (!constraintViolations.isEmpty()) {
            StringBuffer sb=new StringBuffer();
            for (ConstraintViolation constraintViolation : constraintViolations) {
                sb.append(constraintViolation.getMessage());
            }
            return sb.toString();
        }
        return null;
    }


}

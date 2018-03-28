/**
 * projectName: mybatis-plus
 * fileName: GenderAnnotation.java
 * packageName: com.fendo.mybatis.plus.common.validation
 * date: 2018-03-27 9:50
 * copyright(c) 2017-2020 xxx公司
 */
package com.fendo.mybatis.plus.common.validation.annotation;

import com.fendo.mybatis.plus.common.validation.CheckValidator;
import com.fendo.mybatis.plus.entity.enums.GenderEnum;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @version: V1.0
 * @author: fendo
 * @className: GenderAnnotation
 * @packageName: com.fendo.mybatis.plus.common.validation
 * @description: 性别验证
 * @data: 2018-03-27 9:50
 **/
@Target({ ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CheckValidator.class)//处理的类
public @interface GenderAnnotation {

    String message() default "必须是男人";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    GenderEnum value() default GenderEnum.MALE;

}

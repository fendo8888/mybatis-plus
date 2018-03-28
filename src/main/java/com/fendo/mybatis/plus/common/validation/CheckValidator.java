/**
 * projectName: mybatis-plus
 * fileName: CheckValidator.java
 * packageName: com.fendo.mybatis.plus.common.validation
 * date: 2018-03-27 9:57
 * copyright(c) 2017-2020 xxx公司
 */
package com.fendo.mybatis.plus.common.validation;

import com.baomidou.mybatisplus.enums.IEnum;
import com.fendo.mybatis.plus.common.validation.annotation.GenderAnnotation;
import com.fendo.mybatis.plus.entity.enums.AgeEnum;
import com.fendo.mybatis.plus.entity.enums.GenderEnum;
import com.fendo.mybatis.plus.request.UserRequest;
import javax.validation.*;
import java.lang.annotation.Annotation;
import java.util.Set;

/**
 * @version: V1.0
 * @author: fendo
 * @className: CheckValidator
 * @packageName: com.fendo.mybatis.plus.common.validation
 * @description: 自定义Validator验证
 * @data: 2018-03-27 9:57
 **/
public class CheckValidator implements ConstraintValidator<Annotation, Object> {

    private String value;
    private IEnum enums;
    private int annotationType;

    private final static String ONE="1";
    private final static String TWO="2";

    @Override
    public void initialize(Annotation annotation) {
        if (annotation instanceof GenderAnnotation) {
            annotationType = 0;
            GenderAnnotation genderAnnotation = (GenderAnnotation) annotation;
            //获取注解的值
            this.enums = genderAnnotation.value();
        }
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        boolean falg = false;
        switch (annotationType){
            case 0:{
                try {

                    if(!(enums instanceof  IEnum) || enums ==null){
                            return false;
                    }else{
                            if(enums.getValue().equals(TWO)){
                                return false;
                            }
                            return true;//必须是男的
                    }

                }catch (Exception e){
                    e.printStackTrace();
                }
                break;
            }
            case 1:{
                break;
            }
            default:
                return falg;
        }
        return falg;
    }

    public static void main(String[] args) {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();
        UserRequest userRequest = new UserRequest();
        userRequest.setName("fendo");
        userRequest.setAge(AgeEnum.ONE);
        userRequest.setSex(GenderEnum.FEMALE);
        pringValidateStr(validator.validate(userRequest));
    }

    public static void pringValidateStr(Set<ConstraintViolation<UserRequest>> set2) {
        for (ConstraintViolation<UserRequest> constraintViolation : set2){
            System.out.println("错误：" + constraintViolation.getMessage());
            System.out.println("字段："+constraintViolation.getPropertyPath().toString());

        }
    }

}

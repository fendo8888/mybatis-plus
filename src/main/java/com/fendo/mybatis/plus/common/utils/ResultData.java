/**
 * projectName: mybatis-plus
 * fileName: ResultData.java
 * packageName: com.fendo.mybatis.plus.common.utils
 * date: 2018-03-27 10:38
 * copyright(c) 2017-2020 xxx公司
 */
package com.fendo.mybatis.plus.common.utils;

import com.fendo.mybatis.plus.entity.UserEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @version: V1.0
 * @author: fendo
 * @className: ResultData
 * @packageName: com.fendo.mybatis.plus.common.utils
 * @description: 返回数据
 * @data: 2018-03-27 10:38
 **/
@ApiModel
public class ResultData <T> implements Serializable {

    private static final long serialVersionUID = -7424426799887924229L;

    @ApiModelProperty(value = "错误码")
    private String code;

    @ApiModelProperty(value = "数据对象")
    private T data;

    @ApiModelProperty(value = "错误码描述")
    private String message;

    public ResultData(CustomPage<UserEntity> customPage) {
    }

    public ResultData(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public ResultData(SimpleCode simpleCode) {
        this.code = simpleCode.getCode();
        this.message = simpleCode.getMessage();
    }



    public ResultData(String code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public ResultData(SimpleCode simpleCode, T data) {
        this.code = simpleCode.getCode();
        this.message = simpleCode.getMessage();
        this.data = data;
    }

    public ResultData(Boolean falg, T data) {
        if(falg){
            this.code = SimpleCode.SUCCESS.getCode();
            this.message = SimpleCode.SUCCESS.getMessage();
            this.data =  data;
        }else {
            this.code = SimpleCode.ERROR.getCode();
            this.message = SimpleCode.ERROR.getMessage();
            this.data =  data;
        }
    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "JSONResult [code=" + code + ", data=" + data + ", message="
                + message + "]";
    }
}

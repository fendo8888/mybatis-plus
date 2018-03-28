/**
 * projectName: mybatis-plus
 * fileName: UniversalEnumConverterFactory.java
 * packageName: com.fendo.mybatis.plus.common.converter
 * date: 2018-03-27 9:36
 * copyright(c) 2017-2020 xxx公司
 */
package com.fendo.mybatis.plus.common.converter;

import com.baomidou.mybatisplus.enums.IEnum;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.ConverterFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

/**
 * @version: V1.0
 * @author: fendo
 * @className: UniversalEnumConverterFactory
 * @packageName: com.fendo.mybatis.plus.common.converter
 * @description: ConverterFactory转换
 * @data: 2018-03-27 9:36
 **/
public class UniversalEnumConverterFactory implements ConverterFactory<String, IEnum> {

    private static final Map<Class, Converter> converterMap = new WeakHashMap<>();

    @Override
    public <T extends IEnum> Converter<String, T> getConverter(Class<T> targetType) {
        Converter result = converterMap.get(targetType);
        if(result == null) {
            result = new IntegerStrToEnum<T>(targetType);
            converterMap.put(targetType, result);
        }
        return result;
    }

    class IntegerStrToEnum<T extends IEnum> implements Converter<String, T> {
        private final Class<T> enumType;
        private Map<String, T> enumMap = new HashMap<>();

        public IntegerStrToEnum(Class<T> enumType) {
            this.enumType = enumType;
            T[] enums = enumType.getEnumConstants();
            for(T e : enums) {
                enumMap.put(e.getValue() + "", e);
            }
        }
        @Override
        public T convert(String source) {
            T result = enumMap.get(source);
            if(result == null) {
                throw new IllegalArgumentException("No element matches " + source);
            }
            return result;
        }
    }

}

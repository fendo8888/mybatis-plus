/**
 * projectName: mybatis-plus
 * fileName: PackageUtil.java
 * packageName: com.fendo.mybatis.plus.common.utils
 * date: 2018-03-27 9:25
 * copyright(c) 2017-2020 xxx公司
 */
package com.fendo.mybatis.plus.common.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @version: V1.0
 * @author: fendo
 * @className: PackageUtil
 * @packageName: com.fendo.mybatis.plus.common.utils
 * @description: 包工具类，主要完成根据枚举类所在包名获取该package下所有class的全路径名称的工作
 * @data: 2018-03-27 9:25
 **/
public class PackageUtil {

    /**
     * 返回包下所有的类
     *
     * @param packagePathList   包名全路径集合
     * @param classWithPath 返回全路径开关 true 自动带上包名 false 只返回类名
     * @return List<String> 包下所有的类
     */
    public static List<String> getPackageClasses(List<String> packagePathList, boolean classWithPath) {
        List<String> result = new ArrayList<>();
        for(String packagePath : packagePathList) {
            List<String> classNames = getClassName(packagePath);
            String path = classWithPath ? packagePath + "." : "";
            for (String className : classNames) {
                //className:com.example.myFirstProject.enums.GenderEnum
                result.add(path + className.substring(className.lastIndexOf(".") + 1));
            }
        }
        return result;
    }

    /**
     * 获取该报名全路径下的所有class全路径集合
     * @param packageName 包名全路径
     * @return
     */
    private static List<String> getClassName(String packageName) {
        //根据报名获取该package的系统路径
        String filePath = ClassLoader.getSystemResource("").getPath() + packageName.replace(".", "\\");
        // filePath: /D:/workspace-git/springbootlearning/target/classes/com\example\myFirstProject\enums
        List<String> fileNames = getClassName(filePath, null);
        return fileNames;
    }

    /**
     * 获取filePath文件夹下的所有class的全路径集合
     * @param filePath
     * @param className
     * @return
     */
    private static List<String> getClassName(String filePath, List<String> className) {
        List<String> myClassName = new ArrayList<>();
        File file = new File(filePath);
        File[] childFiles = file.listFiles();
        for (File childFile : childFiles) {
            if (childFile.isDirectory()) {
                //递归获取该文件夹下的子文件夹里的所有文件
                myClassName.addAll(getClassName(childFile.getPath(), myClassName));
            } else {
                String childFilePath = childFile.getPath();
                //childFilePath:  D:\workspace-git\springbootlearning\target\classes\com\example\myFirstProject\enums\GenderEnum.class
                childFilePath = childFilePath.substring(childFilePath.indexOf("\\classes") + 9, childFilePath.lastIndexOf("."));
                childFilePath = childFilePath.replace("\\", ".");
                myClassName.add(childFilePath);
            }
        }

        return myClassName;
    }


}

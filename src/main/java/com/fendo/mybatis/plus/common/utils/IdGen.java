package com.fendo.mybatis.plus.common.utils;

import java.util.Random;
import java.util.UUID;

public class IdGen {
	/**  
     * 生成32位编码  
     * @return string  
     */    
    public static String getUUID(){    
        String uuid =  UUID.randomUUID().toString().trim().replaceAll("-", "");    
        return uuid;    
    }

    /**
     * 生成19位的纯数字编码
     * @return
     */
    public static String getUUIDNumber(){
        int random = (int) (Math.random()*10000);
        if(random < 10000){
            random =random +1000000000;
        }
       //String ran = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date()) + random + getFixLenthString(5);
       //return ran;
       //String ran = System.currentTimeMillis() + random + getFixLenthString(5) + random; //32位
        String ran = System.currentTimeMillis() + random + getFixLenthString(6);  //19位
       return  ran;
    }

    /*
     * 返回长度为【strLength】的随机数，在前面补0
     */
    private static String getFixLenthString(int strLength) {

        Random rm = new Random();

        // 获得随机数
        double pross = (1 + rm.nextDouble()) * Math.pow(10, strLength);

        // 将获得的获得随机数转化为字符串
        String fixLenthString = String.valueOf(pross);

        // 返回固定的长度的随机数
        return fixLenthString.substring(1, strLength + 1);
    }

    public static void main(String[] args) {
        //System.out.println(getUUIDNumber(32));
        int random = (int) (Math.random()*10000);
        if(random < 10000){
            random =random +1000000000;
        }

        String ckse = getUUIDNumber();
        System.out.println(ckse);
//        System.out.println(random);
//
//        System.out.println(new SimpleDateFormat("MMddHHmmssSSS").format(new Date()));
//        System.out.println(System.currentTimeMillis()+ random + getFixLenthString(5)+random);
//        System.out.println(new SimpleDateFormat("MMddHHmmssSSS").format(new Date()) + random + getFixLenthString(5));
        System.out.println(getUUIDNumber());

        //Integer s = Integer.parseInt(String.valueOf(System.currentTimeMillis()));
//        String ckse = String.valueOf(System.currentTimeMillis());
//        System.out.println(ckse);
////        String dd = String.valueOf(s);
//        String ck = ckse + random + getFixLenthString(19);
//        System.out.println(ck);
//        System.out.println(random);
//        System.out.println(getFixLenthString(19));


//        int randoms = (int) (Math.random()*1000000000);
//        if(randoms < 1000000000){
//            randoms =randoms +1000000000;
//        }
//
//        System.out.println(System.currentTimeMillis()+randoms);

    }
}

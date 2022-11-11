package com.jason.common.util;

/**
 * @author：yangwushuo
 * @time：2022/11/5 19:42
 */
public class RandUtil {

    public static Integer randomNumBySix(){
        return Integer.valueOf((int) ((Math.random()*9+1)*100000));
    }

    public static Integer randomNumByMinAndMax(Integer min, Integer max){
        Integer num = min + (int)(Math.random() * (max-min+1));
        return num;
    }

}

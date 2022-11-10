package com.jason.auth.util;

/**
 * @author：yangwushuo
 * @time：2022/11/5 19:42
 */
public class RandUtil {

    public static Integer randomNumBySix(){
        return Integer.valueOf((int) ((Math.random()*9+1)*100000));
    }

}

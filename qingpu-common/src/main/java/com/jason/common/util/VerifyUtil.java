package com.jason.common.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author：yangwushuo
 * @time：2022/11/6 15:05
 */
public class VerifyUtil {

    public static Boolean verifyChinaPhoneNum(String phone){
        String regExp = "^((13[0-9])|(15[^4])|(18[0,2,3,5-9])|(17[0-8])|(147))\\d{8}$";
        Pattern p = Pattern.compile(regExp);
        Matcher m = p.matcher(phone);
        return m.matches();
    }

    public static Boolean verifyEmail(String email){
        String regex = "\\w+@\\w+\\.[a-z]+(\\.[a-z]+)?";
        return Pattern.matches(regex, email);
    }

}

package com.jason.common.util;

import com.alibaba.fastjson.JSON;

/**
 * @author：yangwushuo
 * @time：2022/11/4 22:07
 */
public class JsonToObject {

    public static <W> W jsonToClass(String result, Class<W> InfoClass) {
        return JSON.parseObject(result, InfoClass);
    }


}

package com.jason.binance.biz.utils;


import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;

public final class JSONParser {

    private JSONParser() {
    }

    public static String getJSONStringValue(String json, String key) {
        try {
            JSONObject jsonObject = JSONObject.parseObject(json);
            return jsonObject.getString(key);
        } catch (JSONException e) {
            throw new JSONException(String.format("[JSONParser] Failed to get \"%s\"  from JSON object", key));
        }
    }

    public static int getJSONIntValue(String json, String key) {
        try {
            JSONObject jsonObject = JSONObject.parseObject(json);
            return jsonObject.getIntValue(key);
        } catch (JSONException e) {
            throw new JSONException(String.format("[JSONParser] Failed to get \"%s\" from JSON object", key));
        }
    }

    public static String getJSONArray(ArrayList<?> symbols, String key) {
        try {
            return JSONObject.toJSONString(symbols);
        } catch (JSONException e) {
            throw new JSONException(String.format("[JSONParser] Failed to convert \"%s\" to JSON array", key));
        }
    }
}

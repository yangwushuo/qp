package com.jason.binance.biz.utils;

import com.jason.binance.biz.exceptions.BinanceConnectorException;

import java.util.LinkedHashMap;

public final class ParameterChecker {

    private ParameterChecker() {
    }

    public static void checkParameter(LinkedHashMap<String, Object> parameters, String parameter, Class t) {
        checkRequiredParameter(parameters, parameter);
        checkParameterType(parameters.get(parameter), t, parameter);
    }

    public static void checkRequiredParameter(LinkedHashMap<String, Object> parameters, String parameter) {
        if (!parameters.containsKey(parameter)) {
            throw new BinanceConnectorException(String.format("\"%s\" is a mandatory parameter!", parameter));
        }
    }

    public static void checkParameterType(Object parameter, Class t, String name) {
        if (!t.isInstance(parameter)) {
            throw new BinanceConnectorException(String.format("\"%s\" must be of %s type.", name, t));
        } else if (t == String.class && parameter.toString().trim().equals("")) {
            throw new BinanceConnectorException(String.format("\"%s\" must not be empty.", name));
        }
    }
}

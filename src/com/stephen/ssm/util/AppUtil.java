package com.stephen.ssm.util;

import java.io.IOException;
import java.util.Properties;

import org.springframework.core.io.support.PropertiesLoaderUtils;

public final class AppUtil {
    private static final String RESOURCE_NAME = "ssm.properties";
    private static Properties property = null;

    public static void init() throws IOException {
        Properties property = PropertiesLoaderUtils.loadAllProperties(RESOURCE_NAME);
        AppUtil.setProperty(property);
    }

    public static void setProperty(Properties property) {
        AppUtil.property = property;
    }

    public static String getPropertyValue(String key) {
        return (String) property.get(key);
    }
}

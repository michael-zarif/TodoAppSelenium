package com.qacart.todo.utils;

import java.util.Properties;

public class ConfigUtils {
    private Properties properties;
    private static ConfigUtils configUtils;

    private ConfigUtils() {
        String env = System.getProperty("env", "Production");
        properties = switch (env){
            case "Production" -> PropertiesUtils.loadProperties("src/test/java/com/qacart/todo/config/production.properties");
            case "Local" -> PropertiesUtils.loadProperties("src/test/java/com/qacart/todo/config/local.properties");
            default -> throw new RuntimeException("Environment is not supported");
        };
    }

    public static ConfigUtils getInstance(){
        if (configUtils == null){
            configUtils = new ConfigUtils();
        }
        return configUtils;
    }

    public String getPropertyValue(String property){
        String props = properties.getProperty(property);
        if (props != null)
            return props;
        throw new RuntimeException("Could not find the property in the property file");
    }
}

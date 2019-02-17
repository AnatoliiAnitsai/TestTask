package com.anatolii.anitsai.hitway.data;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigPropertiesWorker {
    public String getPropertyByKey(String key) {
        FileInputStream fis;
        Properties property = new Properties();
        String propertyStr = "";

        try {
            fis = new FileInputStream("src/main/resources/config.properties");
            property.load(fis);
            propertyStr = property.getProperty(key);
        } catch (IOException e) {
            System.err.println("Error" + e);
        }
        return propertyStr;
    }
}

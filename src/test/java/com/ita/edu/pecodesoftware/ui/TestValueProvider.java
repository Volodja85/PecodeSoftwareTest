package com.ita.edu.pecodesoftware.ui;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestValueProvider {
    Properties properties;

    public TestValueProvider(){
        try {
            FileInputStream fileInputStream = new FileInputStream("src/test/resources/data.properties");
            properties = new Properties();
            properties.load(fileInputStream);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            System.out.println("Use systen env");
        }
    }

    public String getBaseUrl() {
        return   properties.getProperty("baseURL");
    }

    public String getUserName() {
        return  properties.getProperty("UserName");
    }

    public String getUserPassword() {
        return  properties.getProperty("UserPassword");
    }
}

package com.hudl.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class SecretConfig {

   public static String getSecretValue(String keyName){

        String configPath = "/src/main/resources/secrets.properties";
        String sysPath = System.getProperty("user.dir");
        Properties config = new Properties();
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(sysPath+configPath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            config.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return config.getProperty(keyName);
    }
}

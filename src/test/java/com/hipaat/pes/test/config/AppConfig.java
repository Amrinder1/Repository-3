package com.hipaat.pes.test.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;


public final class AppConfig {

    private Properties configFile = new Properties();

    final Logger logger = LoggerFactory.getLogger(AppConfig.class);

    private static AppConfig instance;
    /**
     * Load the config file to initialize the right parameters
     */
    private AppConfig(){
        try{
            configFile.load(this.getClass().getClassLoader().getResourceAsStream("application.properties"));

        }catch ( Exception ex){
            logger.error("Exception in loading the config file");
            ex.printStackTrace();
        }
    }


    public String getValue(String key){
        return this.configFile.getProperty(key);
    }

    public static String getProperty(String key){
        if(instance==null){
            instance = new AppConfig();
        }
        return instance.getValue(key);
    }



}


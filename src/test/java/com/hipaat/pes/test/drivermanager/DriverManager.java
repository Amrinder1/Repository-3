package com.hipaat.pes.test.drivermanager;


import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeSuite;

public class DriverManager {

    final static Logger logger = LoggerFactory.getLogger(DriverFactory.class);

    private static ThreadLocal<DriverFactory> driverThreadThreadLocal;


    @BeforeSuite
    public static void getInstance() {
        logger.info("Initializing driver for the thread" + Thread.currentThread().getName());

        driverThreadThreadLocal = new ThreadLocal<DriverFactory>() {
            @Override
            protected DriverFactory initialValue() {
                DriverFactory factory = new DriverFactory();
                return factory;
            }
        };
    }

    public static WebDriver getDriver(){
        return driverThreadThreadLocal.get().getDriver();
    }

    @AfterClass
    public static void quitDriver(){
        driverThreadThreadLocal.get().quitDriver();
    }
}

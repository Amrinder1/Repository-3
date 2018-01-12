package com.hipaat.pes.test.drivermanager;

import com.hipaat.pes.test.config.AppConfig;
import com.typesafe.config.ConfigSyntax;
import io.github.bonigarcia.wdm.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariDriverService;

public class DriverFactory {

    private WebDriver driver;

    /**
     * Return the existing instance of driver if driver has already been created
     *
     * @return
     * @throws Exception
     */
    public WebDriver getDriver()  {
        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        if (null == driver) {
        	switch (AppConfig.getProperty("browser")){
            
               case "chrome" : {
                    ChromeDriverManager.getInstance().setup();
                    driver = new ChromeDriver();
                }
                break;
                case "firefox" : {
                    FirefoxDriverManager.getInstance().setup();
                    driver = new FirefoxDriver();
                }
                break;
                case "opera" : {
                    OperaDriverManager.getInstance().setup();
                    driver = new OperaDriver();
                }
                break;
                case "ie":{
                    InternetExplorerDriverManager.getInstance().setup();
                    driver = new InternetExplorerDriver();
                }
                break;
                case "edge":{
                    EdgeDriverManager.getInstance().setup();
                    driver = new EdgeDriver();
                }
                break;
                case "phantomjs" : {
                    PhantomJsDriverManager.getInstance().setup();
                    driver = new PhantomJSDriver();
                }
                break;
                default: {
                    FirefoxDriverManager.getInstance().setup();
                    driver = new FirefoxDriver();
                }
            }
            }

        
        return driver;}

    private void Switch(String property) {
		// TODO Auto-generated method stub
		
	}

	/**
     * Quit the driver instance
     */
    public void quitDriver() {

        if (null != driver) {
            driver.quit();
            driver = null;
        }
    }
}

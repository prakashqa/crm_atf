package com.crm.config;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BaseConfiguration {
	
	public FileInputStream fis = null;
	public Properties prop = null;
	public WebDriver wd = null;
	
	public void invokeBrowser() {
		try {
			fis = new FileInputStream("src//test//resources//config.properties");
			prop = new Properties();
			prop.load(fis);
			
			String st = prop.getProperty("browser");
			if(st.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.home")+"//"+"Documents//ScriptDrivers//chromedriver.exe");
				wd = new ChromeDriver();
			}
			
			else if(st.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver", System.getProperty("user.home")+"//"+"Documents//ScriptDrivers//geckodriver.exe");
				wd = new FirefoxDriver();
			}
			
			else if(st.equalsIgnoreCase("ie")) {
				System.setProperty("webdriver.ie.driver", System.getProperty("user.home")+"//"+"Documents//ScriptDrivers//IEDriverServer.exe");
				wd = new InternetExplorerDriver();
			}
			
			wd.navigate().to(prop.getProperty("qaurl"));
			wd.manage().window().maximize();
			String imp_wait = prop.getProperty("implicitWait");
			int implicitWait = Integer.parseInt(imp_wait);
			wd.manage().timeouts().implicitlyWait(implicitWait, TimeUnit.SECONDS);
		}
		catch(Exception e) {
			
		}
		
	}

}

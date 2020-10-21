package br.com.giovani.config;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverConfigs {
	WebDriver driver;
	String driverPath = "Util\\drivers\\geckodriver.exe";
	String url = "www.google.com.br";
	
	public WebDriverConfigs(WebDriver driver){
		driver = this.driver;
	}
	
	public WebDriver getDriver() {
		driver = this.driver;
		return driver;
	}
	
	public void setUp(WebDriver driver) {
		System.setProperty("webdriver.gecko.driver", driverPath);
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(url);
	}
}

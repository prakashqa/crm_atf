package com.crm.utils;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.File;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonUtil {

	public static WebDriver wd = null;

	public static void clickButton(String identifiedBy, String locator, WebDriver wd) {
		if (identifiedBy.equalsIgnoreCase("id")) {
			wd.findElement(By.id(locator)).click();
		} else if (identifiedBy.equalsIgnoreCase("name")) {
			wd.findElement(By.name(locator)).click();
		} else if (identifiedBy.equalsIgnoreCase("xpath")) {
			wd.findElement(By.xpath(locator)).click();
		} else if (identifiedBy.equalsIgnoreCase("css")) {
			wd.findElement(By.cssSelector(locator)).click();
		}
	}

	public void clickLink(String identifiedBy, String locator, WebDriver wd) {
		if (identifiedBy.equalsIgnoreCase("id")) {
			wd.findElement(By.id(locator)).click();
		} else if (identifiedBy.equalsIgnoreCase("name")) {
			wd.findElement(By.name(locator)).click();
		} else if (identifiedBy.equalsIgnoreCase("xpath")) {
			wd.findElement(By.xpath(locator)).click();
		} else if (identifiedBy.equalsIgnoreCase("css")) {
			wd.findElement(By.cssSelector(locator)).click();
		} else if (identifiedBy.equalsIgnoreCase("link")) {
			wd.findElement(By.linkText(locator)).click();
		}
	}

	public static void clickRadioButton(String identifiedBy, String locator, WebDriver wd) {
		if (identifiedBy.equalsIgnoreCase("id")) {
			wd.findElement(By.id(locator)).click();
		} else if (identifiedBy.equalsIgnoreCase("name")) {
			wd.findElement(By.name(locator)).click();
		} else if (identifiedBy.equalsIgnoreCase("xpath")) {
			wd.findElement(By.xpath(locator)).click();
		} else if (identifiedBy.equalsIgnoreCase("css")) {
			wd.findElement(By.cssSelector(locator)).click();
		} else if (identifiedBy.equalsIgnoreCase("link")) {
			wd.findElement(By.linkText(locator)).click();
		}
	}

	public static void insertText(String identifiedBy, String locator, String value, WebDriver wd) {
		if (identifiedBy.equalsIgnoreCase("id")) {
			wd.findElement(By.id(locator)).sendKeys(value);
		} else if (identifiedBy.equalsIgnoreCase("name")) {
			wd.findElement(By.name(locator)).sendKeys(value);
		} else if (identifiedBy.equalsIgnoreCase("xpath")) {
			wd.findElement(By.xpath(locator)).sendKeys(value);
		} else if (identifiedBy.equalsIgnoreCase("css")) {
			wd.findElement(By.cssSelector(locator)).sendKeys(value);
		}
	}

	public static void selectDropDownItem(String identifiedBy, String locator, String itemType, String value,
			WebDriver wd) {
		WebElement element = null;
		if (identifiedBy.equalsIgnoreCase("id")) {
			element = wd.findElement(By.id(locator));
		} else if (identifiedBy.equalsIgnoreCase("name")) {
			element = wd.findElement(By.name(locator));
		} else if (identifiedBy.equalsIgnoreCase("xpath")) {
			element = wd.findElement(By.xpath(locator));
		} else if (identifiedBy.equalsIgnoreCase("css")) {
			element = wd.findElement(By.cssSelector(locator));
		}

		Select selObj = new Select(element);
		if (itemType.equalsIgnoreCase("value")) {
			selObj.selectByValue(value);
		} else if (itemType.equalsIgnoreCase("text")) {
			selObj.selectByVisibleText(value);
		} else if (itemType.equalsIgnoreCase("index")) {
			selObj.selectByIndex(Integer.parseInt(value));
		}
	}

	public static String getText(String identifiedBy, String locator, WebDriver wd) {
		if (identifiedBy.equalsIgnoreCase("id")) {
			return wd.findElement(By.id(locator)).getText();
		} else if (identifiedBy.equalsIgnoreCase("name")) {
			return wd.findElement(By.name(locator)).getText();
		} else if (identifiedBy.equalsIgnoreCase("xpath")) {
			return wd.findElement(By.xpath(locator)).getText();
		} else if (identifiedBy.equalsIgnoreCase("css")) {
			return wd.findElement(By.cssSelector(locator)).getText();
		} else if (identifiedBy.equalsIgnoreCase("link")) {
			return wd.findElement(By.linkText(locator)).getText();
		}

		return null;
	}

	public static void takeScreenShot(WebDriver wd) {
		try {
			int count = 0;
			String newFileNamePath;
			File directory = new File(".");
			DateFormat dateformat = new SimpleDateFormat("dd_MMM_yyyy_hh_mm_ssaa");
			Date date = new Date();

			newFileNamePath = directory.getCanonicalPath() + "\\ScreenShots\\" + dateformat.format(date) + "_" + ".png";
			BufferedImage screencapture = new Robot().createScreenCapture(new Rectangle(968, 1009));

			File file = new File(newFileNamePath);
			ImageIO.write(screencapture, "png", file);
			count++;
			File screenshot = ((TakesScreenshot) wd).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshot, new File(newFileNamePath));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void scrollPage(String to) throws Exception {
		JavascriptExecutor executor = (JavascriptExecutor) wd;
		if (to.equals("end"))
			executor.executeScript("window.scrollTo(0,Math.max(document.documentElement.scrollHeight,document.body.scrollHeight,document.documentElement.clientHeight));");
		else if (to.equals("top"))
			executor.executeScript("window.scrollTo(Math.max(document.documentElement.scrollHeight,document.body.scrollHeight,document.documentElement.clientHeight),0);");
		else
			throw new Exception("Exception : Invalid Direction (only scroll \"top\" or \"end\")");
	}
	
	public static void wait(int timeout) throws InterruptedException {
		int timeoutVal = timeout * 1;
		for (int second = 0; second < timeoutVal; second++) {
			Thread.sleep(1000);
		}
	}

	public static WebElement waitForElement(String identifiedBy, String locator, WebDriver wd) {

		WebElement element = null;
		if (identifiedBy.equalsIgnoreCase("id")) {
			element = wd.findElement(By.id(locator));
		} else if (identifiedBy.equalsIgnoreCase("name")) {
			element = wd.findElement(By.name(locator));
		} else if (identifiedBy.equalsIgnoreCase("xpath")) {
			element = wd.findElement(By.xpath(locator));
		} else if (identifiedBy.equalsIgnoreCase("css")) {
			element = wd.findElement(By.cssSelector(locator));
		}

		WebDriverWait wait = new WebDriverWait(wd, 40);
		return wait.until(ExpectedConditions.visibilityOf(element));
	}

}

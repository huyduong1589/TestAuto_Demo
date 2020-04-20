package common.functions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import po.selectors.GobearSelector;

public class WebSupport {
	
	WebDriver driver;
	WebDriverWait wait;
	Actions act;
	JavascriptExecutor js;
	
	public WebSupport(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(this.driver, 30);
		this.act = new Actions(driver);
		this.js = (JavascriptExecutor) driver;
	}
	
	public void clickOnElement(String xpath) {
		WebElement elm = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
		act.moveToElement(elm).click().build().perform();
	}
	
	public void scrollToElement (String xpath) throws Exception {
		Thread.sleep(3000);
		driver.findElement(By.xpath("//body")).sendKeys(Keys.PAGE_DOWN);
		//WebElement elm = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
		//js.executeScript("arguments[0].scrollIntoView();", elm);
		Thread.sleep(1000);
	}
	
	public void sendKeysToElement(String xpath, String keys) {
		WebElement elm = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
		elm.sendKeys(keys);
	}
	
	public void waitForElement(String xpath) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
	}
	
	public void setRangeOption(String xpath, Integer minValue, Integer maxValue) throws Exception {
		WebElement bar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
		WebElement min = driver.findElement(By.xpath(GobearSelector.Min_Option));
		WebElement max = driver.findElement(By.xpath(GobearSelector.Max_Option));
		WebElement max_elm = driver.findElement(By.xpath(GobearSelector.Max_Option_Value));
		int max_value = Integer.parseInt(max_elm.getAttribute("data-max-value"));
		int bar_width = bar.getSize().getWidth();
		act.clickAndHold(min).moveToElement(bar, bar_width*minValue/max_value, 0).release().build().perform();
		Thread.sleep(3000);
		act.clickAndHold(max).moveToElement(bar, bar_width*maxValue/max_value, 0).release().build().perform();
		Thread.sleep(5000);
	}
	
	public Boolean verifyElement(String xpath) {
		return driver.findElement(By.xpath(xpath)).isDisplayed();
	}


}

package po.pages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import common.functions.WebSupport;
import po.selectors.GobearSelector;

public class GobearHomePage {
	private WebDriver driver;
	private WebSupport webSupport;
	private final Logger logger = LogManager.getLogger("GobearHomePage");
	public GobearHomePage(WebDriver driver){
		this.driver = driver;
		this.webSupport = new WebSupport(driver);
	}
	
	public void clickOnInsurance() {
		webSupport.clickOnElement(GobearSelector.Insurance_Secion);
		logger.info("Click On Insurance Secion");
	}
	
	public void clickOnTravelSecion() {
		webSupport.clickOnElement(GobearSelector.Travel_Secion);
		logger.info("Click On Travel Secion");
	}
	
	public void clickOnShowMyResult() {
		webSupport.clickOnElement(GobearSelector.Show_My_Result_Button);
		logger.info("Click On Show My Result");
	}

}

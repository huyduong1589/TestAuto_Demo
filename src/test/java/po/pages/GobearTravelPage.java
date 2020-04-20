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

public class GobearTravelPage {
	private WebDriver driver;
	private WebSupport webSupport;
	private final Logger logger = LogManager.getLogger("GobearTravelPage");
	public GobearTravelPage(WebDriver driver){
		this.driver = driver;
		this.webSupport = new WebSupport(driver);
	}
	
	public void clickOnSEE_MORE() {
		webSupport.clickOnElement(GobearSelector.SEE_MORE_Tab);
		logger.info("Click On SEE MORE");
	}
	
	public void selectDestinationFilter(String destination) throws Exception {
		webSupport.waitForElement(GobearSelector.Insurance_Card);
		String destinationToSelectXpath = GobearSelector.Destination_To_Select.replace("<Destination>", destination);
		webSupport.scrollToElement(GobearSelector.Destination_Dropdown);
		webSupport.clickOnElement(GobearSelector.Destination_Dropdown);
		webSupport.clickOnElement(destinationToSelectXpath);
		Thread.sleep(1000);
		logger.info("Select Destination: " + destination);
	}
	
	public void selectStartDate(String date, String month, String year) throws Exception {
		//webSupport.waitForElement(GobearSelector.Insurance_Card);
		String dateXpath = GobearSelector.Date_To_Select.replace("<Date>", date);
		String monthXpath = GobearSelector.Month_To_Select.replace("<Month>", month);
		String yearXpath = GobearSelector.Year_To_Select.replace("<Year>", year);
		webSupport.scrollToElement(GobearSelector.Date_From_Option);
		webSupport.clickOnElement(GobearSelector.Date_From_Option);
		webSupport.clickOnElement(GobearSelector.Date_Picker_Days_Switch);
		webSupport.clickOnElement(GobearSelector.Date_Picker_Months_Switch);
		Thread.sleep(500);
		webSupport.clickOnElement(yearXpath);
		Thread.sleep(500);
		webSupport.clickOnElement(monthXpath);
		Thread.sleep(500);
		webSupport.clickOnElement(dateXpath);
		Thread.sleep(3000);
		logger.info("Select Start Date: " + date + ", " + month + ", " + year);
	}
	
	public void selectEndDate(String date, String month, String year) throws Exception {
		webSupport.waitForElement(GobearSelector.Insurance_Card);
		String dateXpath = GobearSelector.Date_To_Select.replace("<Date>", date);
		String monthXpath = GobearSelector.Month_To_Select.replace("<Month>", month);
		String yearXpath = GobearSelector.Year_To_Select.replace("<Year>", year);
		webSupport.scrollToElement(GobearSelector.Date_To_Option);
		webSupport.clickOnElement(GobearSelector.Date_To_Option);
		webSupport.clickOnElement(GobearSelector.Date_Picker_Days_Switch);
		webSupport.clickOnElement(GobearSelector.Date_Picker_Months_Switch);
		Thread.sleep(500);
		webSupport.clickOnElement(yearXpath);
		Thread.sleep(500);
		webSupport.clickOnElement(monthXpath);
		Thread.sleep(500);
		webSupport.clickOnElement(dateXpath);
		Thread.sleep(3000);
		logger.info("Select End Date: " + date + ", " + month + ", " + year);
	}
	
	public boolean verifyCardNumberAtLeast(Integer number) {
		webSupport.waitForElement(GobearSelector.Insurance_Card);
		List<WebElement> cards = driver.findElements(By.xpath(GobearSelector.Insurance_Card));
		Integer numberOfCards = cards.size();
		logger.info("Get number of card is " + numberOfCards + " - expects at least is " + number);
		if (numberOfCards >= number){
			logger.info("Verify number of cards at least is " + number + ": PASSED");
			return true;
		}
		else {
			logger.info("Verify number of cards at least is " + number + ": FALIED");
			return false;
		}
	}
	
	public boolean verifyCategoryByName(String name) {
		String categoryXpath = GobearSelector.Category_Lable.replace("<CategoryName>", name);
		boolean result =  webSupport.verifyElement(categoryXpath);
		if (result) {
			logger.info("Verify category " + name + " is displayed : PASSED");
			return true;
		}
		else {
			logger.info("Verify category " + name + " is displayed : FAILED");
			return false;
		}
	}
	
	public boolean verifyFilterByInsurerName(String insurerName) throws Exception {
		webSupport.waitForElement(GobearSelector.Insurance_Card);
		String insurerNameOnCard = GobearSelector.Insurance_Name.replace("<InsurerName>", insurerName);
		String insurerNameOnFilter = GobearSelector.Insurer_CheckBox.replace("<InsurerName>", insurerName);
		List<WebElement> cards = driver.findElements(By.xpath(insurerNameOnCard));
		Integer numberOfCardsBeforeFilter = cards.size();
		logger.info("Get number of card of " + insurerName + " is: " + numberOfCardsBeforeFilter);
		webSupport.clickOnElement(insurerNameOnFilter );
		logger.info("Click On " + insurerName);
		Thread.sleep(1500);
		List<WebElement> cardsAfterFilter = driver.findElements(By.xpath(GobearSelector.Insurance_Card));
		Integer numberOfCardsAfterFilter = cardsAfterFilter.size();
		logger.info("Get number of card of " + insurerName + " after filter is: " + numberOfCardsAfterFilter);
		if (numberOfCardsBeforeFilter >= numberOfCardsAfterFilter){
			logger.info("Verify filter for insurer " + insurerName + ": PASSED");
			return true;
		}
		else {
			logger.info("Verify filter for insurer " + insurerName + ": FALIED");
			return false;
		}
	}
	
	public boolean verifySortPriceHighToLow() throws Exception {
		webSupport.waitForElement(GobearSelector.Insurance_Card);
		List<WebElement> prices = driver.findElements(By.xpath(GobearSelector.Insurance_Price));
		List<Integer> valuesBeforeSort = new ArrayList<Integer>();
		List<Integer> valuesAfterSort = new ArrayList<Integer>();
		for (WebElement price : prices) {
			valuesBeforeSort.add(Integer.parseInt(price.getText().replace(",", "")));
		}
		webSupport.clickOnElement(GobearSelector.Sort_Price_High_To_Low_Radio);
		logger.info("Click On High To Low");
		Thread.sleep(1500);
		List<WebElement> pricesAfterSort = driver.findElements(By.xpath(GobearSelector.Insurance_Price));
		for (WebElement price : pricesAfterSort) {
			valuesAfterSort.add(Integer.parseInt(price.getText().replace(",", "")));
		}
		Collections.sort(valuesBeforeSort);
		Collections.reverse(valuesBeforeSort);
		boolean result = valuesBeforeSort.equals(valuesAfterSort);
		if (result){
			logger.info("Verify sort price high to low: PASSED");
			return true;
		}
		else {
			logger.info("Verify sort price high to low: FAILED");
			return false;
		}
		
	}
	
	public boolean verifyRangeOptionByName(Integer min, Integer max) throws Exception {
		webSupport.setRangeOption(GobearSelector.Range_Option, min, max);
		Thread.sleep(5000);
		webSupport.waitForElement(GobearSelector.Insurance_Card);
		List<WebElement> elms = driver.findElements(By.xpath(GobearSelector.Insurance_Type_Max_Value));
		for (WebElement elm : elms) {
			Integer value = Integer.parseInt(elm.getText().replace(",", "").replace("₱", ""));
			if (value > max || value < min) {
				logger.info("Verify Range Option: FAILED");
				return false;
			}
		}
		logger.info("Verify Range Option: PASSED");
		return true;
	}
	
	public boolean verifyTopSideMessageShouldInclude(String message) throws Exception {
		webSupport.waitForElement(GobearSelector.Insurance_Card);
		String actualMessage = driver.findElement(By.xpath(GobearSelector.Top_Side_Message)).getText();
		logger.info("Top message after filter: " + actualMessage);
		if (actualMessage.contains(message)) {
			logger.info("Verify top message should include '" + message +"': PASSED");
			return true;
		}
		else {
			logger.info("Verify top message should include '" + message +"': FAILED");
			return false;
		}
	}

}

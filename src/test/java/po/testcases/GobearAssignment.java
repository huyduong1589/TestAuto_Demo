package po.testcases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.functions.DriverFactory;
import po.pages.GobearHomePage;
import po.pages.GobearTravelPage;

public class GobearAssignment {
	
	public static final Logger logger = LogManager.getLogger("GobearAssignment");
	private WebDriver driver;
	@BeforeMethod
	@Parameters({"url"})
	public void setup(String url) throws Exception {
		driver = DriverFactory.createDriver();
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	@Test
	@Parameters({"minNumberCards","category1","category2","category3"})
	public void TC001_VerifyMinCardNumberAndCategory(String minCards, String category1, String category2, String category3) throws Exception {
		logger.info("Start testcase 1: VerifyMinCardNumberAndCategory");
		GobearHomePage gobearHomePage = new GobearHomePage(driver);
		GobearTravelPage gobearTravelPage = new GobearTravelPage(driver);
		gobearHomePage.clickOnInsurance();
		gobearHomePage.clickOnTravelSecion();
		gobearHomePage.clickOnShowMyResult();
		Assert.assertTrue(gobearTravelPage.verifyCardNumberAtLeast(Integer.parseInt(minCards)));
		Assert.assertTrue(gobearTravelPage.verifyCategoryByName(category1));
		Assert.assertTrue(gobearTravelPage.verifyCategoryByName(category2));
		Assert.assertTrue(gobearTravelPage.verifyCategoryByName(category3));
	}
	
	@Test
	@Parameters({"filterInsurer"})
	public void TC002_VerifyInsurerFilter(String insurerName) throws Exception {
		logger.info("STart testcase 2: VerifyInsurerFilter");
		GobearHomePage gobearHomePage = new GobearHomePage(driver);
		GobearTravelPage gobearTravelPage = new GobearTravelPage(driver);
		gobearHomePage.clickOnInsurance();
		gobearHomePage.clickOnTravelSecion();
		gobearHomePage.clickOnShowMyResult();
		Assert.assertTrue(gobearTravelPage.verifyFilterByInsurerName(insurerName));
	}
	
	@Test
	public void TC003_VerifySortPriceHighToLow() throws Exception {
		logger.info("STart testcase 3: VerifySortPriceHighToLow");
		GobearHomePage gobearHomePage = new GobearHomePage(driver);
		GobearTravelPage gobearTravelPage = new GobearTravelPage(driver);
		gobearHomePage.clickOnInsurance();
		gobearHomePage.clickOnTravelSecion();
		gobearHomePage.clickOnShowMyResult();
		Assert.assertTrue(gobearTravelPage.verifySortPriceHighToLow());
	}
	
	@Test
	public void TC004_VerifyRangeOption() throws Exception {
		logger.info("STart testcase 4: VerifyRangeOption");
		GobearHomePage gobearHomePage = new GobearHomePage(driver);
		GobearTravelPage gobearTravelPage = new GobearTravelPage(driver);
		gobearHomePage.clickOnInsurance();
		gobearHomePage.clickOnTravelSecion();
		gobearHomePage.clickOnShowMyResult();
		gobearTravelPage.clickOnSEE_MORE();
		Assert.assertTrue(gobearTravelPage.verifyRangeOptionByName(2000000, 8000000));
	}
	
	@Test
	@Parameters({"destination"})
	public void TC005_VerifyDestinationFilter(String destination) throws Exception {
		logger.info("STart testcase 5: VerifyDestinationFilter");
		GobearHomePage gobearHomePage = new GobearHomePage(driver);
		GobearTravelPage gobearTravelPage = new GobearTravelPage(driver);
		gobearHomePage.clickOnInsurance();
		gobearHomePage.clickOnTravelSecion();
		gobearHomePage.clickOnShowMyResult();
		gobearTravelPage.selectDestinationFilter(destination);
		Assert.assertTrue(gobearTravelPage.verifyTopSideMessageShouldInclude("travel to " + destination));
	}
	
	@Test
	@Parameters({"startDate", "endDate"})
	public void TC006_VerifyDateFilter(String startDate, String endDate) throws Exception {
		logger.info("STart testcase 6: VerifyDateFilter");
		GobearHomePage gobearHomePage = new GobearHomePage(driver);
		GobearTravelPage gobearTravelPage = new GobearTravelPage(driver);
		gobearHomePage.clickOnInsurance();
		gobearHomePage.clickOnTravelSecion();
		gobearHomePage.clickOnShowMyResult();
		gobearTravelPage.selectStartDate(startDate, "Aug", "2021");
		gobearTravelPage.selectEndDate(endDate, "Aug", "2021");
		Assert.assertTrue(gobearTravelPage.verifyTopSideMessageShouldInclude("from " + startDate));
		Assert.assertTrue(gobearTravelPage.verifyTopSideMessageShouldInclude("to " + endDate));
	}
	@AfterMethod
	public void cleanUp() {
		driver.quit();
	}

}


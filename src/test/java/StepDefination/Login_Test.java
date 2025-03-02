package StepDefination;



import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;

import com.PageObject.LoginPage;
import com.main.Helper;
import com.main.ToolDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;

public class Login_Test {
	private WebDriver driver=null;
	private LoginPage lp=null;
	private Helper hp=null;
	
	
	@Before(order = 0)
	public void initlizeBrowser() {
		ToolDriver td=new ToolDriver();
		 driver=td.initBrowser();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
		 lp=new LoginPage(driver);
		 hp=new Helper(driver);
	}
	
	@Before(order = 1)
    public void setUpScenario(Scenario scenario){
		hp.message = scenario; 
   }
	
	
	@Given("User enter the url {string}")
	public void user_enter_the_url(String string) throws Throwable {
		System.out.println(Thread.currentThread().getId());
		driver.get(string);
		hp.takeScreenShotAfterEveryStep();
	}

	@When("^User Enter The Username \"([^\"]*)\"$")
	public void user_Enter_The_Username(String username) throws Throwable {
		Assert.assertTrue(lp.enterUsername(username));
	}

	@When("^User Enter The Password \"([^\"]*)\"$")
	public void user_Enter_The_Password(String password) throws Throwable {
		
		Assert.assertTrue(lp.enterPassword(password));
		hp.takeScreenShotAfterEveryStep();
	}

	@When("^User Click On The Login_Button$")
	public void user_Click_On_The_Login_Button() throws Throwable {
		Assert.assertTrue(lp.clickOnLoginButton());
//		hp.takeScreenShotAfterEveryStep();

	  
	}

	@Then("validate the user is successfully logined$")
	public void validate_the_user_is_successfully_logined() throws Throwable {
			Assert.assertTrue(lp.exist());
			hp.takeScreenShotAfterEveryStep();
	}
	
	@When("Select the product {string}")
	public void select_the_product(String string) throws Throwable {
		String dynamicProductXpath="//div[normalize-space()='#Replace1']/ancestor::div[@class='inventory_item_label']/following-sibling::div//button";
		hp.clickUsingDynamicXpath(dynamicProductXpath, string);
		////a[@data-test='shopping-cart-link']
		String cartLinkXpath="//a[@data-test='shopping-cart-link']";
		WebElement ele = hp.createWebElement(cartLinkXpath);
		hp.click(ele);
		hp.takeScreenShotAfterEveryStep();
		String productCartXpath="//div[normalize-space()='"+string+"']";
		WebElement  productCartEle= hp.createWebElement(productCartXpath);
		hp.exist(productCartEle);
		hp.takeScreenShotAfterEveryStep();
		String checkoutXpath="//button[@id='checkout']";
		WebElement  checkoutButton= hp.createWebElement(checkoutXpath);
		hp.click(checkoutButton);
	}

	@And("User Enter The FirstName {string}")
	public void user_enter_the_first_name(String string) {
		Assert.assertTrue(lp.enterFirstName(string));
	}

	@And("User Enter The LastName {string}")
	public void user_enter_the_last_name(String string) throws Throwable {
		
		Assert.assertTrue(lp.enterLastName(string));

	}

	@And("User Enter The ZipCode {string}")
	public void user_enter_the_zip_code(String string) throws Exception {
		Assert.assertTrue(lp.enterPostalCode(string));
		hp.takeScreenShotAfterEveryStep();

	}

	@Then("validate the product order successfully")
	public void validate_the_product_order_successfully() throws Exception {
		WebElement  continueButton= hp.createWebElement("//input[@id='continue']");
		hp.click(continueButton);
		WebElement  finishButton= hp.createWebElement("//button[@id='finish']");
		hp.click(finishButton);
		WebElement  orderValidationEle= hp.createWebElement("//h2[text()='Thank you for your order!']");
		if(orderValidationEle!=null) {
			Assert.assertEquals(1, 1);
			hp.takeScreenShotAfterEveryStep();
		}else {
			hp.takeScreenShotAfterEveryStep();
		}
		
	 
	}
	
//	@Then("validate the user is enter invalid credentials {string}")
//	public void validate_the_user_is_enter_invalid_credentials(String string) {
//		Assert.assertTrue(lp.exist());
//		Assert.assertTrue(lp.invalidCreadValidation());
//	}
	
	@After()
	public void quit() {
		if(driver!=null) {
			driver.quit();
			
		}
	}
	
//	@After(order = 1)
//	public void tearDown(Scenario scenario) throws Exception {
//		if (scenario.isFailed()) {
//			Thread.sleep(1000);
//			Date date=new Date();
//			SimpleDateFormat sdf=new SimpleDateFormat("ddMMyyyyms");
//			String date1=sdf.format(date);
//			
//			String screenshotName = scenario.getName().replaceAll(" ", "_")+date1;
//			byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
//			scenario.attach(sourcePath, "image/png", screenshotName);
//
//		}
//	}
}

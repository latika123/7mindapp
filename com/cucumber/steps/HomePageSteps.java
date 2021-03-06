//Author: Latika

package cucumber.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import utils.DriverManager;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.tests.RunCucumberFeatures;

public class HomePageSteps extends BaseSteps {

	@Before
	public void setupLoginSteps() {

		System.out.println("Initializing the driver..");
		initializeTheDriver();

	}

	@Given("^I am on the 7Mind Meditation App$")
	public void iamOnthe7MindApp() throws Throwable {
		waitForElement(By.linkText(RunCucumberFeatures.locators.getProperty("good2seeU_txt")));
		isElementPresent(By.linkText(RunCucumberFeatures.locators.getProperty("good2seeU_txt")));
		WebElement good2seeU_txt = DriverManager.getDriver()
				.findElement(By.linkText(RunCucumberFeatures.locators.getProperty("good2seeU_txt")));
		Assert.assertEquals(good2seeU_txt.getText(), "Good to see you!");

	}

	@And("^I click on Login button$")
	public void iClickonLoginButton() throws Throwable {
		waitForElement(By.linkText(RunCucumberFeatures.locators.getProperty("loginBtn")));
		WebElement loginBtn = DriverManager.getDriver()
				.findElement(By.id(RunCucumberFeatures.locators.getProperty("loginBtn")));
		loginBtn.click();
	}

	@And("^Enter invalid email and password login credentials$")
	public void iEnterInValidLoginCredentials() throws Throwable {
		waitForElement(By.linkText(RunCucumberFeatures.locators.getProperty("didyouregisterText")));
		WebElement didyouregisterText = DriverManager.getDriver()
				.findElement(By.linkText(RunCucumberFeatures.locators.getProperty("didyouregisterText")));
		Assert.assertEquals(didyouregisterText.getText(), "Did you register with email or Facebook?");
		waitForElement(By.linkText(RunCucumberFeatures.locators.getProperty("emailBtn")));
		WebElement emailBtn = DriverManager.getDriver()
				.findElement(By.linkText(RunCucumberFeatures.locators.getProperty("emailBtn")));
		emailBtn.click();

		WebElement whatIsEmailAddressText = DriverManager.getDriver()
				.findElement(By.linkText(RunCucumberFeatures.locators.getProperty("whatIsEmailAddressText")));
		Assert.assertEquals(whatIsEmailAddressText.getText(), "What's your email address?");

		WebElement emailAddrInput = DriverManager.getDriver()
				.findElement(By.linkText(RunCucumberFeatures.locators.getProperty("emailAddrInput")));
		emailAddrInput.sendKeys("abc@gmail.com");
		emailAddrInput.sendKeys(Keys.ENTER);

		WebElement passwordInput = DriverManager.getDriver()
				.findElement(By.linkText(RunCucumberFeatures.locators.getProperty("passwordInput")));
		passwordInput.sendKeys("xyz@123");
		passwordInput.sendKeys(Keys.ENTER);

	}

	
	
	@And("^Enter invalid email format$")
	public void iEnterInValidEmailCredentials() throws Throwable {
		waitForElement(By.linkText(RunCucumberFeatures.locators.getProperty("didyouregisterText")));
		WebElement didyouregisterText = DriverManager.getDriver()
				.findElement(By.linkText(RunCucumberFeatures.locators.getProperty("didyouregisterText")));
		Assert.assertEquals(didyouregisterText.getText(), "Did you register with email or Facebook?");
		waitForElement(By.linkText(RunCucumberFeatures.locators.getProperty("emailBtn")));
		WebElement emailBtn = DriverManager.getDriver()
				.findElement(By.linkText(RunCucumberFeatures.locators.getProperty("emailBtn")));
		emailBtn.click();

		WebElement whatIsEmailAddressText = DriverManager.getDriver()
				.findElement(By.linkText(RunCucumberFeatures.locators.getProperty("whatIsEmailAddressText")));
		Assert.assertEquals(whatIsEmailAddressText.getText(), "What's your email address?");

		WebElement emailAddrInput = DriverManager.getDriver()
				.findElement(By.linkText(RunCucumberFeatures.locators.getProperty("emailAddrInput")));
		emailAddrInput.sendKeys("hgdfjsgfhjvtriretonvutniypotirpyoiptroiupytiuytopuipouipotyipiptipot53764735843858435");
		emailAddrInput.sendKeys(Keys.ENTER);
		
		
	}
	
	@And("^Enter invalid password format$")
	public void iEnterInValidPasswordCredentials() throws Throwable {
		waitForElement(By.linkText(RunCucumberFeatures.locators.getProperty("didyouregisterText")));
		WebElement didyouregisterText = DriverManager.getDriver()
				.findElement(By.linkText(RunCucumberFeatures.locators.getProperty("didyouregisterText")));
		Assert.assertEquals(didyouregisterText.getText(), "Did you register with email or Facebook?");
		waitForElement(By.linkText(RunCucumberFeatures.locators.getProperty("emailBtn")));
		WebElement emailBtn = DriverManager.getDriver()
				.findElement(By.linkText(RunCucumberFeatures.locators.getProperty("emailBtn")));
		emailBtn.click();

		WebElement whatIsEmailAddressText = DriverManager.getDriver()
				.findElement(By.linkText(RunCucumberFeatures.locators.getProperty("whatIsEmailAddressText")));
		Assert.assertEquals(whatIsEmailAddressText.getText(), "What's your email address?");

		WebElement emailAddrInput = DriverManager.getDriver()
				.findElement(By.linkText(RunCucumberFeatures.locators.getProperty("emailAddrInput")));
		emailAddrInput.sendKeys("enter valid email");
		emailAddrInput.sendKeys(Keys.ENTER);
		
		WebElement passwordInput = DriverManager.getDriver()
				.findElement(By.linkText(RunCucumberFeatures.locators.getProperty("passwordInput")));
		passwordInput.sendKeys("xyz@123<script>345()*&&ytghjhjfhvfdghgfhkjgfljlgjljl-------exceeding length");
		passwordInput.sendKeys(Keys.ENTER);
		
		
	}
	
	@Then("^Verify that user is not allowed to login$")
	public void userNotAllowedLogin() throws Throwable {
		WebElement loginerrormsg = DriverManager.getDriver()
				.findElement(By.linkText(RunCucumberFeatures.locators.getProperty("loginerrormsg")));
		Assert.assertEquals(loginerrormsg.getText(), "Sorry, that didn't work");
	}
	
	@Then("^Verify that email validation error message should appear$")
	public void emailValidation() throws Throwable {
		//Ideally some validation error message should appear but seems it is not handled which is a bug, hence marking this test case as failure
		Assert.fail();
	}
	
	@Then("^Verify that password validation error message should appear$")
	public void passwordValidation() throws Throwable {
		//Ideally some validation error message should appear but seems it is not handled which is a bug, hence marking this test case as failure
		Assert.fail();
	}
	
	@And("^Enter valid email and password login credentials$")
	public void iEnterValidLoginCredentials() throws Throwable {
		waitForElement(By.linkText(RunCucumberFeatures.locators.getProperty("didyouregisterText")));
		WebElement didyouregisterText = DriverManager.getDriver()
				.findElement(By.linkText(RunCucumberFeatures.locators.getProperty("didyouregisterText")));
		Assert.assertEquals(didyouregisterText.getText(), "Did you register with email or Facebook?");
		waitForElement(By.linkText(RunCucumberFeatures.locators.getProperty("emailBtn")));
		WebElement emailBtn = DriverManager.getDriver()
				.findElement(By.linkText(RunCucumberFeatures.locators.getProperty("emailBtn")));
		emailBtn.click();

		WebElement whatIsEmailAddressText = DriverManager.getDriver()
				.findElement(By.linkText(RunCucumberFeatures.locators.getProperty("whatIsEmailAddressText")));
		Assert.assertEquals(whatIsEmailAddressText.getText(), "What's your email address?");

		WebElement emailAddrInput = DriverManager.getDriver()
				.findElement(By.linkText(RunCucumberFeatures.locators.getProperty("emailAddrInput")));
		emailAddrInput.sendKeys("enter some valid email id");
		emailAddrInput.sendKeys(Keys.ENTER);

		WebElement passwordInput = DriverManager.getDriver()
				.findElement(By.linkText(RunCucumberFeatures.locators.getProperty("passwordInput")));
		passwordInput.sendKeys("enter valid password");
		passwordInput.sendKeys(Keys.ENTER);

	}

	@Then("^Verify that user is allowed to login$")
	public void userAllowedLogin() throws Throwable {
		WebElement loginsuccessmsg = DriverManager.getDriver()
				.findElement(By.partialLinkText(RunCucumberFeatures.locators.getProperty("loginsuccessmsg")));
		Assert.assertEquals(loginsuccessmsg.getText().contains("Welcome back, you're now logged in"),true);
	}


	@After
	public void teardown(Scenario scenario) {
		if (scenario.isFailed()) {
			// Take a screenshot...
			final byte[] screenshot = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BYTES);
			scenario.embed(screenshot, "image/png");
			// ... and embed it in the report.

		}
		System.out.println("Closing driver!");
		teardownTheDriver();

	}
}

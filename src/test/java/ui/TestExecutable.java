import common.Registration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


class TestExecutable {
	private WebDriver driver;
	private Registration register;

	// Initialize properties and start browser
	@BeforeClass
	public void openDriver() {
		System.setProperty("webdriver.gecko.driver", "./resources/geckodriver.exe");
		// Get driver and delete all cookies
		WebDriver driver = new FirefoxDriver();
		driver.manage().deleteAllCookies();
		this.driver = driver;
		
		// Initialize page objects
		register = new Registration();
		
		// Initialize page elements
		driver.get("https://my.lobsterink.com/learn");
		PageFactory.initElements(driver,register);
}
	
	// Close browser
	@AfterClass
	public void closeDriver()
	{
		driver.close();
	}

	//Verify Unsuccessful User Registration
	@Test (description = "Validate Successful Registration", priority = 2)
	public void checkUnSuccessfulRegistration()
	{
		SoftAssert softAssert = new SoftAssert();
		// Enter Registration details details
		register.redirectToSigup();
		register.clickContinue();
		//Assertions
		softAssert.assertEquals(register.firstNameValidation(),"input-validation-error text-box single-line");
		softAssert.assertEquals(register.lastNameValidation(),"input-validation-error text-box single-line");
		softAssert.assertEquals(register.emailValidation(),"input-validation-error text-box single-line");
		softAssert.assertEquals(register.confirmEmailValidation(),"input-validation-error text-box single-line");
		softAssert.assertEquals(register.passwordValidation(),"input-validation-error text-box single-line");
		softAssert.assertEquals(register.confirmPasswordValidation(),"input-validation-error text-box single-line");


	}

	//Verify Successful User Registration
	@Parameters({"fName","lName","email", "cEmail","password","cPassword"})
	@Test (description = "Validate Successful Registration", priority = 1)
	public void checkSuccessfulRegistration(String fName, String lName, String email, String cEmail, String password, String cPassword)
	{
		SoftAssert softAssert = new SoftAssert();
		// Enter Registration details details
		register.redirectToSigup();
		register.enterRegistrationDetails(fName, lName, email, cEmail, password,cPassword);
		register.clickContinue();
		//Assertions
		softAssert.assertEquals(register.confirmSigning(),"Hi "+ fName) ;
	}
}
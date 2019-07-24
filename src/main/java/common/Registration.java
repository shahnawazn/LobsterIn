package common;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.concurrent.TimeUnit;

public class Registration {

    // Identifying web elements
    @FindBy(css = ".ghost-button")
    private WebElement signUpButton;

    @FindBy(id = "sign-up-with-email")
    private WebElement signupWithEmail;

    @FindBy(id = "FirstName")
    private WebElement firstName;

    @FindBy(id = "LastName")
    private WebElement lastName;

    @FindBy(id = "Email")
    private WebElement emailId;

    @FindBy(id = "ConfirmEmail")
    private WebElement confirmEmail;

    @FindBy(id = "Password")
    private WebElement actualPassword;

    @FindBy(id = "ConfirmPassword")
    private WebElement confirmPassword;

    @FindBy(id = "sign-up-button")
    private WebElement completeSignup;

    @FindBy(css = ".text-align-end")
    private WebElement confirmSigning;


    /**
     * Go to Sign Up Screen
     */
    public void redirectToSigup() {
        try {
            TimeUnit.SECONDS.sleep(2);
            signUpButton.click();
            TimeUnit.SECONDS.sleep(2);
            signupWithEmail.click();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Enter the registration details
     *
     * @param fName     First Name
     * @param lName     Last Name
     * @param email     Email Id
     * @param cEmail    Confirm Email Id
     * @param password  Password
     * @param cPassword Confirm Password
     */
    public void enterRegistrationDetails(String fName, String lName, String email, String cEmail, String password, String cPassword ) {
        try {
            TimeUnit.SECONDS.sleep(2);
            firstName.sendKeys(fName);
            lastName.sendKeys(lName);
            emailId.sendKeys(email);
            confirmEmail.sendKeys(cEmail);
            actualPassword.sendKeys(password);
            confirmPassword.sendKeys(cPassword);
            TimeUnit.SECONDS.sleep(15);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Click on Sign UP button
     */
    public void clickContinue() {
        try {
            TimeUnit.SECONDS.sleep(2);
            completeSignup.click();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Confirm registration
     */
    public String confirmSigning() {
        return confirmSigning.getText();
    }
    /**
     * Check First name Validation
     */
    public String firstNameValidation()
    {
        return firstName.getAttribute("class");
    }

    /**
     * Check Last name Validation
     */
    public String lastNameValidation()
    {
        return lastName.getAttribute("class");
    }

    /**
     * Check Email Validation
     */
    public String emailValidation()
    {
        return emailId.getAttribute("class");
    }

    /**
     * Check Confirm Email Validation
     */
    public String confirmEmailValidation()
    {
        return firstName.getAttribute("class");
    }

    /**
     * Check Password Validation
     */
    public String passwordValidation()
    {
        return actualPassword.getAttribute("class");
    }

    /**
     * Check Password Validation
     */
    public String confirmPasswordValidation()
    {
        return confirmPassword.getAttribute("class");
    }

}

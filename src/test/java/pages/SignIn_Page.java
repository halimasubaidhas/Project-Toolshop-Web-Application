package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class SignIn_Page {
	WebDriver driver;
	WebDriverWait wait;
	
	public SignIn_Page(WebDriver driver)
	{
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	

	
//find username textbox and enter username
public void Username_textbox(String name){
	WebElement log_usernametxt = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='email']")));
	System.out.println("Login text box found");
	log_usernametxt.sendKeys(name);
}



//find password textbox and enter password
public void Password_textbox(String pwd) {
	WebElement log_pwdtxt = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='password']")));
	System.out.println("Pwd text box found");
	log_pwdtxt.sendKeys(pwd);
}


//find sign_in button and click
public void SignIn_Button() {
	WebElement log_SigninBtn = 	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@class='btnSubmit']")));
	System.out.println("Login button found");
	
	log_SigninBtn.click();
	 // Wait until the expected URL appears
    wait.until(ExpectedConditions.urlToBe(
        "https://practicesoftwaretesting.com/account"
    ));

    // Verify the URL
    String actualURL = driver.getCurrentUrl();
    String expectedURL = "https://practicesoftwaretesting.com/account";

    Assert.assertEquals(actualURL, expectedURL, "Login Failed");

  

}



}

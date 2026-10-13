package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Checkout_Page {
	WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor je;
	
public Checkout_Page(WebDriver driver)
{
	this.driver = driver;
	this.wait = new WebDriverWait(driver, Duration.ofSeconds(25));
	this.je = (JavascriptExecutor)driver;
}

public void cart_Checkout()
{
WebElement proceedbtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Proceed to checkout']")));	
proceedbtn.click();
}
public void signin_Checkout()
{
WebElement proceed2btn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-test='proceed-2\']")));	
proceed2btn.click();
}

public void payment_Checkout()
{}
}

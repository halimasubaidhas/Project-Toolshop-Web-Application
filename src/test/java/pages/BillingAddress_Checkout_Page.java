package pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;



public class BillingAddress_Checkout_Page{
WebDriver driver;
WebDriverWait wait;
JavascriptExecutor je;

public BillingAddress_Checkout_Page(WebDriver driver)
{
	this.driver = driver;
	this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	this.je = (JavascriptExecutor) driver;
}

public void countrydropDown()
{
	//select country from dropdown	
	WebElement countrydrpdwnObj = driver.findElement(By.id("country"));
	Select selObj = new Select(countrydrpdwnObj);
	selObj.selectByContainsVisibleText("India");
}

public void postCde_TextBox(String pstcde)
{
	WebElement pstcdeText = driver.findElement(By.id("postal_code"));
	pstcdeText.sendKeys(pstcde);
}
public void houseNo_TextBox(String hsNo)
{
	WebElement houseNoText = driver.findElement(By.id("house_number"));
	houseNoText.sendKeys(hsNo);
}

/*public void streetTextBox(String street)
{   
	
WebElement streetText = driver.findElement(By.id("street"));
streetText.clear();
wait.until(ExpectedConditions.elementToBeClickable(streetText));
	streetText.sendKeys(street);
	
	String actual= getText(streetText);
	String expected=street;
	Assert.assertEquals(actual, expected);
    System.out.println("Actual text"+actual);
    System.out.println("Expected text"+expected);
	}

private String  getText(WebElement streetText) {
	// TODO Auto-generated method stub
	return null;
}

*/
public void cityTextBox(String city)
{
	WebElement cityText = wait.until(ExpectedConditions.elementToBeClickable(By.id("street")));
	cityText.sendKeys(city);
}

public void stateTextBox(String state)
{
	WebElement stateText = driver.findElement(By.xpath("//input[@id='street']"));
	stateText.sendKeys(state);
}
public void billAddress_proceed3rdbtn()
{  
	je.executeScript("window.scrollBy(0,500)");
WebElement proceed3btn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Proceed to checkout ']")));	
proceed3btn.click();
}
}

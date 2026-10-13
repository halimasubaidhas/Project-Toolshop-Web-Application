package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Payment_Checkout {
WebDriver driver;
WebDriverWait wait;
JavascriptExecutor je;


public Payment_Checkout(WebDriver driver) {
this.driver = driver;
this.wait = new WebDriverWait( driver,Duration.ofSeconds(25));
this.je = (JavascriptExecutor) driver;


}
public void paymentMode()
{
	
	WebElement paymentModeDrpdown = driver.findElement(By.id("payment-method"));
 Select sel = new Select(paymentModeDrpdown);	
 sel.selectByVisibleText("Bank Transfer");
}

public void bankNameTextBox(String bnkName)
{
WebElement bnkNameText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("bank_name")));	
bnkNameText.sendKeys(bnkName);
}

public void accountNameTextBox(String accName)
{
WebElement accNameText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("account_name")));	
accNameText.sendKeys(accName);
}
public void accountNoTextBox(String accNo)
{
	
WebElement accNoText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("account_number")));	
accNoText.sendKeys(accNo);
}
public void paymentSubmitBtn()
{
	je.executeScript("window.scrollBy(0,500)");
WebElement payBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()=' Check payment ']")));	
payBtn.click();

WebElement confirmMsg = wait.until(
        ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//div[@data-test='payment-success-message']")
        )
    );

Assert.assertEquals(
	    confirmMsg.getText(),
	    "Payment was successful"
	);
}

public void orderConfirmation()
{
	
WebElement confirmBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()=' Confirm ']")));
confirmBtn.click();
WebElement orderMsg = wait.until(ExpectedConditions.visibilityOfElementLocated
		(By.xpath("//*[contains(text(),'Thanks for your order')]")));

	Assert.assertTrue(orderMsg.isDisplayed());

}

}



package pages;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
public class Home_Page  {

	WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor je;
	
public Home_Page(WebDriver driver) {
		this.driver=driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	    this.je = (JavascriptExecutor) driver;
	}
public void openHomePage() {
	
WebElement home_btn = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Home")));
home_btn.click();

	
}
public void openProduct() {

	je.executeScript("window.scrollBy(0,500)");
	
	
WebElement pdct = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//img[@src='assets/img/products/pliers02.avif']")));
pdct.click();
String actualURL = driver.getCurrentUrl();
Assert.assertTrue(actualURL.contains("product") );

}
	
	
}

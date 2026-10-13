package pages;



import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage {
	WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor je;
	

	public ProductPage(WebDriver driver)
	{
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 this.je = (JavascriptExecutor) driver;
	}
	public void addToCart()
	{je.executeScript("window.scrollBy(0,500)");
		WebElement addcartBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("btn-add-to-cart")));
		addcartBtn.click();
		System.out.println("Item added to cart successfully");
		
	}
	public void openCart()
	{je.executeScript("window.scrollBy(0,-500)");
	WebElement carticon = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='/checkout']")));
	carticon.click();
	}
}

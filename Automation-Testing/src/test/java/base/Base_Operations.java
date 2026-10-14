package base;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import pages.BillingAddress_Checkout_Page;
import pages.Checkout_Page;
import pages.Home_Page;
import pages.Payment_Checkout;
import pages.ProductPage;

public class Base_Operations {
	protected WebDriver driver;
	protected WebDriverWait wait;
	protected Home_Page homeObj;
	protected JavascriptExecutor je;
	protected ProductPage prdPage;
	protected Checkout_Page chkoutpge; 
	protected BillingAddress_Checkout_Page bilObj;
	protected Payment_Checkout paymentObj;

@BeforeClass
public void browser_launch() {
    driver = new ChromeDriver();
	driver.get("https://practicesoftwaretesting.com/auth/login");
	driver.manage().window().maximize();
	homeObj =new Home_Page(driver);
	chkoutpge = new Checkout_Page(driver);
	bilObj = new BillingAddress_Checkout_Page(driver);
	paymentObj = new Payment_Checkout (driver);
	
}

public void takeScreenshots(String pageName) throws IOException
{
 TakesScreenshot tss=(TakesScreenshot)	driver;
 File source = tss.getScreenshotAs(OutputType.FILE);
 File destination = new File("./Screenshots/"+pageName+".png");
 FileUtils.copyFile(source, destination);
System.out.println(pageName + " screenshot captured");
}

@AfterClass
public void browser_close() {
	
	//driver.quit();
	
}
}

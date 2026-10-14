	package test;
	

	import java.io.IOException;

import org.testng.annotations.*;

import base.Base_Operations;
import pages.ProductPage;
import pages.SignIn_Page;

	public class Test_class extends Base_Operations
	{
	@Test
	public void validSignIn() throws IOException
	{
		takeScreenshots("BeforeSign_In");
		System.out.println("Login started");
		SignIn_Page obj_sip = new SignIn_Page(driver);
		obj_sip.Username_textbox("customer3@practicesoftwaretesting.com");
		obj_sip.Password_textbox("pass123");
		obj_sip.SignIn_Button();
		takeScreenshots("Sign_In");
		
	}
		@Test(dependsOnMethods = "validSignIn")
			
	public void toOpenHomePage() throws IOException
	{
		takeScreenshots("BeforeHomePage");	
		homeObj.openHomePage();
		takeScreenshots("HomePage");
	}
	 
	@Test(dependsOnMethods="toOpenHomePage")
	public void toOpenProduct() throws IOException {
		takeScreenshots("BeforeProductDetail");
		homeObj.openProduct();	
		takeScreenshots("ProductDetail");
	}
	@Test(dependsOnMethods="toOpenProduct")
	public void addToCart() throws IOException{
		
		takeScreenshots("BeforeAddToCart");
		prdPage=new ProductPage(driver);
		prdPage.addToCart();
		prdPage.openCart();
		takeScreenshots("AddToCart");
	}
	
	
	@Test(dependsOnMethods="addToCart")
	public void cart_CheckoutTest() throws IOException
	{ 
		takeScreenshots("BeforeCheckout_Cart");
		chkoutpge.cart_Checkout();
		takeScreenshots("Checkout_Cart");
	}
	
	
	@Test(dependsOnMethods="cart_CheckoutTest")
	public void signin_CheckoutTest() throws IOException
	{
		takeScreenshots("BeforeCheckout_Sign_In");
		chkoutpge.signin_Checkout();
		takeScreenshots("Checkout_Sign_In");
	}
	
	@Test(dependsOnMethods="signin_CheckoutTest")
	public void billingAddress_CheckoutTest() throws IOException
	{  
		takeScreenshots("BeforeCheckout_Billing_Address");
		bilObj.countrydropDown();	
		bilObj.postCde_TextBox("627008");
		bilObj.houseNo_TextBox("7G");
		//bilObj.streetTextBox("Rainbow Colony");
		bilObj.cityTextBox("Coimbatore");
		bilObj.stateTextBox("Tamilnadu");
		bilObj.billAddress_proceed3rdbtn();
		takeScreenshots("Checkout_Billing_Address");
	}
	@Test(dependsOnMethods="billingAddress_CheckoutTest")
	public void payment_CheckoutTest() throws IOException
	{ 
		takeScreenshots("BeforePaymentCheckout");
		paymentObj.paymentMode();	
		paymentObj.bankNameTextBox("Lakshmi Vilas Bank");
		paymentObj.accountNameTextBox("Halima");
		paymentObj.accountNoTextBox("1234567890");
		paymentObj.paymentSubmitBtn();
		paymentObj.orderConfirmation();
		takeScreenshots("PaymentCheckout");
	}
}
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
public class SwagLabsTest {	
	Verfications verify= new Verfications();
	@BeforeTest
	public void setUp() {
verify.driver.get("https://www.saucedemo.com/");
	}
	@Test(priority=1)
	public void logIn() {
	WebElement userName=verify.driver.findElement(By.xpath("//input[@data-test='username']"));
	userName.sendKeys("standard_user");
	WebElement password=verify.driver.findElement(By.xpath("//input[@data-test='password']"));
	password.sendKeys("secret_sauce");
	WebElement loginButton=	verify.driver.findElement(By.xpath("//input[@data-test='login-button']"));
	loginButton.click();
	}
	@Test(priority=2)
	public void verifyTitle() {
		WebElement title=verify.driver.findElement(By.xpath("//span[@data-test='title']"));
		boolean expectedTitle=true;
		boolean actualTitle=title.isDisplayed();
		Assert.assertEquals(actualTitle, expectedTitle);
		System.out.println(title.getText());
	}
@Test(priority=3)
public void highToLow() throws InterruptedException {
verify.verifyStructure("Price (high to low)");
verify.verifyPrices(0,5);
//verify.addAllItems();
//verify.addAllItems();
//verify.addLeftItems();
//verify.addLeftItems();
//verify.addAllRightItem();
//verify.addAllRightItem();
//verify.addFirstTwoItems();
//verify.addAllItemsExceptFirstTwoItems();
//verify.findLabsWordAndAddThem();
//verify.findLabsWordAndAddThem();
//verify.addTheItemsWithoutLabsWord();
verify.addItemMoreThan15dollar();
}
@Test(priority=4,enabled=false)
public void lowToHigh() throws InterruptedException {
  verify.driver.navigate().refresh();
  verify.verifyStructure("Price (low to high)");
  verify.verifyPrices(5, 0);

}
}

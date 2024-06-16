import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Verfications {
	WebDriver driver=new ChromeDriver();
	
	public void verifyStructure(String structure) {
		
		WebElement element=driver.findElement(By.className("product_sort_container"));
		Select mySelector=new Select(element);
         element.click();
         mySelector.selectByVisibleText(structure);
    
	}
	public void verifyPrices(int indexHigh,int indexLow) {
		List<WebElement> itemsPrices=driver.findElements(By.className("inventory_item_price"));
	     String HighestPrice=itemsPrices.get(indexHigh).getText().replace("$", "");
	     double highestPrice=Double.parseDouble(HighestPrice);
	     String LowestPrice=itemsPrices.get(indexLow).getText().replace("$", "");
	     double lowestPrice=Double.parseDouble(LowestPrice);
	     Boolean highestHigherThanLowest=true;
	     Assert.assertEquals(highestPrice>lowestPrice, true); 
	}
public void addAllItems() throws InterruptedException {
	List<WebElement>addItems=driver.findElements(By.className("btn"));
	for(int i=0;i<=addItems.size()-1;i++) {
		addItems.get(i).click();
		Thread.sleep(3000);
	}
	}
	public void addLeftItems() throws InterruptedException {
		List<WebElement>addItems=driver.findElements(By.className("btn"));
		for(int i=0;i<=addItems.size()-1;i=i+2) {
			addItems.get(i).click();
			Thread.sleep(3000);
		}
			
		}
		public void addAllRightItem() throws InterruptedException {
			List<WebElement>addItems=driver.findElements(By.className("btn"));
			for(int i=1;i<=addItems.size()-1;i=i+2) {
				addItems.get(i).click();
				Thread.sleep(3000);
				
			}
			
			
}
		public void addFirstTwoItems() throws InterruptedException {
			List<WebElement>addItems=driver.findElements(By.className("btn"));
			for(int i=0;i<=addItems.size();i++) {
				if(i==2) {
					break;
				}
				else {
					addItems.get(i).click();
					Thread.sleep(3000);
				}
			}
			}	
		public void addAllItemsExceptFirstTwoItems() throws InterruptedException {
			List<WebElement>addItems=driver.findElements(By.className("btn"));
			for(int i=0;i<=addItems.size();i++) {
				if(i==0 ||i==1) {
					continue;
				}
				else {
					addItems.get(i).click();
					Thread.sleep(3000);
				}
			}
			}
		public void findLabsWordAndAddThem() {
			List<WebElement>addLabsItems=driver.findElements(By.className("inventory_item_name"));
			List<WebElement>addItems=driver.findElements(By.className("btn"));
			
           for(int i=0;i<=addLabsItems.size()-1;i++) {
        	   String itemsNames=addLabsItems.get(i).getText();
        	   if(itemsNames.contains("Labs")) {
        		   addItems.get(i).click();
        	   }
           }
			

		}
public void addTheItemsWithoutLabsWord() {
	List<WebElement>itemsNames=driver.findElements(By.className("inventory_item_name"));
	List<WebElement>addItems=driver.findElements(By.className("btn"));
	for(int i=0;i<=itemsNames.size()-1;i++) {
		String elementNames=itemsNames.get(i).getText();
		if(elementNames.contains("Labs")) {
			continue;
		}
		else {
			addItems.get(i).click();
		}
	}
}
}

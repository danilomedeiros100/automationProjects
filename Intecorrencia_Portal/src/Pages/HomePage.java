package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

	private static WebElement element = null;

	public static WebElement System_Management(WebDriver driver) {

		element = driver.findElement(By.xpath("//*[@id='navigator']/div[2]/div/a[1]"));
		return element;
	}

	public static WebElement Interconnection_Wholesale_Services(WebDriver driver) {

		element = driver.findElement(By.xpath("//*[@id='navigator']/div[2]/div/a[2]"));
		return element;
	}

	public static WebElement MVNE_Service(WebDriver driver) {

		element = driver.findElement(By.xpath("//*[@id='navigator']/div[2]/div/a[3]"));
		return element;                         
	}
	public static WebElement Extraction_CDR(WebDriver driver) {
		
		element = driver.findElement(By.xpath("//*[@id='navigator']/div[2]/div/a[4]"));
		return element;                         
	}
	public static WebElement Conciliation_Entities(WebDriver driver) {
		
		element = driver.findElement(By.xpath("//*[@id='navigator']/div[2]/div/a[5]"));
		return element;                         
	}
	public static WebElement Conciliation_Functions(WebDriver driver) {
		
		element = driver.findElement(By.xpath("//*[@id='navigator']/div[2]/div/a[6]"));
		return element;                         
	}
	public static WebElement DETRAF(WebDriver driver) {
		
		element = driver.findElement(By.xpath("//*[@id='navigator']/div[2]/div/a[7]"));
		return element;                         
	}
	public static WebElement CoBilling(WebDriver driver) {
		
		element = driver.findElement(By.xpath("//*[@id='navigator']/div[2]/div/a[8]"));
		return element;                         
	}

}

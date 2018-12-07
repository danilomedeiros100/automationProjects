package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	private static WebElement element = null;

	public static WebElement User_login(WebDriver driver) {

		element = driver.findElement(By.xpath("//*[@id=\'USER\']"));
		return element;
	}

	public static WebElement password_login(WebDriver driver) {

		element = driver.findElement(By.xpath("//*[@id=\'PASSWORD\']"));
		return element;
	}

	public static WebElement btn_acessar(WebDriver driver) {

		element = driver.findElement(By.xpath("//*[@id=\'btnSubmit\']"));
		return element;
	}
	
	
}

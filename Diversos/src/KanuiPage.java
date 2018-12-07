import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class KanuiPage {
	private static WebElement element = null;

	public static WebElement login(WebDriver driver) {

		element = driver.findElement(By.xpath("//*[@id=\'email\']"));
		return element;
	}

	public static WebElement senha(WebDriver driver) {

		element = driver.findElement(By.xpath("//*[@id=\'pass\']"));
		return element;
	}

	public static WebElement logar(WebDriver driver) {

		element = driver.findElement(By.xpath("//*[@id=\'u_0_6\']"));
		return element;
	}

	public static WebElement abrirMensagem(WebDriver driver) {

		element = driver.findElement(By.xpath("//*[@id=\'u_0_13\']/div/div[2]/div/div/button"));
		return element;
	}

	public static WebElement escreverMensagem(WebDriver driver) {

		element = driver.findElement(By.cssSelector("#cch_f3e2a190f53effc > div > div > div._5rpb > div > div > div > div"));
		return element; // *[@id='cch_f369964cd7a18c']/div/div/div[2]/div/div/div/div
	}           
	public static WebElement enviar(WebDriver driver) {
		
		element = driver.findElement(By.cssSelector("//*[@id=\'js_5n\']"));
		return element; 
	}           
          
public static WebElement sci_url(WebDriver driver) {
	
	element = driver.findElement(By.xpath("//*[@id=\'input\']/form/input[2]"));
	return element; 
}           
public static WebElement sci_open(WebDriver driver) {
	
	element = driver.findElement(By.xpath("//*[@id=\'open\']/p"));
	return element; 
}           
public static WebElement sci_save(WebDriver driver) {
	
	element = driver.findElement(By.xpath("//*[@id=\'buttons\']/ul/li[2]/a"));
	return element; 
}           

}

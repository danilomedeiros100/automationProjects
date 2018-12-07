package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class System_Management_Page {

	private static WebElement element = null;

	public static WebElement System_Management(WebDriver driver) {

		element = driver.findElement(By.xpath("//*[@id='navbar']/ul[1]/li[1]/a"));
		return element;
	}

	public static WebElement Tim_Longa_Distancia(WebDriver driver) {

		element = driver.findElement(By.xpath("//*[@id='portletInstance_3node7']/div/div[1]/a/b"));
		return element; // *[@id="portletInstance_3node7"]/div/div[1]/a/b
	}

	public static WebElement Tim_LD_Controller_LD(WebDriver driver) {

		element = driver.findElement(By.xpath("//*[@id=\'portletInstance_3b20pController_LD\']"));
		return element;
	}

	public static WebElement start_processo(WebDriver driver) {

		element = driver.findElement(By.xpath("//*[@id='portletInstance_3btnStart']"));
		return element; // *[@id="portletInstance_3btnStart"]
	}

	public static WebElement close_modal_processo(WebDriver driver) {

		element = driver
				.findElement(By.xpath("//*[@id=\'portletInstance_3processAutomaticInfo\']/div/div/div[1]/button/span"));
		return element;
	}

	public static WebElement Tim_VAS(WebDriver driver) {

		element = driver.findElement(By.xpath("//*[@id=\'portletInstance_3node10\']/div/div[1]/a/b"));
		return element;
	}

	public static WebElement Controller_VAS(WebDriver driver) {

		element = driver.findElement(By.xpath("//*[@id='portletInstance_3b29pController_VAS']"));
		return element;
	}
	public static WebElement Master_Control_VAS(WebDriver driver) {
		
		element = driver.findElement(By.xpath("//*[@id=\\'portletInstance_3b29pMaster_Control_VAS\\']"));
		return element;
	}

	public static String atributo_Controller_VAS(WebDriver driver) {

		element = driver.findElement(By.xpath("//*[@id='portletInstance_3b29pController_VAS']"));

		return element.getAttribute("data-status");
	}

	public static String atributo_Master_Control_VAS(WebDriver driver) {

		element = driver.findElement(By.xpath("//*[@id=\'portletInstance_3b29pMaster_Control_VAS\']"));

		return element.getAttribute("data-status");
	}

}

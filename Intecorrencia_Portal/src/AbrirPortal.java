
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.System_Management_Page;
import atu.testrecorder.ATUTestRecorder;
import atu.testrecorder.exceptions.ATUTestRecorderException;

public class AbrirPortal {
	@Test
	public void abrirPortal() throws InterruptedException, ATUTestRecorderException {

		WebDriver driver;
		ATUTestRecorder grava;
		StringBuilder text;

		// public void setUp() throws ATUTestRecorderException, InterruptedException{

		DateFormat dateFormat = new SimpleDateFormat("yy-MM-dd HH-mm-ss");
		Date date = new Date();

		grava = new ATUTestRecorder("C:\\imagens\\", "teste video" + dateFormat.format(date), false);
		
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		ChromeOptions options = new ChromeOptions();
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		options.addArguments("--incognito");
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		driver = new ChromeDriver();
		// ChromeOptions options = new ChromeOptions();

		driver.get(Input.PORTAL);

		// Dimension targetSize = new Dimension(1900, 1300);
		// driver.manage().window().setSize(targetSize);
		driver.manage().window().maximize();
		grava.start();
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("USER")));

		LoginPage.User_login(driver).sendKeys(Input.USER);
		LoginPage.password_login(driver).sendKeys(Input.PASSAWORD);
		LoginPage.btn_acessar(driver).click();
		

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("list-group-item")));

		HomePage.System_Management(driver).click();

		System_Management_Page.System_Management(driver).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("portletInstance_3nodeBtn13")));

		System_Management_Page.Tim_VAS(driver).click();

		// System_Management_Page.Tim_Longa_Distancia(driver).click();
		//
		// Thread.sleep(5000);
		//
		// System_Management_Page.Tim_LD_Controller_LD(driver).click();
		//
		// Thread.sleep(5000);
		//
		// Thread.sleep(15000);

		System.out.println("Name of the button is:- " + System_Management_Page.atributo_Controller_VAS(driver));

		String Controller_VAS = System_Management_Page.atributo_Controller_VAS(driver);
		String Master_Control_Vas = System_Management_Page.atributo_Master_Control_VAS(driver);

		if (Controller_VAS.equals("RUNNING")) {
			System.out.println("é igual a rodando");
		} else {
			Thread.sleep(5000);
			System_Management_Page.Controller_VAS(driver).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("portletInstance_3btnStart")));

			Thread.sleep(2000);

			System_Management_Page.start_processo(driver).click();

			Thread.sleep(5000);
			System_Management_Page.close_modal_processo(driver).click();

		}

		if (Master_Control_Vas.equals("RUNNING")) {

		} else {

			Thread.sleep(5000);
			System_Management_Page.Master_Control_VAS(driver).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("portletInstance_3btnStart")));

			Thread.sleep(2000);

			System_Management_Page.start_processo(driver).click();

			Thread.sleep(5000);
			System_Management_Page.close_modal_processo(driver).click();
			System_Management_Page.Master_Control_VAS(driver).click();

		}
grava.stop();

	}

}

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import atu.testrecorder.ATUTestRecorder;
import atu.testrecorder.exceptions.ATUTestRecorderException;

public class ScreenRecord {

	ATUTestRecorder grava;
	WebDriver navegador;
	WebDriver driver;

	@Test
	public void setUp() throws ATUTestRecorderException, InterruptedException{

DateFormat dateFormat = new SimpleDateFormat("yy-MM-dd HH-mm-ss");
Date date = new Date();

grava = new ATUTestRecorder("C:\\imagens\\", "teste video"+dateFormat.format(date) , false);



//public void abrirPortal() throws InterruptedException {
DesiredCapabilities capabilities = DesiredCapabilities.chrome();
ChromeOptions options = new ChromeOptions();
capabilities.setCapability(ChromeOptions.CAPABILITY, options);
options.addArguments("--incognito");
System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
driver = new ChromeDriver();
driver.manage().window().maximize();
// ChromeOptions options = new ChromeOptions();
grava.start();

driver.get("http://www.google.com.br");
	

Thread.sleep(5000);


grava.stop();


	
	}}



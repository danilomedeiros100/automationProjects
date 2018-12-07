import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.python.modules.thread.thread;

public class SCI_HUB {
	@Test
	public void sci_hub() throws InterruptedException {
		WebElement element = null;
		WebDriver driver = null;
		Actions action;
		Random rn = new Random();

		String[] link = {"https://dl.acm.org/citation.cfm?id=3196440",
				"https://dl.acm.org/citation.cfm?id=2486848",
				"https://dl.acm.org/citation.cfm?id=3182530",
				"https://dl.acm.org/citation.cfm?id=3021478",
				"https://dl.acm.org/citation.cfm?id=1869630",
				"https://dl.acm.org/citation.cfm?id=2901745",
				"https://dl.acm.org/citation.cfm?id=2818805",
				"https://dl.acm.org/citation.cfm?id=3183553",
				"https://dl.acm.org/citation.cfm?id=3143445",
				"https://dl.acm.org/citation.cfm?id=2742820",
				"https://dl.acm.org/citation.cfm?id=3183553",
				"https://dl.acm.org/citation.cfm?id=3195067",
				"https://dl.acm.org/citation.cfm?id=3106202",
				"https://dl.acm.org/citation.cfm?id=3180158",
				"https://dl.acm.org/citation.cfm?id=3098021",
				"https://dl.acm.org/citation.cfm?id=3084105",
				"https://dl.acm.org/citation.cfm?id=1822341",
				"https://dl.acm.org/citation.cfm?id=2857224",
				"https://dl.acm.org/citation.cfm?id=2807437"};

		//"https://dl.acm.org/citation.cfm?id=2108151",
		//https://dl.acm.org/citation.cfm?id=2663306
		//"https://dl.acm.org/citation.cfm?id=3014339"
		//
		//
		//https://sci-hub.tw/https://dl.acm.org/citation.cfm?id=1985362
		//https://sci-hub.tw/https://dl.acm.org/citation.cfm?id=2830739
		//https://sci-hub.tw/https://dl.acm.org/citation.cfm?id=1985362
		//https://sci-hub.tw/https://dl.acm.org/citation.cfm?id=2666036
		//https://sci-hub.tw/https://dl.acm.org/citation.cfm?id=2693983
		//https://sci-hub.tw/https://dl.acm.org/citation.cfm?id=3257317
		//https://sci-hub.tw/https://dl.acm.org/citation.cfm?id=2830739
		//https://sci-hub.tw/https://dl.acm.org/citation.cfm?id=2663297
		//https://sci-hub.tw/https://dl.acm.org/citation.cfm?id=3194164
		//
		//
		//
		
		
		
		StringBuilder text;

		for (int i = 0; i < link.length; i++) {
			String string = link[i];

			DesiredCapabilities capabilities = DesiredCapabilities.chrome();
			ChromeOptions options = new ChromeOptions();
			capabilities.setCapability(ChromeOptions.CAPABILITY, options);
			options.addArguments("--incognito");
			System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
			driver = new ChromeDriver();
			action = new Actions(driver);

			// Redley
			driver.get("https://sci-hub.tw/" + link[i]);
			driver.manage().window().maximize();
			
			//Thread.sleep(1000);
		//	KanuiPage.sci_save(driver).click();
		//	Thread.sleep(1000);
			// driver.get("https://dl.acm.org/results.cfm?query=(%22Agile%20Methodology%22%20%252B%22Technical%20Debt%22%20%22Agile%20Methodologies%22%20%22Software%20Quality%22%20%22Software%20Quality%22)&within=owners.owner=HOSTED&filtered=&dte=&bfr=");

			// KanuiPage.sci_url(driver).sendKeys(link[i]);
			// KanuiPage.sci_open(driver).click();

		}

	}
}

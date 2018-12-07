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

public class Buscador_Scopus {
	@Test
	public void buscador_scopus() throws InterruptedException {
		WebElement element = null;
		WebDriver driver = null;
		Actions action;
		Random rn = new Random();

		StringBuilder text;

		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		ChromeOptions options = new ChromeOptions();
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
	//	options.addArguments("--incognito");
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		driver = new ChromeDriver();
		action = new Actions(driver);

		// Redley
		driver.get(
				"https://www-scopus.ez184.periodicos.capes.gov.br/results/results.uri?sort=plf-f&src=s&nlo=&nlr=&nls=&sid=fe7867e1250a08fa9d50d0c0d7cee769&sot=a&sdt=cl&cluster=scopubyr%2c%222018%22%2ct%2c%222017%22%2ct%2c%222016%22%2ct%2c%222015%22%2ct%2c%222014%22%2ct%2c%222013%22%2ct%2c%222012%22%2ct%2c%222011%22%2ct%2c%222010%22%2ct&sl=174&s=%28%22Technical+Debt%22+OR+%22technical+problems%22+OR+%22design+debt%22%29+AND+%28%22agile+methodology%22+OR+%22agile+methodologies%22+OR+%22agile+software+development%22+OR+%22agile+development%22+OR+%22ASD%22%29&origin=resultslist&zone=leftSideBar&editSaveSearch=&txGid=a168c93d90ccd02f84ecd13765d44a89");

		Thread.sleep(5000);
		driver.get(
				"https://www-scopus.ez184.periodicos.capes.gov.br/results/results.uri?sort=plf-f&src=s&nlo=&nlr=&nls=&sid=fe7867e1250a08fa9d50d0c0d7cee769&sot=a&sdt=cl&cluster=scopubyr%2c%222018%22%2ct%2c%222017%22%2ct%2c%222016%22%2ct%2c%222015%22%2ct%2c%222014%22%2ct%2c%222013%22%2ct%2c%222012%22%2ct%2c%222011%22%2ct%2c%222010%22%2ct&sl=174&s=%28%22Technical+Debt%22+OR+%22technical+problems%22+OR+%22design+debt%22%29+AND+%28%22agile+methodology%22+OR+%22agile+methodologies%22+OR+%22agile+software+development%22+OR+%22agile+development%22+OR+%22ASD%22%29&origin=resultslist&zone=leftSideBar&editSaveSearch=&txGid=a168c93d90ccd02f84ecd13765d44a89");

		WebElement page = driver.findElement(By.xpath("//*[@id=\"resultsPerPage-button\"]/span[1]"));		
		page.click();
		WebElement set = driver.findElement(By.xpath("//*[@id=\"ui-id-4\"]"));		
		set.click();
		WebElement next = driver.findElement(By.xpath("//*[@id=\"resultsFooter\"]/div[2]/ul/li[2]/a"));		
		next.click();
		Thread.sleep(5000);
		
		ArrayList<String> links = new ArrayList<>();
		ArrayList<String> nome = new ArrayList<>();
		ArrayList<String> ano = new ArrayList<>();
		ArrayList<String> citacao = new ArrayList<>();
		ArrayList<String> evento = new ArrayList<>();
		int cont = 0;
		int cont2 = 3;
		Thread.sleep(25000);
		do {
			// LINK
			links.add(driver.findElement(By.xpath("//*[@id='resultDataRow"+cont+"']/td[1]/a")).getAttribute("href"));
			// Nome
			nome.add(driver.findElement(By.xpath("//*[@id='resultDataRow"+cont+"']/td[1]/a")).getText());
			// ANO
			ano.add(driver.findElement(By.xpath("//*[@id='resultDataRow"+cont+"']/td[3]")).getText());
			
			// CITAÇÂO
			ano.add(driver.findElement(By.xpath("//*[@id='resultDataRow"+cont+"']/td[5]")).getText());

		
			// WebElement el =
			// driver.findElement(By.xpath("//*[@id='xplMainContent']/div[2]/div[2]/xpl-results-list/div["+cont2+"]/xpl-results-item/div[1]/div[2]/div[1]/div[3]/span/a"));

			// if (el != null) {
			// citacao.add(el.getText());
			// }else {
			// citacao.add("--");
			// }

			// citacao.add(driver.findElement(By.xpath("//*[@id='xplMainContent']/div[2]/div[2]/xpl-results-list/div["+cont2+"]/xpl-results-item/div[1]/div[2]/div[1]/div[3]/span/a")).getText());

			// LINK

//			System.out
//					.println(
//							" - " + driver
//									.findElement(
//											By.xpath("//*[@id=\"xplMainContent\"]/div[2]/div[2]/xpl-results-list/div["
//													+ cont + "]/xpl-results-item/div[1]/div[2]/h2/a"))
//									.getAttribute("href"));
			// System.out.println(" - " +
			// driver.findElement(By.xpath("//*[@id=\"xplMainContent\"]/div[2]/div[2]/xpl-results-list/div["+
			// cont + "]/xpl-results-item/div[1]/div[2]/h2/a")).getAttribute("href"));

			cont= cont+1;
			cont2 = cont2 + 1;

			try {
				driver.findElement(By.xpath("//*[@id='resultDataRow"+cont+"']/td[1]/a")).getText();

			} catch (Exception e) {
				// TODO Auto-generated catch block
				// e.printStackTrace();
				break;
			}

		} while (true);

		try {
			FileWriter write = new FileWriter("C:\\Users\\danilo.medeiros\\Desktop\\Resultado_busca_Scopus2.txt");
			PrintWriter print = new PrintWriter(write);

			for (int i = 0; i < links.size(); i++) {
				print.println(links.get(i));
			}
			for (int i = 0; i < nome.size(); i++) {
				print.println(nome.get(i));
			}

			for (int i = 0; i < ano.size(); i++) {
				print.println(ano.get(i));
			}
//			for (int i = 0; i < evento.size(); i++) {
//				print.println(evento.get(i));
//			}
			for (int i = 0; i < citacao.size(); i++) {
				print.println(citacao.get(i));
			}

			write.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		action.sendKeys("Deveriam respeitar mais o cliente e não enviar mensagem por Robô").perform();

		/*
		 * // ChromeOptions options = new ChromeOptions();
		 * driver.get("https://www.facebook.com/kanuibr/"); // Dimension targetSize =
		 * new Dimension(1900, 1300); // driver.manage().window().setSize(targetSize);
		 * driver.manage().window().maximize();
		 * KanuiPage.login(driver).sendKeys("danilomedeiros100@gmail.com");
		 * KanuiPage.senha(driver).sendKeys("D@6360805");
		 * KanuiPage.logar(driver).click();
		 * driver.get("https://www.facebook.com/messages/t/kanuibr");
		 * 
		 * Thread.sleep(2000); for (int i = 0; i < 100000; i++) {
		 * 
		 * action.
		 * sendKeys("Deveriam respeitar mais o cliente e não enviar mensagem por Robô").
		 * perform(); action.sendKeys(Keys.ENTER).perform(); Thread.sleep(10000);
		 * action.sendKeys("Falta de Respeito").perform();
		 * action.sendKeys(Keys.ENTER).perform(); Thread.sleep(10000);
		 * 
		 * }
		 */

	}
}

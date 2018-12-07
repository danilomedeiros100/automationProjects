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

public class BuscadorIEEE {
	@Test
	public void kanui() throws InterruptedException {
		WebElement element = null;
		WebDriver driver = null;
		Actions action;
		Random rn = new Random();

		StringBuilder text;

		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		ChromeOptions options = new ChromeOptions();
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		options.addArguments("--incognito");
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		driver = new ChromeDriver();
		action = new Actions(driver);

		// Redley
		driver.get(
				"https://ieeexplore.ieee.org/search/searchresult.jsp?queryText=(%22Technical%20Debt%22%20OR%20%22Technical%20problems%22%20OR%20%22design%20debt%22)%20AND%20(%22agile%20methodology%22%20OR%20%22agile%20methodologies%22%20OR%20%22agile%20software%20development%22%20OR%20%22agile%20development%22%20OR%20%22ASD%22)&highlight=true&returnFacets=ALL&returnType=SEARCH&rowsPerPage=100");

		// driver.get("https://dl.acm.org/results.cfm?query=(%22Agile%20Methodology%22%20%252B%22Technical%20Debt%22%20%22Agile%20Methodologies%22%20%22Software%20Quality%22%20%22Software%20Quality%22)&within=owners.owner=HOSTED&filtered=&dte=&bfr=");

		ArrayList<String> links = new ArrayList<>();
		ArrayList<String> nome = new ArrayList<>();
		ArrayList<String> ano = new ArrayList<>();
		ArrayList<String> citacao = new ArrayList<>();
		ArrayList<String> evento = new ArrayList<>();
		int cont = 3;
		int cont2 = 3;
		Thread.sleep(25000);
		do {
			// LINK
			links.add(driver.findElement(By.xpath("//*[@id=\"xplMainContent\"]/div[2]/div[2]/xpl-results-list/div["
					+ cont + "]/xpl-results-item/div[1]/div[2]/h2/a")).getAttribute("href"));
			// Nome
			nome.add(driver.findElement(By.xpath("//*[@id=\"xplMainContent\"]/div[2]/div[2]/xpl-results-list/div["
					+ cont + "]/xpl-results-item/div[1]/div[2]/h2/a")).getText());
			// ANO
			ano.add(driver.findElement(By.xpath("//*[@id=\"xplMainContent\"]/div[2]/div[2]/xpl-results-list/div[" + cont
					+ "]/xpl-results-item/div[1]/div[2]/div[1]/div[1]/span[1]")).getText());
			// EVENTO
			evento.add(driver.findElement(By.xpath("//*[@id=\"xplMainContent\"]/div[2]/div[2]/xpl-results-list/div["
					+ cont + "]/xpl-results-item/div[1]/div[2]/div[1]/a")).getText());
			// CITAÇÂO

			try {
				WebElement el = driver
						.findElement(By.xpath("//*[@id='xplMainContent']/div[2]/div[2]/xpl-results-list/div[" + cont2
								+ "]/xpl-results-item/div[1]/div[2]/div[1]/div[3]/span/a"));
				citacao.add(el.getText());
			} catch (Exception e) {
				citacao.add("--");
			}

			// WebElement el =
			// driver.findElement(By.xpath("//*[@id='xplMainContent']/div[2]/div[2]/xpl-results-list/div["+cont2+"]/xpl-results-item/div[1]/div[2]/div[1]/div[3]/span/a"));

			// if (el != null) {
			// citacao.add(el.getText());
			// }else {
			// citacao.add("--");
			// }

			// citacao.add(driver.findElement(By.xpath("//*[@id='xplMainContent']/div[2]/div[2]/xpl-results-list/div["+cont2+"]/xpl-results-item/div[1]/div[2]/div[1]/div[3]/span/a")).getText());

			// LINK

			System.out
					.println(
							" - " + driver
									.findElement(
											By.xpath("//*[@id=\"xplMainContent\"]/div[2]/div[2]/xpl-results-list/div["
													+ cont + "]/xpl-results-item/div[1]/div[2]/h2/a"))
									.getAttribute("href"));
			// System.out.println(" - " +
			// driver.findElement(By.xpath("//*[@id=\"xplMainContent\"]/div[2]/div[2]/xpl-results-list/div["+
			// cont + "]/xpl-results-item/div[1]/div[2]/h2/a")).getAttribute("href"));

			cont++;
			cont2 = cont2 + 1;

			try {
				driver.findElement(By.xpath("//*[@id=\"xplMainContent\"]/div[2]/div[2]/xpl-results-list/div[" + cont
						+ "]/xpl-results-item/div[1]/div[2]/h2/a")).getText();

			} catch (Exception e) {
				// TODO Auto-generated catch block
				// e.printStackTrace();
				break;
			}

		} while (true);

		try {
			FileWriter write = new FileWriter("C:\\Users\\danilo.medeiros\\Desktop\\Resultado_busca_IEEE.txt");
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
			for (int i = 0; i < evento.size(); i++) {
				print.println(evento.get(i));
			}
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
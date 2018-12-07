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

public class BuscadorACM {

	@Test
	public void buscadorACM() throws InterruptedException {
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
		ArrayList<String> links = new ArrayList<>();
		ArrayList<String> nome = new ArrayList<>();
		ArrayList<String> ano = new ArrayList<>();
		ArrayList<String> citacao = new ArrayList<>();
		ArrayList<String> evento = new ArrayList<>();
		for (int i = 0; i < 9; i++) {

			// Redley
			// driver.get("https://ieeexplore.ieee.org/search/searchresult.jsp?action=search&searchField=Search_All&matchBoolean=true&queryText=(((((%22Agile%20Methodologies%22)%20OR%20%22agile%20methodology%22)%20OR%20%22Software%20Engineering%22)%20OR%20%22Software%20Quality%22)%20AND%20%22Technical%20Debt%22)&highlight=true&returnFacets=ALL&returnType=SEARCH&rowsPerPage=200");
//			driver.get("https://dl.acm.org/results.cfm?query=%28%22Agile%20Methodology%22%20%252B%22Technical%20Debt%22%20%22Agile%20Methodologies%22%20%22Software%20Quality%22%20%22Software%20Quality%22%29&start="+ 20 * i + "&filtered=&within=owners%2Eowner%3DHOSTED&dte=&bfr=&srt=_score");
			driver.get("https://dl.acm.org/results.cfm?within=owners.owner%3DHOSTED&srt=_score&query=%28%22Technical+Debt%22%29+AND+%28%22agile+methodology%22+OR+%22agile+methodologies%22+OR+%22agile+software+development%22+OR+%22agile+development%22+OR+%22ASD%22%29&Go.x=0&Go.y=0");
		           //	https://dl.acm.org/results.cfm?within=owners.owner%3DHOSTED&srt=_score&query=%28%22Technical+Debt%22%29+AND+%28%22agile+methodology%22+OR+%22agile+methodologies%22+OR+%22agile+software+development%22+OR+%22agile+development%22+OR+%22ASD%22%29&Go.x=0&Go.y=0
			int cont = 5;
			int cont2 = 7;
			Thread.sleep(3000);
			do {
				// link
				links.add(driver.findElement(By.xpath("//*[@id=\"results\"]/div[" + cont + "]/div[1]/a")).getAttribute("href"));
				                                         //*[@id="results"]/div[4]/div[1]/a
				                                         //*[@id="results"]/div[6]/div[1]/a
				                                         //*[@id="results"]/div[8]/div[1]/a
				// nome
				nome.add(driver.findElement(By.xpath("//*[@id=\"results\"]/div[" + cont + "]/div[1]/a")).getText());
				// ano
				ano.add(driver.findElement(By.xpath("//*[@id=\"results\"]/div[" + cont + "]/div[3]/span[1]")).getText());
				//*[@id="results"]/div[4]/div[3]/span[1]
				
				// evento
				evento.add(driver.findElement(By.xpath("//*[@id=\"results\"]/div[" + cont + "]/div[3]/span[2]")).getText());
				// *[@id="results"]/div[7]/div[3]/span[2]
				// citacao
				citacao.add(driver.findElement(By.xpath("//*[@id=\"results\"]/div[" + cont + "]/div[5]/div[2]/div[1]/span")).getText());
				
				
				// Nome
				System.out.print(driver.findElement(By.xpath("//*[@id=\"results\"]/div[" + cont + "]/div[1]/a")).getText());
				// LINK
				System.out.println(" - " + driver.findElement(By.xpath("//*[@id=\"results\"]/div[" + cont + "]/div[1]/a")).getAttribute("href"));

				cont = cont + 2;
				cont2 = cont + 3;

				try {
					driver.findElement(By.xpath("//*[@id=\"results\"]/div[" + cont + "]/div[1]/a")).getText();

				} catch (Exception e) {
					// TODO Auto-generated catch block
					// e.printStackTrace();
					break;
				}

			} while (true);
		}

		try {
			FileWriter write = new FileWriter("C:\\Users\\danilo.medeiros\\Desktop\\Resultado_busca_ACM.txt");
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

	}

}

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

public class Buscador_Springer {
	
	@Test
	public void buscadorSpringer() throws InterruptedException {
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
	for (int i = 1; i < 10; i++) {

		driver.get("https://link.springer.com/search/page/"+i+"?date-facet-mode=between&facet-start-year=2008&facet-end-year=2018&query=%28%22Technical+Debt%22%29+AND+%28%22agile+methodology%22+OR+%22agile+methodologies%22+OR+%22agile+software+development%22+OR+%22agile+development%22+OR+%22ASD%22%29");
		//driver.get("https://dl.acm.org/results.cfm?within=owners.owner%3DHOSTED&srt=_score&query=%28%22Technical+Debt%22%29+AND+%28%22agile+methodology%22+OR+%22agile+methodologies%22+OR+%22agile+software+development%22+OR+%22agile+development%22+OR+%22ASD%22%29&Go.x=0&Go.y=0");
        
		int cont = 1;
		int cont2 = 7;
		Thread.sleep(3000);
		do {
			// link
			links.add(driver.findElement(By.xpath("//*[@id=\"results-list\"]/li["+cont+"]/h2/a")).getAttribute("href"));
			                                        
			// nome
			nome.add(driver.findElement(By.xpath("//*[@id=\"results-list\"]/li["+cont+"]/h2/a")).getText());
			// ano
			ano.add(driver.findElement(By.xpath("//*[@id=\"results-list\"]/li[\"+cont+\"]/p[4]/span[2]/span")).getText());
		
//			// evento
//			evento.add(driver.findElement(By.xpath("//*[@id=\"results\"]/div[" + cont + "]/div[3]/span[2]")).getText());
//			// *[@id="results"]/div[7]/div[3]/span[2]
//			// citacao
//			citacao.add(driver.findElement(By.xpath("//*[@id=\"results\"]/div[" + cont + "]/div[5]/div[2]/div[1]/span")).getText());
			
			
//			// Nome
//			System.out.print(driver.findElement(By.xpath("//*[@id=\"results\"]/div[" + cont + "]/div[1]/a")).getText());
//			// LINK
//			System.out.println(" - " + driver.findElement(By.xpath("//*[@id=\"results\"]/div[" + cont + "]/div[1]/a")).getAttribute("href"));

			cont = cont + 1;
		

			try {
				driver.findElement(By.xpath("//*[@id=\"results-list\"]/li["+cont+"]/h2/a")).getAttribute("href");

			} catch (Exception e) {
				// TODO Auto-generated catch block
				// e.printStackTrace();
				break;
			}

		} while (true);
	}

	try {
		FileWriter write = new FileWriter("C:\\Users\\danilo.medeiros\\Desktop\\Resultado_busca_Springer.txt");
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
//		for (int i = 0; i < evento.size(); i++) {
//			print.println(evento.get(i));
//		}
//		for (int i = 0; i < citacao.size(); i++) {
//			print.println(citacao.get(i));
//		}

		write.close();

	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

}

	

}

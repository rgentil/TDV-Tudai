package docker;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * @author
 *  <ul>
 *    <li>Guillermina Lauge</li>
 *    <li>Pablo Mendoza</li>
 *    <li>Ricardo Gentil</li>
 *  </ul>
 *
 * Clase utilizada para desarrollar los test automatizados para el tp3 de TDV.
 *   
 */
public class DockerLogin {

	private WebDriver driver;

	@BeforeClass
	public void launchBrowser() {
		System.setProperty("webdriver.gecko.driver", "chromedriver.exe");
		this.driver = new ChromeDriver();
		//this.driver.manage().window().fullscreen();
	}

	@Test(priority = 1)
	public void loadPage() {
		driver.navigate().to("https://www.docker.com");
		System.out.println(driver.getTitle());
		//Verificar que haya ingresado en la página correcta
		assertEquals(driver.getTitle(), "Docker: Accelerated, Containerized Application Development");
	}
	
	@Test(priority = 2)
	public void login() {
		WebDriverWait waitLoginBtn = new WebDriverWait(driver, 8000);
		WebElement loginBtn = (WebElement) waitLoginBtn.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div/header/div/div/nav/ul/div/ul/li/a")));
		loginBtn.click();
		
		//Carga usuario y da continue
		WebDriverWait waitUserName = new WebDriverWait(driver, 8000);
		WebElement username = (WebElement) waitUserName.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
		username.sendKeys("tdv2022");
		
		WebDriverWait waitContinueBtn = new WebDriverWait(driver, 8000);
		WebElement continueBtn = (WebElement) waitContinueBtn.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/main/section/div/div/div/form/div[2]/button")));
		continueBtn.click();
		
		//Carga pass y da continue
		WebDriverWait waitUserPass = new WebDriverWait(driver, 8000);
		WebElement password = (WebElement) waitUserPass.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
		password.sendKeys("tdv2022tp");
		
		WebDriverWait waitContinuePBtn = new WebDriverWait(driver, 8000);
		WebElement continuePBtn = (WebElement) waitContinuePBtn.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/main/section/div/div/div/form/div[2]/button")));
		continuePBtn.click();
		
		assertEquals(driver.getTitle(), "Docker Hub");

	}
	
	@Test(priority = 3)
	public void findMySql() {
		WebDriverWait wait = new WebDriverWait(driver, 8000);
		WebElement textBuscar = (WebElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div[1]/div/div[2]/header/form/div/div/input")));
		textBuscar.sendKeys("mysql");		
		textBuscar.sendKeys(Keys.ENTER);
	}
	

	@Test(priority = 4, enabled = false)	
	public void finishTest() {
		if (driver != null) {
			driver.close();
			driver = null;
		}
		System.out.println("Termino satisfactoriamente");
		Assert.assertNull(driver);
	}

}

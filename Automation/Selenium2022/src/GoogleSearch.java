import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleSearch{
	private final WebDriver driver;
	    
	public GoogleSearch() {
		System.setProperty("webdriver.gecko.driver", "chromedriver.exe");
		this.driver = new ChromeDriver();
	}

	public void launchTest() {
		driver.navigate().to("https://www.google.com.ar");
		String titulo = driver.getTitle();	
		System.out.println("Entró en " + titulo);
		
		//Esperamos a que cargue la barra de busqueda
		WebDriverWait wait = new WebDriverWait(driver, 4000);		
		WebElement element = (WebElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("q")));
		
		//Escribimos "Los simpson"
		element.sendKeys("Los simpson");
		
		//Por ultimo hacemos click en "buscar"
		element = (WebElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("btnK")));
		element.click(); 
	}
		
	public void closeDriver() {
		if(driver!=null) {
			driver.close();
			System.out.println("Termino satisfactoriamente");
		}
	}
}










































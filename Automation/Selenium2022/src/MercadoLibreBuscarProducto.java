import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MercadoLibreBuscarProducto {
	private final WebDriver driver;

	public MercadoLibreBuscarProducto(WebDriver driver) {
		this.driver = driver;
	}

	public void search(String busqueda) {
		WebDriverWait wait = new WebDriverWait(driver, 4000);
		WebElement searchbar = (WebElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("nav-search-input")));
		searchbar.clear();
		searchbar.sendKeys(busqueda);
		searchbar.submit();
	}
	
	public void scrollear(String textoABuscar) {
		//Scroleamos, para ello es necesario ejecutar funcionalidad Javascript
		JavascriptExecutor js = (JavascriptExecutor)driver;
		boolean findElement=false;
		while (findElement == false) {
			js.executeScript("window.scrollBy(0,350)", ""); //scrolleamos
			try {
				WebDriverWait wait = new WebDriverWait(driver, 8000);
				WebElement element = (WebElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText(textoABuscar)));
				findElement = true;
				element.click();
			}
			catch(Exception e){
				findElement = false;
			}
		}
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void sacarCookies() {
		//TODO:
	}	
}

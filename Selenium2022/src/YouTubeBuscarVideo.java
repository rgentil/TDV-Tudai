import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class YouTubeBuscarVideo {
	private final WebDriver driver;
	
	public YouTubeBuscarVideo(WebDriver driver) {
		this.driver = driver;
	}
	
	public void searchAndPlay(String video) {
		
		WebDriverWait wait = new WebDriverWait(driver, 7000);
		WebElement searchBar = (WebElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("search_query")));
		searchBar.sendKeys(video);
		searchBar.submit();
		
		WebElement firstVideo = (WebElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Automatización de Pruebas con Selenium WebDriver + Java | Tutorial paso a paso")));
		
		Actions action = new Actions(driver);
		action.doubleClick(firstVideo).perform();
	}
}

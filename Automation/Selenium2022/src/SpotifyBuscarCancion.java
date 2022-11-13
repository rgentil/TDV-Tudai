import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SpotifyBuscarCancion {
	private final WebDriver driver;
	
	public SpotifyBuscarCancion(WebDriver driver) {
		this.driver = driver;
	}
	
	public void searchAndPlay(String song) {
		WebDriverWait wait = new WebDriverWait(driver, 4000);
		
		WebElement searchButton = (WebElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"main\"]/div/div[2]/nav/div[1]/ul/li[2]/a")));
		searchButton.click();
		
		WebElement searchBar = (WebElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"main\"]/div/div[2]/div[1]/header/div[3]/div/div/form/input")));
		searchBar.sendKeys(song);
		
		WebElement firstSong = (WebElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"searchPage\"]/div/div/section[2]/div[2]/div/div/div/div[2]/div[1]/div/div[1]/div[1]/img")));
		
		Actions action = new Actions(driver);//Para movimientos del mouse mas complejos! drag and drop
		action.doubleClick(firstSong).perform();
	}
}



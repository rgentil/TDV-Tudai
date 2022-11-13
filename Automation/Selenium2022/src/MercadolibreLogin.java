import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MercadolibreLogin {
	private final WebDriver driver;
	
	public MercadolibreLogin(WebDriver driver) {
		this.driver = driver;
	}
	
	public void login(String username, String password) {
		WebDriverWait wait = new WebDriverWait(driver, 4000);
		WebElement userButton = (WebElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user_id")));
		userButton.sendKeys(username);
		userButton.submit();
		WebElement passwordButton = (WebElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
		passwordButton.sendKeys(password);
		passwordButton.submit();
	}
}

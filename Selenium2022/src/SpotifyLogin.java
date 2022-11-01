import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SpotifyLogin {
	private final WebDriver driver;
	
	//@FindBy(linkText="Iniciar sesión") WebElement loginButton; //Otra alternativa!
	
	public SpotifyLogin(WebDriver driver) {
		this.driver = driver;
	}
	
	public void login(String user, String pass) {
		//loginButton.click();
		WebDriverWait wait1 = new WebDriverWait(driver, 8000);
		WebElement loginBtn = (WebElement) wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/div/div[2]/div[1]/header/div[5]/button[2]/span")));
		loginBtn.click();
		
		WebDriverWait wait = new WebDriverWait(driver, 4000);
		WebElement username = (WebElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login-username")));
		username.sendKeys(user);
		
		WebElement password = (WebElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login-password")));
		password.sendKeys(pass);
		
		WebElement button = (WebElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login-button")));
		button.click();
	}
}

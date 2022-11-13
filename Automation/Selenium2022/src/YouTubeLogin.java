import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class YouTubeLogin {
	private final WebDriver driver;

	public YouTubeLogin(WebDriver driver) {
		this.driver = driver;
	}

	public void login(String user, String pass) {
		WebDriverWait waitLargo = new WebDriverWait(driver, 8000);
		WebElement acceder = (WebElement) waitLargo.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Acceder")));
		acceder.click();

		WebDriverWait wait = new WebDriverWait(driver, 4000);
		WebElement username = (WebElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"identifierId\"]")));
		username.sendKeys(user);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"identifierNext\"]/div/button/span"))).click();

		WebElement password = (WebElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"password\"]/div[1]/div/div[1]/input")));
		password.sendKeys(pass);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"passwordNext\"]/div/button/span"))).click();
	}
}

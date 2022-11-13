import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SantanderRioLogin {
	private final WebDriver driver;
	
	public SantanderRioLogin(WebDriver driver) {
		this.driver = driver;
	}
	
	public void login(String DNI, String password, String username) {
		WebDriverWait wait = new WebDriverWait(driver, 4000);
		
		WebElement dni = (WebElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"input_0\"]")));
		dni.sendKeys(DNI);
		dni.submit();
		
		WebElement pass = (WebElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"input_1\"]")));
		pass.sendKeys(password);
		pass.submit();

		WebElement user = (WebElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"input_2\"]")));
		user.sendKeys(username);
		user.submit();		

		WebElement IngresarButton = (WebElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"form\"]/button")));
		IngresarButton.click();

	}
}

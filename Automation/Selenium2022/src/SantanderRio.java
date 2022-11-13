import static org.testng.Assert.assertEquals;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class SantanderRio {

	private WebDriver driver;

	@BeforeClass
	public void launchBrowser() {
		System.setProperty("webdriver.gecko.driver", "chromedriver.exe");
		driver = new ChromeDriver();
	}

	@Test (priority=1)
	public void loadPage() {
		driver.navigate().to("https://www2.personas.santander.com.ar/obp-webapp/angular/#!/login");
		System.out.println(driver.getTitle());
		assertEquals(driver.getTitle(), "Online Banking Santander | Inicio de Sesión");
	}

	@Test (priority=2)
	public void login() {
		SantanderRioLogin logInBanco = PageFactory.initElements(driver, SantanderRioLogin.class);
		logInBanco.login("22222222", "","");

	}

	@Test (priority=3)
	public void searchProduct() {
	}
	
	@Test (priority=4)
	public void finishTest() {
		if(driver!=null) {
			driver.close();
			driver = null;
		}
		System.out.println("Termino satisfactoriamente");
		Assert.assertNull(driver);
	}
}

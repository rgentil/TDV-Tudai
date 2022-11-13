import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class YouTube {
	private WebDriver driver;

	@BeforeClass
	public void launchBrowser() {
		System.setProperty("webdriver.gecko.driver", "chromedriver.exe");
		driver = new ChromeDriver();
	}

	@Test (priority=1)
	public void loadPage() {
		driver.navigate().to("https://youtube.com");
		System.out.println(driver.getTitle());
		Assert.assertEquals(driver.getTitle(), "YouTube");
		/// para simular un escape
		//Actions action = new Actions (driver);
		//action.sendKeys(Keys.ESCAPE).build().perform();
	}

	@Test (priority=2)
	public void login() {
		YouTubeLogin logInYouTube = PageFactory.initElements(driver, YouTubeLogin.class);
		logInYouTube.login("UUUU", "PPPP");
	}

	@Test (priority=3)
	public void searchVideo() {
		YouTubeBuscarVideo searchVideo = PageFactory.initElements(driver, YouTubeBuscarVideo.class);
		searchVideo.searchAndPlay("selenium tester");
	}

	@Test (priority=4)
	public void finishTest() {
		/*if(driver!=null) {
			driver.close();
			driver = null;
		}*/
		System.out.println("Termino satisfactoriamente");
		//Assert.assertNull(driver);
	}

}

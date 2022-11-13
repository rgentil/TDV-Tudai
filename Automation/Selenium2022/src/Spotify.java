import static org.testng.Assert.assertEquals;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Spotify {
	private WebDriver driver;

	@BeforeClass
	public void launchBrowser() {
		System.setProperty("webdriver.gecko.driver", "chromedriver.exe");
		driver = new ChromeDriver();
	}

	@Test (priority=1)
	public void loadPage() {
		driver.navigate().to("https://open.spotify.com");
		System.out.println(driver.getTitle());
		assertEquals(driver.getTitle(),"Spotify – Reproductor web");
	}

	@Test (priority=2)
	public void login() {
		SpotifyLogin logInSpotify = PageFactory.initElements(driver, SpotifyLogin.class);
		logInSpotify.login("ek05gnv6k8v77xyfusx4tleq4", "nuevapassword");
	}

	@Test (priority=3)
	public void searchSong() {
		SpotifyBuscarCancion searchSong = PageFactory.initElements(driver, SpotifyBuscarCancion.class);
		searchSong.searchAndPlay("learning to fly");
	}

	@Test (priority=4)
	public void closeDriver() {
		/*if(driver!=null)
			driver.close();*/
		System.out.println("Termino satisfactoriamente");
	}
}

package test.java.mercadolibre;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

public class MercadoLibre {

	private WebDriver driver;

	@BeforeClass
	public void launchBrowser() {
		System.setProperty("webdriver.gecko.driver", "chromedriver.exe");
		this.driver = new ChromeDriver();
	}

	@Test(priority = 1)
	public void loadPage() {
		driver.navigate().to("https://mercadolibre.com.ar");
		System.out.println(driver.getTitle());
		Assert.assertEquals(driver.getTitle(), "💣 Cyber Monday 2022 | Mercado Libre Argentina");
	}

	@Test(priority = 2)
	public void login() {
		// TODO:
	}
	
	@Test(priority = 3)
	public void searchProduct() {
		MercadoLibreBuscarProducto mercadolibrebuscar = PageFactory.initElements(driver,
				MercadoLibreBuscarProducto.class);
		mercadolibrebuscar.search("GPU");
		String textoAbuscar = "Placa de video Nvidia MSI Ventus GeForce RTX 30 Series RTX 3080 Ti GEFORCE RTX 3080 Ti VENTUS 3X 12G OC OC Edition 12GB";
		mercadolibrebuscar.sacarCookies();
		mercadolibrebuscar.scrollear(textoAbuscar);
	}

	@Test(priority = 4)
	public void finishTest() {
		if (driver != null) {
			driver.close();
			driver = null;
		}
		System.out.println("Termino satisfactoriamente");
		Assert.assertNull(driver);
	}
}

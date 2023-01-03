package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

public class common {

	public static WebDriver driver;
	public static FileInputStream fis;

	public static Properties or;
	public static Properties config;

	public static String ProjectPath;

	@BeforeSuite
	public static void initial() {
		try {
			ProjectPath = System.getProperty("user.dir");

			// projectpath= C:\Users\Partho\eclipse-workspace\finalSqa

			fis = new FileInputStream(ProjectPath + "\\src\\test\\resources\\properties\\OR.properties");
			or = new Properties();
			or.load(fis);
			fis = new FileInputStream(ProjectPath + "\\src\\test\\resources\\properties\\config.properties");
			config = new Properties();
			config.load(fis);

			if (config.getProperty("BROWSER").equals("chrome")) {
				System.setProperty("webdriver.chrome.driver", ProjectPath +"\\src\\test\\resources\\binaries\\chromedriver.exe");

				driver = new ChromeDriver();
			}
			System.out.println("initial");

		} catch (IOException ex) {

		} /*
			 * catch(FileNotFoundException ex) {
			 * 
			 * }
			 */

		// System.setProperty("webdriver.gecko.driver", "binaries\\geckodriver.exe");
		// WebDriver driver;

		// FirefoxDriver driver=new FirefoxDriver();

	}

	@BeforeClass
	public static void login() {
		System.out.println("login");
		// initial();
		// WebDriver driver = new ChromeDriver();
		driver.get(config.getProperty("BASE_URL"));
//		driver.findElement(By.name("username")).sendKeys("ABC");
	 driver.findElement(By.name("username")).sendKeys("ABC");
		// elementClick(By.cssSelector("input[class='form-control']"));
		//SendKeys(By.cssSelector(or.getProperty("USERNAMECSS")), "ABC");
  	driver.findElement(By.name("password")).sendKeys("666666");
		//driver.findElement(By.name("password")).sendKeys("666666");
//		// login
		// driver.findElement(By.name("login")).click();
		elementClick(By.xpath(or.getProperty("LOGIN")));

	}

	public static void elementClick(By locator) {
		driver.findElement(locator).click();
	}

	public static boolean elementDisplayed(By locator) {
		return driver.findElement(locator).isDisplayed();
	}

	public static boolean elementEnabled(By locator) {
		return driver.findElement(locator).isEnabled();
	}

	public static void SendKeys(By locator, String value) {
		driver.findElement(locator).sendKeys(value);
	}

	public static void elementClickCss(By locator) {
		driver.findElement(locator).click();
	}
}

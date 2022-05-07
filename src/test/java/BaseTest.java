import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {

    private String pathtoChromeDriver = "C:\\Users\\mario\\Desktop\\Chromedriver\\chromedriver.exe";

    public WebDriver webDriver = getChromeWebDriver();

    private WebDriver getChromeWebDriver() {
        System.setProperty("webdriver.chrome.driver", pathtoChromeDriver);
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--incognito");
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
        chromeOptions.merge(desiredCapabilities);
        return new ChromeDriver(chromeOptions);
    }
    @BeforeTest
    public void setUp() {
        webDriver.get("https://demoqa.com");
        webDriver.manage().window().maximize();
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("window.scrollBy(0,500)");
    }

    @AfterTest
    public void closeBrowser() {
        webDriver.quit();
    }
}

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BaseTest {
    WebDriver driver;

    @BeforeEach
    public void setup(){

        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions options = new FirefoxOptions();

        driver = new FirefoxDriver(options);
        driver.get("https://www.saucedemo.com/v1/");
        driver.manage().window().maximize();
    }

    @AfterEach
    public void cleanUp(){
        driver.quit();
    }
}

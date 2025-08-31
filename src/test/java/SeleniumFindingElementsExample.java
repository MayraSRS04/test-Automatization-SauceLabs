import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;

public class SeleniumFindingElementsExample {

    @Test
    public void searchByIdExample() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        WebDriver driver = new ChromeDriver(options);

        driver.get("https://www.saucedemo.com/v1/");

        WebElement userNameTextBox = driver.findElement(By.id("user-name"));
        userNameTextBox.sendKeys("standard_user");

        WebElement passwordTextBox = driver.findElement(By.id("password"));
        passwordTextBox.sendKeys("secret_sauce");

        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();

        Thread.sleep(5000);
        driver.quit();
    }

    @Test
    public void searchByClassName() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        WebDriver driver = new ChromeDriver(options);

        driver.get("https://www.saucedemo.com/v1/");

        WebElement userNameTextBox = driver.findElement(By.id("user-name"));
        userNameTextBox.sendKeys("standard_user");

        WebElement passwordTextBox = driver.findElement(By.id("password"));
        passwordTextBox.sendKeys("secret_sauce");

        WebElement loginButton = driver.findElement(By.className("btn_action"));
        loginButton.click();

        Thread.sleep(5000);
        driver.quit();

    }

    @Test
    public void searchByName() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        WebDriver driver = new ChromeDriver(options);

        driver.get("https://www.saucedemo.com/v1/");

        WebElement userNameTextBox = driver.findElement(By.name("user-name"));
        userNameTextBox.sendKeys("standard_user");

        WebElement passwordTextBox = driver.findElement(By.name("password"));
        passwordTextBox.sendKeys("secret_sauce");

        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();

        Thread.sleep(5000);
        driver.quit();
    }

    @Test
    public void searchByLinkText() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        WebDriver driver = new ChromeDriver(options);

        driver.get("https://selectorshub.com/xpath-practice-page/");

        WebElement considerSmallDonationLink = driver.findElement(By.linkText("Consider a small Donation and support this page."));
        considerSmallDonationLink.click();

        Thread.sleep(5000);
        driver.quit();

    }

    @Test
    public void searchByTagName() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        WebDriver driver = new ChromeDriver(options);

        driver.get("https://www.saucedemo.com/v1/");

        List<WebElement> elements = driver.findElements(By.tagName("input"));
        System.out.println(elements.size());


        elements.get(0).sendKeys("standard_user");
        elements.get(1).sendKeys("secret_sauce");
        elements.get(2).click();
        Thread.sleep(5000);
        driver.quit();
    }

    @Test
    public void searchByCss() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        WebDriver driver = new ChromeDriver(options);

        driver.get("https://www.saucedemo.com/v1/");

        WebElement userNameTextBox = driver.findElement(By.cssSelector("input#user-name"));
        userNameTextBox.sendKeys("standard_user");

        WebElement passwordTextBox = driver.findElement(By.cssSelector("input[placeholder='Password']"));
        passwordTextBox.sendKeys("secret_sauce");

        WebElement loginButton = driver.findElement(By.cssSelector("input.btn_action"));
        loginButton.click();

        Thread.sleep(5000);
        driver.quit();
    }

    @Test
    public void searchByCssFromSelectorsHubPlugin() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        WebDriver driver = new ChromeDriver(options);

        driver.get("https://www.saucedemo.com/v1/");

        WebElement userNameTextBox = driver.findElement(By.cssSelector("#user-name"));
        userNameTextBox.sendKeys("standard_user");

        WebElement passwordTextBox = driver.findElement(By.cssSelector("#password"));
        passwordTextBox.sendKeys("secret_sauce");

        WebElement loginButton = driver.findElement(By.cssSelector("#login-button"));
        loginButton.click();

        Thread.sleep(5000);
        driver.quit();
    }

    @Test
    public void searchByXpath() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        WebDriver driver = new ChromeDriver(options);

        driver.get("https://www.saucedemo.com/v1/");

        WebElement userNameTextBox = driver.findElement(By.xpath("//input[@name='user-name']"));
        userNameTextBox.sendKeys("standard_user");

        WebElement passwordTextBox = driver.findElement(By.xpath("//input[@placeholder='Password']"));
        passwordTextBox.sendKeys("secret_sauce");

        WebElement loginButton = driver.findElement(By.xpath("//input[@value='LOGIN']"));
        loginButton.click();

        Thread.sleep(5000);

        driver.quit();
    }

    @Test
    public void searchByXpathFromSelectorsHubPlugin() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        WebDriver driver = new ChromeDriver(options);

        driver.get("https://www.saucedemo.com/v1/");

        WebElement userNameTextBox = driver.findElement(By.xpath("//input[@id='user-name']"));
        userNameTextBox.sendKeys("standard_user");

        WebElement passwordTextBox = driver.findElement(By.xpath("//input[@id='password']"));
        passwordTextBox.sendKeys("secret_sauce");

        WebElement loginButton = driver.findElement(By.xpath("//input[@id='login-button']"));
        loginButton.click();

        Thread.sleep(5000);

        driver.quit();
    }
}

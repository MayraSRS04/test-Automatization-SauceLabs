import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginTests extends BaseTest {

    @Test
    public void loginWithValidCredentialsTest(){
        WebElement userNameTextBox = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.id("user-name")));
        userNameTextBox.sendKeys("standard_user");

        WebElement passwordTextBox = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.name("password")));
        passwordTextBox.sendKeys("secret_sauce");

        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();

        WebElement appLogo = driver.findElement(By.className("app_logo"));
        //Verification
        // Verifies that the app logo in the dashboard is displayed
        Assertions.assertTrue(appLogo.isDisplayed());
    }

    @Test
    public void loginWithInvalidCredentials(){
        WebElement userNameTextBox = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.id("user-name")));
        userNameTextBox.sendKeys("wrong_user");

        WebElement passwordTextBox = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.name("password")));
        passwordTextBox.sendKeys("wrong_password");

        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();

        //Verification
        // h3[data-test="error"]
        WebElement errorMessage = driver.findElement(By.cssSelector("h3[data-test='error']"));
        String errorText = errorMessage.getText();
        // Epic sadface: Username and password do not match any user in this service

        Assertions.assertTrue(errorMessage.isDisplayed());
        Assertions.assertEquals("Epic sadface: Username and password do not match any user in this service", errorText);
    }
}

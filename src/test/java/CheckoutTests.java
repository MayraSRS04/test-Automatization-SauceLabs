import com.google.common.collect.Ordering;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class CheckoutTests extends BaseTest {
    //EXAMEN SEGUNDO PARCIAL
    /// ///////////////////////////////////////////////////
    //2.Verificar que el boton checkout funcione cuando hay productos en el carrito
    @Test
    public void buttonCheckoutTest() throws InterruptedException {
        WebElement userNameTextBox = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.id("user-name")));
        userNameTextBox.sendKeys("standard_user");

        WebElement passwordTextBox = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.name("password")));
        passwordTextBox.sendKeys("secret_sauce");

        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();

        addProductToCart("Sauce Labs Fleece Jacket");

        WebElement cartIcon = driver.findElement(By.cssSelector("a[class='shopping_cart_link fa-layers fa-fw'] svg path"));
        cartIcon.click();

        WebElement checkoutButton = driver.findElement(By.cssSelector(".btn_action.checkout_button"));
        checkoutButton.click();

        //Thread.sleep(5000);

        //Verificamos Checkout: Your Information
        WebElement informationCheckout = driver.findElement(By.cssSelector(".subheader"));
        String errorText = informationCheckout.getText();
        Assertions.assertTrue(informationCheckout.isDisplayed());
        Assertions.assertEquals("Checkout: Your Information", errorText);
    }

    public void addProductToCart(String productName){
        WebElement product = driver.findElement(By.xpath("//div[text()='"+productName+"']"));
        product.click();

        WebElement addToCartButton = driver.findElement(By.cssSelector(".btn_primary.btn_inventory"));
        addToCartButton.click();
    }

    //3. Verificamos el funcionamiento del checkout con todos los espacios completados correctamente
    @Test
    public void CheckoutCorrectTest() throws InterruptedException {
        WebElement userNameTextBox = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.id("user-name")));
        userNameTextBox.sendKeys("standard_user");

        WebElement passwordTextBox = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.name("password")));
        passwordTextBox.sendKeys("secret_sauce");

        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();

        addProductToCart("Sauce Labs Fleece Jacket");

        WebElement cartIcon = driver.findElement(By.cssSelector("a[class='shopping_cart_link fa-layers fa-fw'] svg path"));
        cartIcon.click();

        WebElement checkoutButton = driver.findElement(By.cssSelector(".btn_action.checkout_button"));
        checkoutButton.click();

        WebElement firstNameTextBox = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#first-name")));
        firstNameTextBox.sendKeys("Mayra");

        WebElement lastNameTextBox = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#last-name")));
        lastNameTextBox.sendKeys("Rosas");

        WebElement postalCodeTextBox = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#postal-code")));
        postalCodeTextBox.sendKeys("1020");

        WebElement continueButton = driver.findElement(By.cssSelector("input[value='CONTINUE']"));
        continueButton.click();

        //Thread.sleep(5000);

        WebElement informationCheckout = driver.findElement(By.cssSelector(".subheader"));
        String errorText = informationCheckout.getText();
        Assertions.assertTrue(informationCheckout.isDisplayed());
        Assertions.assertEquals("Checkout: Overview", errorText);

    }

    //4.Verificar que un mensaje de error es mostrado cuando el espacio first name esta vacio
    @Test
    public void FirstNameEmptyTest() throws InterruptedException {
        WebElement userNameTextBox = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.id("user-name")));
        userNameTextBox.sendKeys("standard_user");

        WebElement passwordTextBox = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.name("password")));
        passwordTextBox.sendKeys("secret_sauce");

        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();

        addProductToCart("Sauce Labs Fleece Jacket");

        WebElement cartIcon = driver.findElement(By.cssSelector("a[class='shopping_cart_link fa-layers fa-fw'] svg path"));
        cartIcon.click();

        WebElement checkoutButton = driver.findElement(By.cssSelector(".btn_action.checkout_button"));
        checkoutButton.click();

        WebElement lastNameTextBox = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#last-name")));
        lastNameTextBox.sendKeys("Rosas");

        WebElement postalCodeTextBox = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#postal-code")));
        postalCodeTextBox.sendKeys("1020");

        WebElement continueButton = driver.findElement(By.cssSelector("input[value='CONTINUE']"));
        continueButton.click();

        //Thread.sleep(5000);

        WebElement firstNameError = driver.findElement(By.cssSelector("h3[data-test='error']"));
        String errorText = firstNameError.getText();
        Assertions.assertTrue(firstNameError.isDisplayed());
        Assertions.assertEquals("Error: First Name is required", errorText);

    }

    //5. Verificar que un mensaje de error es mostrado cuando el espacio Zip/Postal Code esta vacio
    @Test
    public void PostalCodeEmptyTest() throws InterruptedException {
        WebElement userNameTextBox = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.id("user-name")));
        userNameTextBox.sendKeys("standard_user");

        WebElement passwordTextBox = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.name("password")));
        passwordTextBox.sendKeys("secret_sauce");

        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();

        addProductToCart("Sauce Labs Fleece Jacket");

        WebElement cartIcon = driver.findElement(By.cssSelector("a[class='shopping_cart_link fa-layers fa-fw'] svg path"));
        cartIcon.click();

        WebElement checkoutButton = driver.findElement(By.cssSelector(".btn_action.checkout_button"));
        checkoutButton.click();

        WebElement firstNameTextBox = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#first-name")));
        firstNameTextBox.sendKeys("Mayra");

        WebElement lastNameTextBox = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#last-name")));
        lastNameTextBox.sendKeys("Rosas");

        WebElement continueButton = driver.findElement(By.cssSelector("input[value='CONTINUE']"));
        continueButton.click();

        //Thread.sleep(5000);

        WebElement informationCheckout = driver.findElement(By.cssSelector("h3[data-test='error']"));
        String errorText = informationCheckout.getText();
        Assertions.assertTrue(informationCheckout.isDisplayed());
        Assertions.assertEquals("Error: Postal Code is required", errorText);

    }
}


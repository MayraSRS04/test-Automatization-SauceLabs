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

public class HomePageTests extends BaseTest {

    @Test
    public void orderingFilterFromZToATest() throws InterruptedException {
        WebElement userNameTextBox = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.id("user-name")));
        userNameTextBox.sendKeys("standard_user");

        WebElement passwordTextBox = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.name("password")));
        passwordTextBox.sendKeys("secret_sauce");

        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();

        WebElement sortComboBox = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.className("product_sort_container")));

        Select selectObject = new Select(sortComboBox);
        selectObject.selectByVisibleText("Name (Z to A)");

        //Verification
        List<WebElement> productNames = driver.findElements(By.className("inventory_item_name"));

        List<String> actualProductsOrder = new ArrayList<>();
        //['nombre 1', 'nombre2']
        for(WebElement element: productNames){
            actualProductsOrder.add(element.getText());
        }

        boolean isSorted = Ordering.natural().reverse().isOrdered(actualProductsOrder);
        Assertions.assertTrue(isSorted);
    }

    @Test
    public void addToCartTest() throws InterruptedException {
        WebElement userNameTextBox = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.id("user-name")));
        userNameTextBox.sendKeys("standard_user");

        WebElement passwordTextBox = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.name("password")));
        passwordTextBox.sendKeys("secret_sauce");

        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();

        addProductToCart("Sauce Labs Fleece Jacket");
        //Thread.sleep(5000);

        WebElement cartIconNumber = driver.findElement(By.cssSelector(".fa-layers-counter.shopping_cart_badge"));

        String actualCartNumber = cartIconNumber.getText();
        Assertions.assertEquals("1", actualCartNumber);

    }

    public void addProductToCart(String productName){
        WebElement product = driver.findElement(By.xpath("//div[text()='"+productName+"']"));
        product.click();

        WebElement addToCartButton = driver.findElement(By.cssSelector(".btn_primary.btn_inventory"));
        addToCartButton.click();
    }

    @Test
    public void orderingFilterFromHighPriceToLow() throws InterruptedException {
        WebElement userNameTextBox = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.id("user-name")));
        userNameTextBox.sendKeys("standard_user");

        WebElement passwordTextBox = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.name("password")));
        passwordTextBox.sendKeys("secret_sauce");

        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();

        WebElement sortComboBox = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.className("product_sort_container")));

        Select selectObject = new Select(sortComboBox);
        selectObject.selectByVisibleText("Price (high to low)");
        //Thread.sleep(5000);

        List<WebElement> productPrices = driver.findElements(By.className("inventory_item_price"));

        List<Double> actualProductPriceOrder = new ArrayList<>();

        for(WebElement element: productPrices){
            actualProductPriceOrder.add(Double.parseDouble(element.getText().replace("$","")));
            System.out.println(Double.parseDouble(element.getText().replace("$","")));
        }
        boolean isSorted = Ordering.natural().reverse().isOrdered(actualProductPriceOrder);
        Assertions.assertTrue(isSorted);
    }
    //EXAMEN SEGUNDO PARCIAL
    /// ///////////////////////////////////////////////////
    //1.Verificar que el elemento fue removido del carrito de manera exitosa
    @Test
    public void RemoveToCartTest() throws InterruptedException {
        WebElement userNameTextBox = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.id("user-name")));
        userNameTextBox.sendKeys("standard_user");

        WebElement passwordTextBox = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.name("password")));
        passwordTextBox.sendKeys("secret_sauce");

        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();

        addProductToCart("Sauce Labs Fleece Jacket");

        WebElement removeToCartButton = driver.findElement(By.cssSelector(".btn_secondary.btn_inventory"));
        removeToCartButton.click();

        //Thread.sleep(5000);

        // Verificar que el badge del carrito NO existe
        List<WebElement> cartBadges = driver.findElements(By.cssSelector(".fa-layers-counter.shopping_cart_badge"));
        Assertions.assertTrue(cartBadges.isEmpty(), "El badge del carrito no debería estar presente inicialmente");
    }

}

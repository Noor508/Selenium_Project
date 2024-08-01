package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Registration {

    public static void main(String[] args) {
        // Set the path of the ChromeDriver executable
        //System.setProperty("webdriver.chrome.driver", "C:/tools/chromedriver/chromedriver.exe"); // Update the path to your chromedriver

        // Initialize the ChromeDriver
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            // Open the login page
            driver.get("https://www.saucedemo.com/");
            Thread.sleep(5000); // Wait for 5 seconds

            // Log in
            try {
                driver.findElement(By.id("user-name")).sendKeys("standard_user");
                driver.findElement(By.id("password")).sendKeys("secret_sauce");
                driver.findElement(By.id("login-button")).click();
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("inventory_container")));
                System.out.println("Login successful. Test case 'Login' passed.");
            } catch (Exception e) {
                System.out.println("Test case 'Login' failed.");
                e.printStackTrace();
                return; // Stop further execution if login fails
            }
            Thread.sleep(5000); // Wait for 5 seconds

            // Add Sauce Labs Backpack to the cart
            try {
                driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
                WebElement cartBadge = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("shopping_cart_badge")));
                System.out.println("Product added to cart successfully. Test case 'Add to Cart' passed.");
            } catch (Exception e) {
                System.out.println("Test case 'Add to Cart' failed.");
                e.printStackTrace();
                return;
            }
            Thread.sleep(5000); // Wait for 5 seconds

            // Open the cart
            try {
                driver.findElement(By.className("shopping_cart_link")).click();
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("cart_list")));
                System.out.println("Cart opened successfully. Test case 'Open Cart' passed.");
            } catch (Exception e) {
                System.out.println("Test case 'Open Cart' failed.");
                e.printStackTrace();
                return;
            }
            Thread.sleep(5000); // Wait for 5 seconds

            // Proceed to checkout
            try {
                driver.findElement(By.id("checkout")).click();
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("checkout_info_container")));
                System.out.println("Checkout page opened successfully. Test case 'Proceed to Checkout' passed.");
            } catch (Exception e) {
                System.out.println("Test case 'Proceed to Checkout' failed.");
                e.printStackTrace();
                return;
            }
            Thread.sleep(5000); // Wait for 5 seconds

            // Enter checkout information
            try {
                driver.findElement(By.id("first-name")).sendKeys("John");
                driver.findElement(By.id("last-name")).sendKeys("Doe");
                driver.findElement(By.id("postal-code")).sendKeys("12345");
                driver.findElement(By.id("continue")).click();
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("checkout_summary_container")));
                System.out.println("Checkout information entered successfully. Test case 'Enter Checkout Information' passed.");
            } catch (Exception e) {
                System.out.println("Test case 'Enter Checkout Information' failed.");
                e.printStackTrace();
                return;
            }
            Thread.sleep(5000); // Wait for 5 seconds

            // Finish the checkout process
            try {
                driver.findElement(By.id("finish")).click();
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("complete-header")));
                System.out.println("Checkout process completed successfully. Test case 'Finish Checkout' passed.");
            } catch (Exception e) {
                System.out.println("Test case 'Finish Checkout' failed.");
                e.printStackTrace();
                return;
            }
            Thread.sleep(5000); // Wait for 5 seconds

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}

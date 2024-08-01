package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PerformanceTesting {

    public static void main(String[] args) {
        // Set the path of the ChromeDriver executable
       // System.setProperty("webdriver.chrome.driver", "path/to/chromedriver"); // Update the path to your chromedriver

        // Initialize the ChromeDriver
        WebDriver driver = new ChromeDriver();

        try {
            // Measure the page load time
            long start = System.currentTimeMillis();

            // Open the Daraz website
            driver.get("https://www.daraz.pk/");

            // Wait for the page to fully load
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            wait.until(new ExpectedCondition<Boolean>() {
                @Override
                public Boolean apply(WebDriver wd) {
                    return ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete");
                }
            });

            long finish = System.currentTimeMillis();
            long totalTime = finish - start;

            System.out.println("Page load time: " + totalTime + " milliseconds");

            // Perform additional actions if necessary
            WebElement searchBox = driver.findElement(By.name("q"));
            searchBox.sendKeys("Laptop");
            searchBox.submit();

            // Measure the time taken for search results to load
            start = System.currentTimeMillis();
            wait.until(new ExpectedCondition<Boolean>() {
                @Override
                public Boolean apply(WebDriver wd) {
                    return ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete");
                }
            });
            finish = System.currentTimeMillis();
            totalTime = finish - start;

            System.out.println("Search results load time: " + totalTime + " milliseconds");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}

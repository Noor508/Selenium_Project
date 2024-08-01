package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstTestCase {

    public static void main(String[] args) {
        try {
            // Set the path of the ChromeDriver executable
          //  System.setProperty("webdriver.chrome.driver", "path/to/chromedriver"); // Update the path to your chromedriver

            // Initialize the ChromeDriver
            WebDriver driver = new ChromeDriver();

         
            driver.get("https://www.calculator.net/");

            // Print the title of the page
            String pageTitle = driver.getTitle();
            System.out.println("Page Title is: " + pageTitle);

            // Verify the title of the page
            if (pageTitle.contains("Calculator")) {
                System.out.println("Calculator opened successfully.");
            } else {
                System.out.println("Failed to open Calculator.");
            }

            // Wait for 1 second to observe the page load
            Thread.sleep(1000);

            // Locate and click the button for number 5
            WebElement button5 = driver.findElement(By.xpath("//span[text()='5']"));
            button5.click();

            // Wait for 1 second to observe the click
            Thread.sleep(1000);

            // Locate and click the button for '+'
            WebElement addButton = driver.findElement(By.xpath("//span[text()='+']"));
            addButton.click();

            // Wait for 1 second to observe the click
            Thread.sleep(1000);

            // Locate and click the button for number 6
            WebElement button6 = driver.findElement(By.xpath("//span[text()='6']"));
            button6.click();

            // Wait for 1 second to observe the click
            Thread.sleep(1000);

            // Locate and click the button for '='
            WebElement equalButton = driver.findElement(By.xpath("//span[text()='=']"));
            equalButton.click();

            // Wait for 1 second to observe the result
            Thread.sleep(1000);

            // Locate the result display element
            WebElement result = driver.findElement(By.id("sciOutPut"));

            // Get the text from the result element
            String resultText = result.getText().trim();

            // Verify the result is 11
            if (resultText.equals("11")) {
                System.out.println("Test passed: The result of 5 + 6 is 11.");
            } else {
                System.out.println("Test failed: The result of 5 + 6 is not 11, it is " + resultText);
            }

            // Close the browser
            driver.quit();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

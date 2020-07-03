import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FirstTest {
    @Test
    public void demoTest(){
        System.setProperty("webdriver.chrome.driver","C:/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1295, 730));
        driver.navigate().to("https://google.pl");

        //declare element search field
        WebElement searchField = driver.findElement(By.cssSelector("[title='Szukaj']"));

        //define string to search with
        String searchEntry = "wszechświaty równoległe";

        //define page title, to be used in wait.until
        String title = "Wieloświat – Wikipedia, wolna encyklopedia";

        //type value defined in searchEntry into the search field
        searchField.sendKeys(searchEntry);

        //confim value, press seach button
        searchField.submit();

        //find a result on the list which has previously defined title
        driver.findElement(By.xpath(".//*[text()='" + title + "']")).click();


        WebDriverWait wait = new WebDriverWait(driver, 5);

        //wait until title is the same as in variable 'title'
        wait.until(ExpectedConditions.titleIs(title));

        //define entryURL
        String entryURL = "https://pl.wikipedia.org/wiki/Wielo%C5%9Bwiat";

        //compare entryURL with currentURL, if the same then pass it not fail and return message 'URL is not correct'
        Assertions.assertEquals(entryURL, driver.getCurrentUrl(), "URL is not correct.");
        driver.quit();
    }
}

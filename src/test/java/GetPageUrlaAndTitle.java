import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * pobieranie urla i page title
 *
 */

public class GetPageUrlaAndTitle {

    WebDriver driver;

    @BeforeEach
    public void driverSetup() {
        System.setProperty("webdriver.chrome.driver", "C:/webdriver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1295, 730));
    }

    @AfterEach
    public void driverQuit() {
        driver.close();
        driver.quit();
    }

    @Test
    public void getUrlAndCompare(){
        String googleUrl = "https://www.google.com";
        driver.navigate().to("https://google.com");
        Assertions.assertEquals(driver.getCurrentUrl(), googleUrl, "URL nie jest taki sam");

    }

    @Test
    public void getTitleAndCompare(){
        String googleTitle = "Google";
        driver.navigate().to("https://google.com");
        Assertions.assertEquals(driver.getTitle(), googleTitle, "Title nie jest taki sam" );
    }

    @Test
    public void getElementFromPageSource(){

        //we want to verify if tia.png is a part of the page source
        String sourceElement = "tia2.png";
        driver.get("https://google.com");
        Assertions.assertTrue(driver.getPageSource().contains(sourceElement), "source code does not contain element " + sourceElement);

    }
}

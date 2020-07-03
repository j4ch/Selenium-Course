import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationAndClosing {

    WebDriver driver;
    @BeforeEach
    public void driverSetup(){
        System.setProperty("webdriver.chrome.driver", "C:/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1295, 730));
    }

    @AfterEach
    public void driverQuit(){
        //zamyka okno przegladarki - zostawia proces running
        driver.close();
        //zabija wszystkie sesje/procesy
        driver.quit();
    }

    @Test
    public void getMethod(){
           driver.get("https://google.pl");
    }

    @Test
    public void navigateMethod(){
        driver.navigate().to("http://google.pl");
        driver.navigate().to("http://amazon.com");
        driver.navigate().back();
        driver.navigate().refresh();
        driver.navigate().forward();

    }


}

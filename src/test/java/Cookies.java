import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.GregorianCalendar;
import java.util.Set;

/**
 * pobieranie i operacje na cookies'ach
 *
 */

public class GetPageUrlaAndTitle {

    WebDriver driver;

    @BeforeEach
    public void driverSetup() {
        System.setProperty("webdriver.chrome.driver", "C:/webdriver_actual/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1295, 730));
        driver.navigate().to("http://amazon.com");
    }

    @AfterEach
    public void driverQuit() {
        driver.close();
        driver.quit();
    }

    @Test
    public void getCookies() {

        //load all cookies
    Set<Cookie> cookies = driver.manage().getCookies();
    Assertions.assertEquals(7, driver.manage().getCookies().size(), "wrong number of cookies");

        //load specific cookie by its name
    Cookie cookieSessionID = driver.manage().getCookieNamed("session-id");

        //delete cookie
    driver.manage().deleteCookieNamed("session-id");

        //check if the number of cookies is proper after deletion of session-id
    Assertions.assertEquals(6, driver.manage().getCookies().size(), "wrong number of cookies");

        //delete all cookies
     driver.manage().deleteAllCookies();

        //check if current number is 0
     Assertions.assertEquals(0, driver.manage().getCookies().size(), "wrong number of cookies");

        //adding new cookie
     Cookie newCookie = new Cookie("test_cookie_name", "test_cookie_value", ".amazon.com", "/",
            new GregorianCalendar(2020, 12,31).getTime(), true, true);
     driver.manage().addCookie(newCookie);

    }

}
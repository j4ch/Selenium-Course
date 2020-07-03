package Zadania;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Napisz test, który wykona następujące kroki:
 *
 * Otworzy stronę główną Wikipedii.
 * Następnie otworzy stronę główną Nasa.
 * Cofnie się do strony Wikipedii (używając nawigacji wstecz).
 * Potwierdź, że driver jest na stronie Wikipedii: porównaj (Assertions.assertEquals()) tytuł strony z oczekiwanym.
 * Przejdź do strony Nasa (używając nawigacji naprzód).
 * Potwierdź, że driver jest na stronie Nasa: porównaj tytuł strony z oczekiwanym.
 * Zamknij okno przeglądarki.
 * Zamknij sesję.
 * Pamiętaj o inicjalizacji WebDrivera i podaniu ścieżki do ChromeDrivera.
 *
 */

public class NavigationAndClosingZadanie {

    WebDriver driver;

    @BeforeEach
    public void driverSetup(){
        System.setProperty("webdriver.chrome.driver","C:/webdriver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1295, 730));
    }

    @AfterEach
    public void driverClose(){
        driver.quit();
    }

    @Test
    public void newTest(){
    driver.navigate().to("https://wikipedia.com");
    driver.navigate().to("http://nasa.gov");
    driver.navigate().back();
    Assertions.assertEquals(driver.getTitle(), "Wikipedia", "wrong page title(wiki)");
    driver.navigate().forward();
    Assertions.assertEquals(driver.getTitle(), "NASA", "wrong page title(nasa)");
    driver.close();
    }

}

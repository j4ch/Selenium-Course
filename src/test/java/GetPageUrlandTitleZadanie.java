import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Napisz prosty test lokalizacji. Kroki:
 * Przejdź na stronę http://wikipedia.pl
 * Napisz trzy asercje:
 * porównaj tytuł strony z oczekiwanym;
 * porównaj URL strony z oczekiwanym;
 * znajdź w konsoli deweloperskiej (F12) w zakładce Elements jakiś fragment źródła strony, który mówi o tym w jakiej wersji językowej jest strona; użyj tego fragmentu źródła do asercji.
 * Zmień język strony na hiszpański (By.cssSelector("a[title='hiszpański']")).
 * Napisz trzy asercje:
 * porównaj tytuł strony z oczekiwanym;
 * porównaj URL strony z oczekiwanym;
 * znajdź w konsoli deweloperskiej (F12) w zakładce Elements jakiś fragment źródła strony, który mówi o tym w jakiej wersji językowej jest strona; użyj tego fragmentu źródła do asercji.
 */

public class GetPageUrlandTitleZadanie {

    WebDriver driver;

    @BeforeEach
    public void setDriver(){
        System.setProperty("webdriver.chrome.driver", "C:/webdriver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1295, 730));
    }

    @AfterEach
    public void closeDriver(){
        driver.close();
        driver.quit();
    }

    @Test
    public void mainTest(){
        String wikiTitle = "Wikipedia, wolna encyklopedia";
        String wikiTitleEs = "Wikipedia, la enciclopedia libre";
        String wikiCode = "lang=\"pl\"";

        String wikiUrl = "https://pl.wikipedia.org/wiki/Wikipedia:Strona_g%C5%82%C3%B3wna";
        String wikiUrlEs = "https://es.wikipedia.org/wiki/Wikipedia:Portada";
        String wikiCodeEs = "\"es\"";

        driver.get("http://pl.wikipedia.org");
        Assertions.assertEquals(driver.getTitle(), wikiTitle, "Wikipedia title is wrong");
        Assertions.assertEquals(driver.getCurrentUrl(), wikiUrl, "wikipedia url is wrong");
        Assertions.assertTrue(driver.getPageSource().contains(wikiCode), "lang pl not included");

        WebElement language = driver.findElement(By.cssSelector("a[title='hiszpański']"));
        language.click();
        Assertions.assertEquals(driver.getTitle(), wikiTitleEs, "Title of Es version is wrong");
        Assertions.assertEquals(driver.getCurrentUrl(), wikiUrlEs, "Url of Es version is wrong");
        Assertions.assertTrue(driver.getPageSource().contains(wikiCodeEs), "lang pl not included");

    }

}

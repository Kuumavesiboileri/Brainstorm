/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jarlerik
 */
import java.io.File;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.Select;

public class Tester {
    private static HtmlUnitDriver driver;
    private static WebElement element;
   
    public static void main(String[] args) {
        WebDriver driver = new HtmlUnitDriver();
        driver.get("http://localhost:9090");
        System.out.println( driver.getPageSource() );
        WebElement dropDownListBox = driver.findElement(By.id("selection"));
        Select clickThis = new Select(dropDownListBox);
        clickThis.selectByValue("Book");

        // added new book

        element = driver.findElement(By.id("tag"));
        element.sendKeys("tagi1");
        
        element = driver.findElement(By.id("author"));
        element.sendKeys("Pertti Kananen");

        element = driver.findElement(By.id("title"));
        element.sendKeys("Ergonomisten hammastikkujen historia ja vaikutus talouspolitiikaan 1800 -luvun Ruotsi-Suomessa");
        
        element = driver.findElement(By.id("book-publisher"));
        element.sendKeys("WSOY");
        
        element = driver.findElement(By.id("year"));
        element.sendKeys("1995");

        element = driver.findElement(By.id("submit"));
        element.click(); 

        // added new book 2

        dropDownListBox = driver.findElement(By.id("selection"));
        clickThis = new Select(dropDownListBox);
        clickThis.selectByValue("Book");
        element = driver.findElement(By.id("tag"));
        element.sendKeys("tagi2");
        
        element = driver.findElement(By.id("author"));
        element.sendKeys("Martti Vainio");

        element = driver.findElement(By.id("title"));
        element.sendKeys("Kielletyt aineet");
        
        element.sendKeys("WSOY");
        
        element = driver.findElement(By.id("year"));
        element.sendKeys("1995");

        element = driver.findElement(By.id("submit"));
        element.click(); 

        // added new article

        dropDownListBox = driver.findElement(By.id("selection"));
        clickThis = new Select(dropDownListBox);
        clickThis.selectByValue("Article");
        element = driver.findElement(By.id("tag"));
        element.sendKeys("tagi2");
        
        element = driver.findElement(By.id("author"));
        element.sendKeys("Jussi Paananen");

        element = driver.findElement(By.id("title"));
        element.sendKeys("Suomen MM -juhlimisen herattamasta pahennuksesta vuonna 2011 ja miten se peilaa nyky-yhteiskuntaamme");
        
        element = driver.findElement(By.id("journal"));
        element.sendKeys("Taysin turhia tieteellisia artikkeleita");
        
        element = driver.findElement(By.id("year"));
        element.sendKeys("2012");

        element = driver.findElement(By.id("submit"));
        element.click(); 

        // added new article 2

        dropDownListBox = driver.findElement(By.id("selection"));
        clickThis = new Select(dropDownListBox);
        clickThis.selectByValue("Article");
        element = driver.findElement(By.id("tag"));
        element.sendKeys("tagi2");
        
        element = driver.findElement(By.id("author"));
        element.sendKeys("Kalle Sääpallo");

        element = driver.findElement(By.id("title"));
        element.sendKeys("Brasilialaisten perhosten vaikutus Suomen sääoloissa - perhosvaikutus ilmastonmuutoksessa");
        
        element = driver.findElement(By.id("journal"));
        element.sendKeys("Sää ja mää");
        
        element = driver.findElement(By.id("year"));
        element.sendKeys("2012");

        element = driver.findElement(By.id("submit"));
        element.click(); 
        element = driver.findElement(By.name("etsi"));
        element.sendKeys("sää");
        element = driver.findElement(By.id("search-submit"));
        element.click();
        System.out.println(driver.getPageSource());
    }
}

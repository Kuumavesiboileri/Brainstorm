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
   
    public static void main(String[] args) {
        WebDriver driver = new HtmlUnitDriver();
        String url = "http://localhost:8080";
        System.out.println(driver.getPageSource());
       
        driver.get(url);
        WebElement dropDownListBox = driver.findElement(By.id("selection"));
        Select clickThis = new Select(dropDownListBox);
        clickThis.selectByValue("Article");
        
        // add new book
         
        WebElement element = driver.findElement(By.id("tag"));
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
        
        //add new article
        dropDownListBox = driver.findElement(By.id("selection"));
        clickThis = new Select(dropDownListBox);
        clickThis.selectByValue("Book");
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
        
        element = driver.findElement(By.id("genBib"));
        element.click();
        String userName = System.getProperty("user.name");
        File file = new File("/cs/fs/home/"+userName+"/Downloads/bibtex.bib");
        System.out.println(file.exists());
        
        System.out.println(userName);
        
    }
}

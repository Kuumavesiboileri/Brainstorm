/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jarlerik
 */
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
         System.out.print(driver.getPageSource());
    }
}

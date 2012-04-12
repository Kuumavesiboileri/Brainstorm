import ohtu.*
import ohtu.authentication.*
import org.openqa.selenium.*
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

description 'User can log in with valid username/password-combination'

scenario "user can add a new book", {
    given 'user is on home page', {
        driver = new HtmlUnitDriver();
        driver.get("http://localhost:8080");
    }

    when 'a required fields are given', {
        element = driver.findElement(By.id("book-tag"));
        element.sendKeys("tagi1");
        
        element = driver.findElement(By.id("book-author"));
        element.sendKeys("Pertti Kananen");

        element = driver.findElement(By.id("book-title"));
        element.sendKeys("Ergonomisten hammastikkujen historia ja vaikutus talouspolitiikaan 1800 -luvun Ruotsi-Suomessa");
        
        element = driver.findElement(By.id("publisher"));
        element.sendKeys("WSOY");
        
        element = driver.findElement(By.id("book-year"));
        element.sendKeys("1995");

        element = driver.findElement(By.id("book-add"));
        element.click(); 
    }
    then 'new book has been added', {
        driver.getPageSource().contains("Ergonomisten hammastikkujen historia ja vaikutus talouspolitiikaan 1800 -luvun Ruotsi-Suomessa").shouldBe true
    }
}
scenario "user can add a new article", {
    given 'user is on home page', {
        driver = new HtmlUnitDriver();
        driver.get("http://localhost:8080");
    }

    when 'a required fields are given', {
        element = driver.findElement(By.id("article-tag"));
        element.sendKeys("tagi2");
        
        element = driver.findElement(By.id("article-author"));
        element.sendKeys("Jussi Paananen");

        element = driver.findElement(By.id("article-title"));
        element.sendKeys("Suomen MM -juhlimisen herattamasta pahennuksesta vuonna 2011 ja miten se peilaa nyky-yhteiskuntaamme");
        
        element = driver.findElement(By.id("journal"));
        element.sendKeys("Taysin turhia tieteellisia artikkeleita");
        
        element = driver.findElement(By.id("article-year"));
        element.sendKeys("2012");

        element = driver.findElement(By.id("article-add"));
        element.click(); 
    }
    then 'new article has been added', {
        driver.getPageSource().contains("Suomen MM -juhlimisen herattamasta pahennuksesta vuonna 2011 ja miten se peilaa nyky-yhteiskuntaamme").shouldBe true
    }
}
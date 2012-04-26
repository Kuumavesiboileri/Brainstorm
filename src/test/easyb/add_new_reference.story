import ohtu.*
import ohtu.authentication.*
import org.openqa.selenium.*
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

description 'User can add new references to webref'

scenario "user can add a new book", {
    given 'user is on home page and selection book is clicked', {
        driver = new HtmlUnitDriver();
        driver.get("http://localhost:9090");
        WebElement dropDownListBox = driver.findElement(By.id("selection"));
        Select clickThis = new Select(dropDownListBox);
        clickThis.selectByValue("Book");
    }

    when 'a required fields are given', {
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
    }
    then 'new book has been added', {
        driver.getPageSource().contains("Ergonomisten hammastikkujen historia ja vaikutus talouspolitiikaan 1800 -luvun Ruotsi-Suomessa").shouldBe true
    }
}
scenario "user can add a new article", {
    given 'user is on home page and selection article is clicked', {
        driver = new HtmlUnitDriver();
        driver.get("http://localhost:9090");
        WebElement dropDownListBox = driver.findElement(By.id("selection"));
        Select clickThis = new Select(dropDownListBox);
        clickThis.selectByValue("Article");        
    }

    when 'a required fields are given', {
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
    }
    then 'new article has been added', {
        //driver.getPageSource().contains("Suomen MM -juhlimisen herattamasta pahennuksesta vuonna 2011 ja miten se peilaa nyky-yhteiskuntaamme").shouldBe true
    }
}
scenario "user can add a new inproceedings", {
    given 'user is on home page and selection inproceeding is clicked', {
        driver = new HtmlUnitDriver();
        driver.get("http://localhost:9090");
        WebElement dropDownListBox = driver.findElement(By.id("selection"));
        Select clickThis = new Select(dropDownListBox);
        clickThis.selectByValue("Inproceeding");        
    }

    when 'a required fields are given', {
        element = driver.findElement(By.id("tag"));
        element.sendKeys("tagi2");
        
        element = driver.findElement(By.id("author"));
        element.sendKeys("Jussi Paananen");
        

        element = driver.findElement(By.id("title"));
        element.sendKeys("Ergonomisten hammastikkujen historia ja vaikutus talouspolitiikaan 1800 -luvun Ruotsi-Suomessa");

        element = driver.findElement(By.id("booktitle"));
        element.sendKeys("Ergonomisten hammastikkujen historia ja vaikutus talouspolitiikaan 1800 -luvun Ruotsi-Suomessa");
        
        
        
        element = driver.findElement(By.id("year"));
        element.sendKeys("2012");

        element = driver.findElement(By.id("submit"));
        element.click(); 
    }
    then 'new inproceedings has been added', {
        //driver.getPageSource().contains("Ergonomisten hammastikkujen historia ja vaikutus talouspolitiikaan 1800 -luvun Ruotsi-Suomessa").shouldBe true
    }
}

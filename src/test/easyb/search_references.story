import ohtu.*
import ohtu.authentication.*
import org.openqa.selenium.*
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

description 'User can search references'

scenario "user can search for articles", {
    given 'user is on home and there is multiple rererences on database. User inserts into serch field keys "book" and clicks search', {
        driver = new HtmlUnitDriver();
        driver.get("http://localhost:9090");
        WebElement dropDownListBox = driver.findElement(By.id("selection"));
        Select clickThis = new Select(dropDownListBox);
        clickThis.selectByValue("Book");

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
    }

    when 'search by field is given md search by is clicked', {
        element = driver.findElement(By.name("etsi"));
        element.sendKeys("article");
        element = driver.findElement(By.id("search-submit"));
        element.click();
    }
    then '2 matches have been found', {
        driver.getPageSource().contains("Suomen MM -juhlimisen herattamasta pahennuksesta vuonna 2011 ja miten se peilaa nyky-yhteiskuntaamme").shouldBe true
        driver.getPageSource().contains("Brasilialaisten perhosten vaikutus Suomen sääoloissa - perhosvaikutus ilmastonmuutoksessa").shouldBe true
    }
}

scenario "tag can be added to a reference", {
    given 'a reference has been added', {
        driver = new HtmlUnitDriver();
        driver.get("http://localhost:9090");
        WebElement dropDownListBox = driver.findElement(By.id("selection"));
        Select clickThis = new Select(dropDownListBox);
        clickThis.selectByValue("Book");

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
    }
    when 'a tag is added',{
        element = driver.findElement(By.name("newTag"));
        element.sendKeys("mehumaija");
        element = driver.findElement(By.id("tagsubmit"));
    }
    then 'it is added to the reference', {
        driver.getPageSource().contains("mehumaija").shouldBe true
    }
}
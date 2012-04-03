/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package viitteenhallinta;

/**
 *
 * @author todjalka
 */
public class Book implements Viite {

    private Parser parser;
    private String tag;
    //Required fields: author/editor, title, publisher, year
    private String author;
    private String title;
    private String publisher;
    private int year;
    //Optional fields: volume/number, series, address, edition, month, note, key
    private int volume;
    private String series;
    private String address;
    private String edition;
    private String month;
    private String note;
    private String key;

    public Book(String tag, String author, String title, String publisher, int year, Parser parser) {
        this.tag = tag;
        this.author = author;
        this.title = title;
        this.publisher = publisher;
        this.year = year;
        this.parser = parser;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public void setKey(String key) {
        this.key = key;
    }
 
/*@BOOK (V78,
AUTHOR = "L. S. Vygotsky",
TITLE= "Mind in Society: The Development of Higher Psychological Processes",
PUBLISHER = "Harvard University Press",
YEAR = 1978,
ADDRESS = "Cambridge, MA",
) */
    public String toLaTexString() {
        String palauta = "@Book(" + tag + ",\n";
        palauta += "AUTHOR = {" + parser.parse(author) + "},\n";
        palauta += "TITLE = {" + parser.parse(title) + "},\n";
        palauta += "PUBLISHER = {" + parser.parse(publisher) + "},\n";
        palauta += "YEAR = {" + year + "},\n";
        palauta += addOptionalsToLaTex();
        return palauta + ")";
    }

    public String toReadableString() {
        String palauta = "Author: " + author
                + "\nTitle: " + title
                + "\nPublisher: " + publisher
                + "\nYear: " + year;
        palauta += addOptionalsToReadable();
        return palauta;
    }
    
    private String addOptionalsToReadable() {
        String palautettava = "";
        if (volume != 0) {
            palautettava += "\nVolume: " + volume;
        }
        if (series != null) {
            palautettava += "\nSeries: " + series;
        }
        if (address != null) {
            palautettava += "\nAddress: " + address;
        }
        if (edition != null) {
            palautettava += "\nEdition: " + edition;
        }
        if (month != null) {
            palautettava += "\nMonth: " + month;
        }   
         if (note != null) {
            palautettava += "\nNote: " + note;
        }    
          if (key != null) {
            palautettava += "\nKey: " + key;
        }    
        return palautettava;
    }
    
    private String addOptionalsToLaTex() {
         String palautettava = "";
        if (volume != 0) {
            palautettava += "VOLUME = {" + volume + "},\n";
        }
        if (series != null) {
            palautettava += "SERIES = {" + parser.parse(series) + "},\n";
        }
        if (address != null) {
            palautettava += "ADDRESS = {" + parser.parse(address) + "},\n";
        }
        if (edition != null) {
            palautettava += "EDITION = {" + parser.parse(edition) + "},\n";
        }
        if (month != null) {
            palautettava += "MONTH = {" + parser.parse(month) + "},\n";
        }   
         if (note != null) {
            palautettava += "NOTE = {" + parser.parse(note) + "},\n";
        }    
          if (key != null) {
            palautettava += "KEY = {" + parser.parse(key) + "},\n";
        }    
        return palautettava;
    }
}

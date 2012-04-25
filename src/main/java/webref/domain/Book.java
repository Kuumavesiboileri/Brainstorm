/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package webref.domain;

/**
 *
 * @author todjalka
 */
public class Book implements Viite {

    private String refName;
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

    public Book() {
    }
    

    public Book(String refName, String author, String title, String publisher, int year) {
        this.refName = refName;
        this.author = author;
        this.title = title;
        this.publisher = publisher;
        this.year = year;
    }

    public Book(String refName, String author, String title, String publisher, int year, int volume, String series, String address, String edition, String month, String note, String key) {
        this.refName = refName;
        this.author = author;
        this.title = title;
        this.publisher = publisher;
        this.year = year;
        this.volume = volume;
        this.series = series;
        this.address = address;
        this.edition = edition;
        this.month = month;
        this.note = note;
        this.key = key;
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
    public String toLaTexString(Parser parser) {
        String palauta = "@Book(" + parser.parse(refName) + ",\n";
        palauta += "AUTHOR = {" + parser.parse(author) + "},\n";
        palauta += "TITLE = {" + parser.parse(title) + "},\n";
        palauta += "PUBLISHER = {" + parser.parse(publisher) + "},\n";
        palauta += "YEAR = {" + year + "},\n";
        palauta += addOptionalsToLaTex(parser);
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
    
    private String addOptionalsToLaTex(Parser parser) {
         String palautettava = "";
        if (volume != 0) {
            palautettava += "VOLUME = {" + volume + "},\n";
        }
        if (series != null && !series.equals("")) {
            palautettava += "SERIES = {" + parser.parse(series) + "},\n";
        }
        if (address != null && !address.equals("")) {
            palautettava += "ADDRESS = {" + parser.parse(address) + "},\n";
        }
        if (edition != null && !edition.equals("")) {
            palautettava += "EDITION = {" + parser.parse(edition) + "},\n";
        }
        if (month != null && !month.equals("")) {
            palautettava += "MONTH = {" + parser.parse(month) + "},\n";
        }   
         if (note != null && !note.equals("")) {
            palautettava += "NOTE = {" + parser.parse(note) + "},\n";
        }    
          if (key != null && !key.equals("")) {
            palautettava += "KEY"
                    + " = {" + parser.parse(key) + "},\n";
        }    
        return palautettava;
    }

    public String getAddress() {
        return address;
    }

    public String getAuthor() {
        return author;
    }

    public String getEdition() {
        return edition;
    }

    public String getKey() {
        return key;
    }

    public String getMonth() {
        return month;
    }

    public String getNote() {
        return note;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getSeries() {
        return series;
    }

    public String getTag() {
        return refName;
    }

    public String getTitle() {
        return title;
    }

    public int getVolume() {
        return volume;
    }

    public int getYear() {
        return year;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setTag(String tag) {
        this.refName = tag;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setYear(int year) {
        this.year = year;
    }
    
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package viitteenhallinta;

/**
 *
 * @author todjalka
 */
public class Article implements Viite {

    private Parser parser;
    private String tag;
    //required fields: author, title, journal, year
    private String author;
    private String title;
    private String journal;
    private int year;
    //Optional fields: volume, number, pages, month, note, key
    private int volume;
    private int number;
    private String pages;
    private String month;
    private String note;
    private String key;

    public Article(String tag, String author, String title, String journal, int year, Parser parser) {
        this.tag = tag;
        this.author = author;
        this.title = title;
        this.journal = journal;
        this.year = year;
        this.parser = parser;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setPages(String pages) {
        this.pages = pages;
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

    public String toLaTexString() {
        String palauta = "@Article(" + tag + ",\n";
        palauta += "AUTHOR = {" + parser.parse(author) + "},\n";
        palauta += "TITLE = {" + parser.parse(title) + "},\n";
        palauta += "JOURNAL = {" + parser.parse(journal) + "},\n";
        palauta += "YEAR = {" + year + "},\n";
        palauta += addOptionalsToLaTex();
        return palauta + ")";
    }

    public String toReadableString() {
        String palauta = "Author: " + author
                + "\nTitle: " + title
                + "\nJournal: " + journal
                + "\nYear: " + year;
        palauta += addOptionalsToReadable();
        return palauta;
    }

    private String addOptionalsToReadable() {
        String palautettava = "";
        if (volume != 0) {
            palautettava += "\nVolume: " + volume;
        }
        if (number != 0) {
            palautettava += "\nNumber: " + number;
        }
        if (pages != null) {
            palautettava += "\nPages: " + pages;
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
        if (number != 0) {
            palautettava += "NUMBER = {" + number + "},\n";
        }
        if (pages != null) {
            palautettava += "PAGES = {" + parser.parse(pages) + "},\n";
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

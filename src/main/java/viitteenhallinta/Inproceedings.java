/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package viitteenhallinta;

/**
 *
 * @author todjalka
 */
public class Inproceedings implements Viite {

    private Parser parser;
    private String tag;
    //Required fields: author/editor, title, booktitle, year
    private String author;
    private String title;
    private String booktitle;
    private int year;
    //Optional fields: editor,volume/number, series, pages, address, month, organization, publisher, note, key
    private String editor;
    private int volume;
    private String series;
    private String pages;
    private String address;
    private String month;
    private String organization;
    private String publisher;
    private String note;
    private String key;

    public Inproceedings(String tag, String author, String title, String booktitle, int year, Parser parser) {
        this.tag = tag;
        this.author = author;
        this.title = title;
        this.booktitle = booktitle;
        this.year = year;
        this.parser = parser;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }
    public void setVolume(int volume) {
        this.volume = volume;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public void setPages(String pages) {
        this.pages = pages;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String toLaTexString() {
        String palauta = "@InProceedings(" + tag + ",\n";
        palauta += "AUTHOR = {" + parser.parse(author) + "},\n";
        palauta += "TITLE = {" + parser.parse(title) + "},\n";
        palauta += "BOOKTITLE = {" + parser.parse(booktitle) + "},\n";
        palauta += "YEAR = {" + year + "},\n";
        palauta += addOptionalsToLaTex();
        return palauta + ")";
    }

    public String toReadableString() {
        String palauta = "Author: " + author
                + "\nTitle: " + title
                + "\nBooktitle: " + booktitle
                + "\nYear: " + year;
        palauta += addOptionalsToReadable();
        return palauta;
    }

    private String addOptionalsToReadable() {
        String palautettava = "";
        if (editor != null) {
            palautettava += "\nEditor: " + editor;
        }
        if (volume != 0) {
            palautettava += "\nVolume: " + volume;
        }
        if (series != null) {
            palautettava += "\nSeries: " + series;
        }
        if (pages != null) {
            palautettava += "\nPages: " + pages;
        }
        if (address != null) {
            palautettava += "\nAddress: " + address;
        }
        if (month != null) {
            palautettava += "\nMonth: " + month;
        }
        if (organization != null) {
            palautettava += "\nOrganization: " + organization;
        }
        if (publisher != null) {
            palautettava += "\nPublisher: " + publisher;
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
        if (editor != null) {
            palautettava += "EDITOR = {" + parser.parse(editor) + "},\n";
        }
        if (volume != 0) {
            palautettava += "VOLUME = {" + volume + "},\n";
        }
        if (series != null) {
            palautettava += "SERIES = {" + parser.parse(series) + "},\n";
        }
        if (pages != null) {
            palautettava += "PAGES = {" + parser.parse(pages) + "},\n";
        }
        if (address != null) {
            palautettava += "ADDRESS = {" + parser.parse(address) + "},\n";
        }
        if (month != null) {
            palautettava += "MONTH = {" + parser.parse(month) + "},\n";
        }
        if (organization != null) {
            palautettava += "ORGANIZATION = {" + parser.parse(organization) + "},\n";
        }
        if (publisher != null) {
            palautettava += "PUBLISHER = {" + parser.parse(publisher) + "},\n";
        }
        if (note != null) {
            palautettava += "NOTE = {" + parser.parse(note) + "},\n";
        }
        if (key != null) {
            palautettava += "KEY"
                    + " = {" + parser.parse(key) + "},\n";
        }
        return palautettava;
    }
}
